package application

import domain.account.money.Money
import static domain.client.Client.ClientId

class DepositRequest {
    final ClientId clientId
    final Money money

    DepositRequest(ClientId clientId, Money money){
        this.clientId = clientId
        this.money = money
    }
    static class Factory{
        static DepositRequest of(ClientId clientId, Money money){
            new DepositRequest(clientId, money)
        }
    }
}
