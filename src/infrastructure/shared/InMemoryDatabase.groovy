package infrastructure.shared

import domain.client.Client

interface InMemoryDatabase {
    saveUser(Client client)
    findUser(long clientId)
    findAccount(long accountId)

}