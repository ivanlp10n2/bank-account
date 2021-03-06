package com.empanada.banking.infrastructure.client.account

import com.empanada.banking.domain.client.Client
import com.empanada.banking.domain.client.account.Account
import com.empanada.banking.domain.client.account.AccountFactory
import com.empanada.banking.domain.client.account.money.Money

class AccountFactoryImpl implements AccountFactory{

    @Override
    Account empty(Client client) {
        assert validate(client)
        Account.AccountId id = new Account.AccountId(client)
        Account.of(id, Money.ZERO)
    }

    @Override
    Account withMoney(Client client, Money money) {
        assert validate(money)
        assert validate(client)
        Account.AccountId id = new Account.AccountId(client)
        Account.of(id, money)
    }

    private boolean validate(Client client){
        client
    }

    private boolean validate(Money money){
        money
    }
}
