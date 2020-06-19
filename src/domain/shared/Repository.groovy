package domain.shared

interface Repository<T, ID extends AggregateId> {
    T find(ID identifier)
    void add(T obj)
    T update(T obj)
}