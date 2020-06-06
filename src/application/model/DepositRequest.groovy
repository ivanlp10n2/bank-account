package application.model

class DepositRequest {
    final String accountId
    final Money money

    private DepositRequest(String accountId, Money money){
        this.accountId = accountId
        this.money = money
    }

    static DepositRequest of(String clientId, Money money){
        new DepositRequest(clientId, money)
    }
}
