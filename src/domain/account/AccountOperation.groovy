package domain.account

enum AccountOperation {
    ADD, WITHDRAW

    final private AccountOperation operation
    final private Money amount

    AccountOperation(AccountOperation operation, Money money){
        this.operation = operation
        this.amount = money
    }
}