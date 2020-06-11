package domain.shared

interface Repository<T, ID> {
    T find(ID identifier)
    void add(T obj)
}