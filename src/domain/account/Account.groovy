package domain.account

import domain.client.Client
import domain.shared.Entity

/**
 * Account cannot be created without a client
 * */
class Account implements Entity<Account>{
    private final AccountId id
    private final Client owner
    private final Money balance
    private ActivityFrame activities

    Account(Client client, Money startingBalance){
        this.owner = client
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
        final private Long value
        final private Client owner

        AccountId(Long value, Client owner){
            this.value = value
            this.owner = owner
        }

        @Override
        boolean equals(Object obj) {
            value
                ? value == (obj as AccountId).value
                : value
        }
    }
}
