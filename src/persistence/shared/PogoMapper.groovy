package persistence.shared

import infrastructure.shared.DataMapper

interface PogoMapper<T, K extends Pogo> extends DataMapper<T, K>{
    /**
     * maps an Aggregates to Pogo
     * */
    abstract T map(K obj)
}
