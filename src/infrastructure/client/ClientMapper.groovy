package infrastructure.client

import domain.client.Client
import domain.client.account.Account
import infrastructure.client.account.AccountMapper
import infrastructure.shared.Mapper

class ClientMapper implements Mapper<Client, infrastructure.client.account.model.ClientDTO>{

    Mapper accountMapper

    ClientMapper(){
        accountMapper = new AccountMapper()
    }
    @Override
    infrastructure.client.account.model.ClientDTO map(Client client) {
        new infrastructure.client.account.model.ClientDTO(  client.id.name,
                        accountMapper.map(client.account))
    }

    @Override
    Client map(infrastructure.client.account.model.ClientDTO client) {
        Client.ClientId clientId = new Client.ClientId(client.id)
        Account account = accountMapper.map(client.account)
        new Client(clientId, account)
    }
}