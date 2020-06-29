package com.empanada.persistence.memory


import com.empanada.persistence.shared.LockedTableException

class Table {
    final Name name
    private Set<Record> records
    private Boolean locked

    private Table(Name name, Set<Record> records, Boolean locked){
        this.name = name
        this.records = records
        this.locked = locked

    }

    static Table create(Name name){
        new Table(name, new HashSet<>(), false)
    }

    void add(Record record){
        if (locked)
            throw new LockedTableException()
        records << record
    }

    Record find(Record.RecordId recordId){
        records.find{ record ->
            record.recordId == recordId
        }
    }

    Record update(Record record){
        Record persistedRecord = find(record.recordId)
        if (!persistedRecord)
            throw new RecordNotFoundException()
        if (locked)
            throw new LockedTableException()

        persistedRecord.data = record.data
        persistedRecord
    }

    enum Name {
        Client

    }
}
