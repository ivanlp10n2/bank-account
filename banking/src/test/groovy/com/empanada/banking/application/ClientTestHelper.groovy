package com.empanada.banking.application

import com.empanada.banking.application.model.Dollars
import com.empanada.banking.domain.client.Client
import com.empanada.banking.domain.client.ClientFactory
import com.empanada.banking.domain.client.ClientRepository
import com.empanada.banking.domain.client.account.money.Money
import com.empanada.banking.infrastructure.client.ClientFactoryImpl
import com.empanada.banking.infrastructure.client.ClientRepositoryImpl


class ClientTestHelper {
    private final ClientFactory clientFactory
    private final ClientRepository clientRepository

    ClientTestHelper(){
        clientRepository = new ClientRepositoryImpl()
        clientFactory = new ClientFactoryImpl()
    }

    void createAndSaveClientWithDollar(String name, Dollars dollars){
        Client client = clientFactory.withMoney( name, Money.dollar(dollars.amount))
        clientRepository.add(client)
    }
}
