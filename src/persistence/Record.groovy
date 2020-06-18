package persistence

/**
 * Stores index and value. Search is only implemented by IndexId
 * */
class Record {
    RecordId id
    Object data

    Record(RecordId id, Object data){
        this.id = id
        this.data = data
    }

    @Override
    boolean equals(Object obj) {
        return super.equals(obj)
    }
    class RecordId {
        String id

        RecordId(String newId){
            id = newId
        }

        @Override
        boolean equals(Object obj) {
            obj &&
                (obj as RecordId).id == this.id
        }
    }
}
