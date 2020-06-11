package infrastructure.shared

interface DataSource {
    void add(String collection, String obj)
    String findById(String collection, String id)
    void remove(String collection, String id)
}