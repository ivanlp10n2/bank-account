package com.empanada.persistence.shared

import static java.util.UUID.randomUUID

class Utils {
    static String random(){
        randomUUID() as String
    }
}
