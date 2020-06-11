package domain.client.account

import domain.client.Client
import domain.client.account.activity.AccountOperation
import domain.client.account.activity.Activity
import domain.client.account.activity.ActivityFrame
import domain.client.account.money.Money
import domain.shared.Entity

/**
 * Account cannot be created without a client
 * */
class Account implements Entity<Account>{
    final AccountId id
    final Money balance
    ActivityFrame activities

    Account(AccountId newId, Money baseBalance, ActivityFrame baseActivities){
        id = newId
        balance = baseBalance
        activities = baseActivities
    }

    Account(Money baseBalance, ActivityFrame baseActivities){
        balance = baseBalance
        activities = baseActivities
    }

    static Account of(AccountId id, Money money){
        new Account(id, money, ActivityFrame.empty())
    }

    static Account of(AccountId id, Money money, ActivityFrame activities){
        new Account(id, money, activities)
    }
    static Account empty() {
        new Account(Money.ZERO, ActivityFrame.empty())
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
        private Client owner

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
