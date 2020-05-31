package application

import domain.account.Money
import domain.client.Client
import domain.client.ClientRepository

class MoneyTransaction {

    ClientRepository ClientRepository

    void depositMoney(long clientId, double money){
        Client client= ClientRepository.find(clientId)
        assert client
        client.deposit(Money.Factory.of(money))
    }
}
