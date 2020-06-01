package infrastructure.account

import domain.account.Account
import domain.account.AccountFactory
import domain.client.Client
import domain.account.money.Money

class AccountFactoryImpl implements AccountFactory{

    @Override
    Account empty(Client client) {
        assert validate(client)
        new Account(client, Money.ZERO)
    }

    @Override
    Account withMoney(Client client, Money money) {
        assert validate(client)
        assert validate(money)
        new Account(client, money)
    }

    private boolean validate(Client client){
        true
    }

    private boolean validate(Money money){
        true
    }
}
