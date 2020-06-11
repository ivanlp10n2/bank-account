package domain.client

import domain.client.Client.ClientId
import domain.shared.Repository

interface ClientRepository extends Repository<Client, ClientId>{
    void addNewActivities(Client client)
}
