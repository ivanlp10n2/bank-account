package com.empanada.banking.infrastructure.shared

import com.empanada.persistence.api.DTO

/**
 * maps an Aggregates to serializable object to persist
 * */
interface Mapper<T, K extends DTO>{
    K map(T obj)
    T map(K sObj)
}
