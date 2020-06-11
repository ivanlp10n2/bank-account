package infrastructure.shared

interface Database {
    void add(String collection, Serializable obj)
    def find(String collection, String id)
    void remove(String collection, String id)
}