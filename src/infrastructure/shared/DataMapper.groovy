package infrastructure.shared

interface DataMapper<T, K> {
    T map(K obj)
}