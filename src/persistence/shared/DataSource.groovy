package persistence.shared

import persistence.Record

import persistence.Table

interface DataSource {
    void create(Table.Name tableName, Record obj)
    Record findById(Table.Name tableName, Record.RecordId aggregateId)
    void update(Table.Name tableName, Record obj)

}