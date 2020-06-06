package domain.client

import domain.client.Client.ClientId
import infrastructure.shared.Repository

interface ClientRepository extends Repository<Client, ClientId>{

}
