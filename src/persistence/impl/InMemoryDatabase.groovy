package persistence.impl

import infrastructure.shared.AggregateDTO
import infrastructure.shared.DTO
import persistence.api.DataSource
/**
 * does not include schema impl
 * */
enum InMemoryDatabase implements DataSource{
    INSTANCE

    private Set<Table> tables

    private InMemoryDatabase(){
        tables = new HashSet<>()
    }

    synchronized static InMemoryDatabase getInstance(){
        INSTANCE
    }

    @Override
    void create(String sTableName, AggregateDTO dto) {
        Table.Name tableName = Table.Name.valueOf(sTableName)
        if (!tableName)
            throw new TableNotFoundException()

        Record.RecordId id = new Record.RecordId(dto.getAggregateId())
        Record record = new Record(id, dto)
        Table table = findOrCreateTable(tableName)
        table.add(record)
    }

    private Table findOrCreateTable(Table.Name tableName){
        if (! (tableName in tables*.name) )
            tables << Table.create(tableName)

        tables.find{ Table table ->
            table.name == tableName
        }
    }

    @Override
    DTO findById(String sTableName, AggregateDTO dto) {
        Table.Name tableName = Table.Name.valueOf(sTableName)
        if (!tableName)
            throw new TableNotFoundException()

        Record.RecordId id = new Record.RecordId(dto.getAggregateId())
        Table table = tables.find{ Table table -> table.name == tableName }
        Record record = table.find(id)
        record.data
    }

    @Override
    void update(String sTableName, AggregateDTO dto) {
        Table.Name tableName = Table.Name.valueOf(sTableName)
        if (!tableName)
            throw new TableNotFoundException()

        Table table = tables.find{ Table table -> table.name == tableName }
        Record record = Record.of(dto.getAggregateId(), dto)
        table.update(record)

    }

}