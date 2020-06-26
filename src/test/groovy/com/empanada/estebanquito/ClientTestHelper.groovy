package com.empanada.estebanquito

import com.empanada.estebanquito.domain.client.Client
import com.empanada.estebanquito.domain.client.ClientFactory
import com.empanada.estebanquito.domain.client.ClientRepository
import com.empanada.estebanquito.domain.client.account.money.Money
import com.empanada.estebanquito.infrastructure.client.ClientFactoryImpl
import com.empanada.estebanquito.infrastructure.client.ClientRepositoryImpl

class ClientTestHelper {
    private final ClientFactory clientFactory
    private final ClientRepository clientRepository

    ClientTestHelper(){
        clientRepository = new ClientRepositoryImpl()
        clientFactory = new ClientFactoryImpl()
    }

    void createAndSaveClientWithDollar(String name, BigDecimal amount){
        Client client = clientFactory.withMoney( name, Money.dollar(amount))
        clientRepository.add(client)
    }
}
