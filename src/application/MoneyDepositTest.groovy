package application

import domain.client.Client
import domain.client.ClientFactory
import groovy.test.GroovyTestCase
import infrastructure.client.ClientFactoryImpl
import domain.account.Money

class MoneyDepositTest extends GroovyTestCase{
    ClientFactory clientFactory
    MoneyTransaction useCase

    MoneyDepositTest(){
        this.clientFactory = new ClientFactoryImpl()
        this.useCase = new MoneyTransaction()
    }

    void depositMoney() {
        Client client = clientFactory.withMoney("francisco", Money.Factory.of(100))
        useCase.depositMoney(client, Money.Factory.of(100))
        print client.accountBalance()
    }
}
