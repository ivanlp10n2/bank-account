package com.empanada.banking.domain.client.account

import com.empanada.banking.domain.client.Client
import com.empanada.banking.domain.client.account.money.Money
import com.empanada.banking.domain.shared.Entity
/**
 * Account cannot be created without a client
 * */
class Account implements Entity<Account>{
    final AccountId id
    Money balance

    Account(AccountId newId, Money baseBalance){
        id = newId
        balance = baseBalance
    }

    Account(Money baseBalance){
        balance = baseBalance
    }

    static Account of(AccountId id, Money money){
        new Account(id, money, )
    }

    static Account empty() {
        new Account(Money.ZERO)
    }

    Account deposit(Money money){
        assert valid(money)
        this.balance += money
        this
    }

    boolean valid(Money money) {
        money
    }

    Money currentBalance(){
        balance
    }

    @Override
    boolean equalAs(Account other) {
        id == other.id
    }

    static class AccountId {
        private Client owner

        AccountId(Client owner){
            this.owner = owner
        }

        @Override
        boolean equals(Object obj) {
            owner && obj && ( owner == (obj as AccountId).owner )
        }
    }
}
