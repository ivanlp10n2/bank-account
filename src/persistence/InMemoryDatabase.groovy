package persistence

import groovy.json.JsonSlurper
import infrastructure.shared.DataSource

enum InMemoryDatabase implements DataSource{
    INSTANCE

    private Map<String, String> data

    private InMemoryDatabase(){
        data = [:].withDefault {[]}
    }

    synchronized static InMemoryDatabase getInstance(){
        INSTANCE
    }

    @Override
    void add(String collection, String json) {
        data[collection] << json
    }

    @Override
    String findById(String collection, String id) {
        data[collection].find{ String row ->
            Map json = new JsonSlurper().parseText(row)
            id == json.id
        }
    }

    @Override
    void remove(String collection, String id) {

    }
}