package infrastructure.shared
/**
 * maps an Aggregates to serializable object to persist
 * */
interface DataMapper<T, K extends Serializable> extends Mapper<T, K>{
    abstract T map(K obj)
}
