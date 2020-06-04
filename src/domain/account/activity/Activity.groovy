package domain.account.activity


import domain.account.money.Money
import domain.shared.Entity

class Activity implements Entity<Activity>{
    private final ActivityId id
    private final AccountOperation operation
    final Money money

    private Activity(ActivityId id, AccountOperation operation, Money money){
        assert id
        assert operation
        assert money

        this.id = id
        this.operation = operation
        this.money = money
    }

    private Activity(AccountOperation operation, Money money){
        assert operation
        assert money

        this.operation = operation
        this.money = money
    }


    static Activity of(ActivityId id, AccountOperation operation, Money money){
        new Activity(id, operation, money)
    }

    static Activity of(AccountOperation operation, Money money){
        new Activity(operation, money)
    }

    @Override
    boolean equalAs(Activity other) {
        id == other.id
    }

    static class ActivityId{
        private final String uuid

        ActivityId(String uuid){
            this.uuid = uuid
        }

        @Override
        boolean equals(Object obj) {
            uuid && obj
                    && uuid == (obj as ActivityId).uuid
        }
    }
}
