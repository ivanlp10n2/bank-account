package persistence

class InMemoryDatabase implements infrastructure.shared.InMemoryDatabase{

    List<String> noSQL

    InMemoryDatabase(){
        noSQL = new ArrayList<>()
    }

    @Override
    def findUser(long userId) {
        noSQL.find(json ->
                json.id == userId
        )
    }

    @Override
    def findAccount(long accountId) {
        noSQL.find(json ->
                json.id == accountId
        )
    }
}
