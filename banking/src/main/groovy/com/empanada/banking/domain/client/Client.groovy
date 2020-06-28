package com.empanada.banking.domain.client


import com.empanada.banking.domain.client.account.Account
import com.empanada.banking.domain.client.account.money.Money
import com.empanada.banking.domain.shared.AggregateId
import com.empanada.banking.domain.shared.Entity


class Client implements Entity<Client>{
    final ClientId id
    final Account account

    Client(ClientId clientId, Account account){
        this.id = clientId
        this.account = account
    }

    private Client(Client client, Account account){
        this.id = client.id
        this.account = account
    }

    Client(ClientId id){
        this.id = id
    }

    /**
     * Client only has one account.
     * */
    Client deposit(Money money) {
        account.deposit(money)
        this
    }

    Money accountBalance(){
        account.currentBalance()
    }

    @Override
    boolean equalAs(Client other) {
        this.id == other.id
    }

    Client assignAccount(Account account) {
        new Client(this, account)
    }

    static class ClientId implements AggregateId{
        String name

        ClientId(String name){
            this.name = name
        }

        @Override
        boolean equals(Object obj) {
            obj && name && ( name == (obj as ClientId).name )
        }
    }

}
