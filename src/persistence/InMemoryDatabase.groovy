package persistence


import persistence.shared.DataSource
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
    void create(Table.Name tableName, Record obj) {
        if (!tableName in tables*.name)
            tables << Table.create(tableName)

        Table table = tables.getAt(tableName)
        table.add(obj)
    }

    @Override
    Record findById(Table.Name tableName, Record.RecordId recordId) {
        if (!tableName in tables*.name)
            throw new TableNotFoundException()

        Table table = tables.getAt(tableName)
        table.find(recordId)
    }

    @Override
    void update(Table.Name tableName, Record obj) {
        if (!tableName in tables*.name)
           throw new TableNotFoundException()

        Table table = tables.getAt(tableName)
        table.update(obj)

    }
}