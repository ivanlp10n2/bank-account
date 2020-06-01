package infrastructure.shared

trait Repository<T, ID> {

    abstract T find(ID identifier)
}