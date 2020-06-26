package main.groovy.com.empanada.estebanquito.domain.shared

/**
*  Value object is evaluated by its attributes.
**/
interface ValueObject<T> extends Serializable {

    /**
     * compared by all its attributes
     * */
    boolean sameAs(T other)
}