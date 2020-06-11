package domain.account

import domain.account.activity.AccountOperation
import domain.account.activity.Activity
import domain.account.activity.ActivityFrame
import domain.account.money.Money
import domain.client.Client
import domain.shared.Entity

/**
 * Account cannot be created without a client
 * Aggregate root
 * */
class Account implements Entity<Account>{
    private final AccountId id
    private final Money balance
    private ActivityFrame activities

    Account(AccountId newId, Money startingBalance){
        id = newId
        balance = startingBalance
    }

    Account deposit(Money money){
        assert valid(money)
        Activity activity = Activity.of(AccountOperation.ADD, money)
        activities.add(activity)
        this
    }

    boolean valid(Money money) {
        money
    }

    Money currentBalance(){
        activities.calculateBalance(id)
    }

    @Override
    boolean equalAs(Account other) {
        id == other.id
    }

    static class AccountId {
        final private Client owner

        AccountId(Client owner){
            this.owner = owner
        }

        @Override
        boolean equals(Object obj) {
            owner && obj
                && owner == (obj as AccountId).owner
        }
    }
}
