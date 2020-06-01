package infrastructure.shared

interface DataMapper<T> {

    T map(String json)
}