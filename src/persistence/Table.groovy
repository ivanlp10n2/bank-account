package persistence

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
            record.id == recordId
        }?.data
    }

    Record update(Record record){
        Record persistedRecord = find(record.id)
        if (!persistedRecord)
            throw new RecordNotFound()
        if (locked)
            throw new LockedTableException()

        persistedRecord.data = record.data
    }

    enum Name {
        CLIENT

    }
}
