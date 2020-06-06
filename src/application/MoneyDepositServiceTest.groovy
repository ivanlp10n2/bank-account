package application

import application.model.DepositRequest
import domain.client.Client
import domain.client.ClientFactory
import domain.client.ClientRepository
import groovy.test.GroovyTestCase
import infrastructure.client.ClientFactoryImpl
import domain.account.money.Money
import infrastructure.client.ClientRepositoryImpl

class MoneyDepositServiceTest extends GroovyTestCase{
    private final ClientFactory clientFactory
    private final DepositUseCase useCase
    private final ClientRepository clientRepository

    MoneyDepositServiceTest(){
        this.clientFactory = new ClientFactoryImpl()
        this.useCase = new DepositService()
        clientRepository = new ClientRepositoryImpl()
        this.startup()
    }

    void startup(){
        Client client = clientFactory.withMoney("francisco", Money.dollar(100))
        clientRepository.add(client)
    }

    void depositMoney() {
        Client.ClientId id = new Client.ClientId("francisco")
        Money money = Money.dollar(10)
        DepositRequest request = DepositRequest.of(id, money)

        useCase.cashDeposit(request)

        print client.accountBalance()
    }
}
