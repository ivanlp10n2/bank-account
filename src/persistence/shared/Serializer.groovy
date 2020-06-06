package persistence.shared

import groovy.json.JsonBuilder
import groovy.json.JsonSlurper

class Serializer {
    static String serialize(Pogo pogo) {
        new JsonBuilder(pogo).toString()
    }

    static Object deserialize(String json) {
        def serializer = new JsonSlurper()
        serializer.parse(json)
    }
}
