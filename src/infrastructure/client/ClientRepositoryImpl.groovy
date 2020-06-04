package infrastructure.client

import domain.client.Client
import domain.client.Client.ClientId
import domain.client.ClientRepository
import infrastructure.shared.InMemoryDatabase

class ClientRepositoryImpl implements ClientRepository{

    InMemoryDatabase db

    @Override
    Client find(ClientId clientId) {
        db.findUser(clientId)
    }

    @Override
    Client create() {
        new Client()
    }
}
