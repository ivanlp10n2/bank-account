package persistence

import infrastructure.shared.NoSQL

class NoSQLDatabase implements NoSQL, Database {
    private List<String> data
    private static NoSQLDatabase instance

    static NoSQLDatabase getInstance() {
        if (!instance)
            instance = new NoSQLDatabase()
        instance
    }

    private NoSQLDatabase(){
        data = new ArrayList<>()
    }

    @Override
    def add(String json) {
        return null
    }

    @Override
    Object find(String id) {
        return null
    }

    @Override
    def remove(String id) {
        return null
    }
}
