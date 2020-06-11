package persistence.shared

import groovy.json.JsonBuilder
import groovy.json.JsonSlurper
import infrastructure.shared.DTO

class Serializer {
    static String serialize(DTO pogo) {
        new JsonBuilder(pogo).toString()
    }

    static Map deserialize(String json) {
        new JsonSlurper().parseText(json)
    }
}
