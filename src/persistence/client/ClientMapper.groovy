package persistence.client

import domain.client.Client
import domain.client.account.Account
import infrastructure.shared.Mapper
import persistence.client.account.AccountMapper
import persistence.client.model.ClientDTO

class ClientMapper implements Mapper<Client, ClientDTO>{

    Mapper accountMapper

    ClientMapper(){
        accountMapper = new AccountMapper()
    }
    @Override
    ClientDTO map(Client client) {
        new ClientDTO(  client.id.name,
                        accountMapper.map(client.account))
    }

    @Override
    Client map(ClientDTO client) {
        Client.ClientId clientId = new Client.ClientId(client.id)
        Account account = accountMapper.map(client.account)
        new Client(clientId, account)
    }
}