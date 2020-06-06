package infrastructure.client

import domain.client.Client
import domain.client.Client.ClientId
import domain.client.ClientRepository
import infrastructure.shared.InMemoryDatabase
import persistence.NoSQLDatabase

class ClientRepositoryImpl implements ClientRepository{

    InMemoryDatabase db

    ClientRepositoryImpl(){
        db = NoSQLDatabase.getInstance()
    }

    @Override
    Client find(ClientId clientId) {
        db.findClient(clientId)
    }

    @Override
    void add(Client client) {
        db.saveClient(client)
    }
}
