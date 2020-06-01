package domain.account

import domain.account.activity.AccountOperation
import domain.account.activity.Activity
import domain.account.activity.ActivityFrame
import domain.account.money.Money
import domain.client.Client
import domain.shared.Entity

/**
 * Account cannot be created without a client
 * */
class Account implements Entity<Account>{
    private final AccountId id
    private final Money balance
    private ActivityFrame activities

    Account(AccountId id, Money startingBalance){
        this.id = id
        this.balance = startingBalance
    }

    void deposit(Money money){
        assert valid(money)

        Activity activity = Activity.Factory.of(AccountOperation.ADD, money)
        activities.add(activity)
    }

    boolean valid(Money money) {
        assert money
    }

    Money currentBalance(){
        activities.calculateBalance(id)
    }

    @Override
    boolean equalAs(Account other) {
        id == other
    }

    static class AccountId {
        final private Long uuid
        final private Client owner

        AccountId(Long uuid, Client owner){
            this.uuid = uuid
            this.owner = owner
        }

        @Override
        boolean equals(Object obj) {
            uuid && owner
                ? uuid == (obj as AccountId).uuid
                    && owner == (obj as AccountId).owner
                : uuid
        }
    }
}
