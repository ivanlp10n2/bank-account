package domain.client

import domain.client.Client.ClientId

interface ClientRepository {

   Client find(ClientId clientId)
   Client create()

}
