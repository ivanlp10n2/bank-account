package infrastructure.shared

interface NoSQL {
    void add(String serializedObj)
    def find(String id)
    void remove(String id)
}