package com.empanada.estebanquito.infrastructure.client

import com.empanada.estebanquito.domain.client.Client
import com.empanada.estebanquito.domain.client.account.Account
import com.empanada.estebanquito.infrastructure.client.account.AccountMapper
import com.empanada.estebanquito.infrastructure.client.account.model.ClientDTO
import com.empanada.estebanquito.infrastructure.shared.Mapper

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