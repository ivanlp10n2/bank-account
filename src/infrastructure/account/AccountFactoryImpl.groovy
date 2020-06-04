package infrastructure.account

import domain.account.Account
import domain.account.AccountFactory
import domain.client.Client
import domain.account.money.Money

class AccountFactoryImpl implements AccountFactory{

    @Override
    Account empty(Client client) {
        assert validate(client)
        Account.AccountId id = new Account.AccountId(client)
        new Account(id, Money.ZERO)
    }

    @Override
    Account withMoney(Client client, Money money) {
        assert validate(money)
        assert validate(client)
        Account.AccountId id = new Account.AccountId(client)
        new Account(id, money)
    }

    private boolean validate(Client client){
        true
    }

    private boolean validate(Money money){
        true
    }
}
