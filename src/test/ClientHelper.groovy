package test

import domain.client.Client
import domain.client.ClientFactory
import domain.client.ClientRepository
import domain.client.account.money.Money
import infrastructure.client.ClientFactoryImpl
import infrastructure.client.ClientRepositoryImpl

class ClientHelper {
    private final ClientFactory clientFactory
    private final ClientRepository clientRepository

    ClientHelper(){
        clientRepository = new ClientRepositoryImpl()
        clientFactory = new ClientFactoryImpl()
    }

    void createClientWithDollar(String name, BigDecimal amount){
        Client client = clientFactory.withMoney( name, Money.dollar(amount))
        clientRepository.add(client)
    }
}
