package application

import application.model.DepositRequest
import domain.client.Client
import domain.client.ClientFactory
import groovy.test.GroovyTestCase
import infrastructure.client.ClientFactoryImpl
import domain.account.money.Money

class MoneyDepositServiceTest extends GroovyTestCase{
    private final ClientFactory clientFactory
    private final DepositService useCase

    MoneyDepositServiceTest(){
        this.clientFactory = new ClientFactoryImpl()
        this.useCase = new DepositService()
        this.startup()
    }

    void startup(){
        
    }

    void depositMoney() {
        //Given
        Client client = clientFactory.withMoney("francisco", Money.Factory.dollar(100))
        DepositRequest request = DepositRequest.Factory.of(client.id, Money.Factory.dollar(10))

        //When
        useCase.cashDeposit(request)

        //Then
        print client.accountBalance()
    }
}
