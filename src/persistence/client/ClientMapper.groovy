package persistence.client

import domain.client.Client
import persistence.client.pogo.ClientSerializable
import infrastructure.shared.DataMapper

class ClientDataMapper implements DataMapper<Client, ClientSerializable>{

    @Override
    Client map(ClientSerializable obj) {
        return null
    }
}