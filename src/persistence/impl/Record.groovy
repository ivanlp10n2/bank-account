package persistence.impl

import infrastructure.shared.DTO

/**
 * Stores index and value. Search is only implemented by recordId
 * */
class Record {
    RecordId recordId
    DTO data

    Record(RecordId recordId, DTO data){
        this.recordId = recordId
        this.data = data
    }

    static Record of (String id, DTO data){
        new Record(new RecordId(id), data)
    }

    @Override
    boolean equals(Object obj) {
        obj &&
            this.recordId == (obj as Record).recordId
    }
    static class RecordId {
        final String id

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
