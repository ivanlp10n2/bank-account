package infrastructure.client

import domain.client.Client
import domain.client.ClientRepository
import infrastructure.shared.InMemoryDatabase

class ClientRepositoryImpl implements ClientRepository{

    InMemoryDatabase db

    @Override
    Client find(long userId) {
        db.findUser(userId)
    }

    @Override
    Client create() {
        new Client()
    }
}
