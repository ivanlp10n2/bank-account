package com.empanada.estebanquito.persistence.shared

import static java.util.UUID.randomUUID

class Utils {
    static String random(){
        randomUUID() as String
    }
}
