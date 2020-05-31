package infrastructure.client

import domain.account.Account
import domain.account.AccountFactory
import domain.account.Money
import domain.client.Client
import domain.client.ClientFactory
import infrastructure.account.AccountFactoryImpl
import infrastructure.shared.Utils


class ClientFactoryImpl implements ClientFactory{

    AccountFactory accountFactory

    ClientFactoryImpl(){
        this.accountFactory = new AccountFactoryImpl()
    }

    @Override
    Client withMoney(String name, Money money) {
        Client.ClientId id = new Client.ClientId(Utils.random(), name)
        withMoney(id, money)
    }

    Client withMoney(Client.ClientId id, Money money) {
        Client newClient= new Client(id)
        newClient.assignAccount(accountFactory.withMoney(newClient, money))
    }

    @Override
    Client empty(Client.ClientId id) {
        Client newClient = new Client(id)
        Account emptyAccount = AccountFactory.empty(newClient)
        newClient.assignAccount(emptyAccount)
    }

}
