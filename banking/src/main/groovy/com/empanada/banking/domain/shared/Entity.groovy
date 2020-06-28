package com.empanada.banking.domain.shared

/**
 * Entity are evaluated by identity, not attributes
 * */
interface Entity<T> {

    /**
    * compares by identity
    * */
    boolean equalAs(T other)

}