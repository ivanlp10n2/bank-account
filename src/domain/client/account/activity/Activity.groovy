package domain.client.account.activity

import domain.client.account.money.Money

import java.time.LocalDateTime

class Activity {
    private final ActivityId id
    private final LocalDateTime timestamp
    final AccountOperation operation
    final Money money

    private Activity(AccountOperation operation, Money money){
        this.operation = operation
        this.money = money
    }

    private Activity(id, timestamp, operation, money){
        this.id = id
        this.timestamp = timestamp
        this.operation = operation
        this.money = money
    }

    static Activity of(ActivityId id, LocalDateTime timestamp, AccountOperation operation, Money money){
        new Activity(id, timestamp, operation, money)
    }

    static Activity of(AccountOperation operation, Money money){
        new Activity(operation, money)
    }

    static class ActivityId{
        private final String uuid

        ActivityId(String uuid){
            this.uuid = uuid
        }

        @Override
        boolean equals(Object obj) {
            uuid
                && obj
                && uuid == (obj as ActivityId).uuid
        }
    }
}
