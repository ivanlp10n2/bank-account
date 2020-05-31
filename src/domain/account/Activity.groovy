package domain.account

class Activity {
    private final ActivityId id
    private final AccountOperation operation
    final Money money

    //TODO: refactor this into annotation
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


    static class Factory{
        static Activity of(ActivityId id, AccountOperation operation, Money money){
            new Activity(id, operation, money)
        }

        static Activity of(AccountOperation operation, Money money){
            new Activity(operation, money)
        }
    }

    static class ActivityId{
        private final Long value
    }
}
