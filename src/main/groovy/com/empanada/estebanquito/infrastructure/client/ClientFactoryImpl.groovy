package com.empanada.estebanquito.infrastructure.client

import com.empanada.estebanquito.domain.client.Client
import com.empanada.estebanquito.domain.client.ClientFactory
import com.empanada.estebanquito.domain.client.account.Account
import com.empanada.estebanquito.domain.client.account.AccountFactory
import com.empanada.estebanquito.domain.client.account.money.Money
import com.empanada.estebanquito.infrastructure.client.account.AccountFactoryImpl


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
