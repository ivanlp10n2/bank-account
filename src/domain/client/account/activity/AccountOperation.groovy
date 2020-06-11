package domain.client.account.activity

import domain.client.account.money.Money


enum AccountOperation {
    ADD, WITHDRAW

    final private AccountOperation operation
    final private Money amount

    AccountOperation(AccountOperation operation, Money money){
        this.operation = operation
        this.amount = money
    }
}