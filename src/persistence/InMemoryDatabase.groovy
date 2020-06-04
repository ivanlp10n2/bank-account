package persistence

import domain.client.Client

class InMemoryDatabase implements infrastructure.shared.InMemoryDatabase{

    List<String> noSQL

    InMemoryDatabase(){
        noSQL = new ArrayList<>()
    }

    @Override
    def saveUser(Client client) {
        noSQL.create
    }

    @Override
    def findUser(long clientId) {
        noSQL.find(json ->
                json.id == clientId
        )
    }

    @Override
    def findAccount(long accountId) {
        noSQL.find(json ->
                json.id == accountId
        )
    }
}
