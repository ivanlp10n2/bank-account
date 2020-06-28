package com.empanada.banking.infrastructure.client

import com.empanada.banking.domain.client.Client
import com.empanada.banking.domain.client.ClientFactory
import com.empanada.banking.domain.client.account.Account
import com.empanada.banking.domain.client.account.AccountFactory
import com.empanada.banking.domain.client.account.money.Money
import com.empanada.banking.infrastructure.client.account.AccountFactoryImpl

class ClientFactoryImpl implements ClientFactory{

    AccountFactory accountFactory

    ClientFactoryImpl(){
        this.accountFactory = new AccountFactoryImpl()
    }

    @Override
    Client withMoney(String name, Money money) {
        Client.ClientId id = new Client.ClientId(name)
        withMoney(id, money)
    }

    Client withMoney(Client.ClientId id, Money money) {
        Client newClient= new Client(id)
        newClient.assignAccount(accountFactory.withMoney(newClient, money))
    }

    @Override
    Client empty(Client.ClientId id) {
        Client newClient = new Client(id)
        Account emptyAccount = Account.empty(newClient)
        newClient.assignAccount(emptyAccount)
    }

}
