package persistence.client

import domain.client.Client
import persistence.client.pogo.ClientPogo
import persistence.shared.PogoMapper

class ClientPogoMapper implements PogoMapper<Client, ClientPogo>{

    @Override
    Client map(ClientPogo obj) {
        return null
    }
}