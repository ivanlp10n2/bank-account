package application

import domain.account.Account
import domain.account.AccountRepository
import domain.account.money.Money
import domain.client.Client
import domain.client.ClientRepository

class Deposit implements DepositUseCase{

    ClientRepository clientRepository
    AccountRepository accountRepository

    void cashDeposit(DepositRequest request){
        Client client= clientRepository.find(request.clientId)
        assert client
        client.deposit(Money.Factory.of(request.money))
    }

    @Override
    def cashDeposit(Account.AccountId accountId, Money money) {
        Account account = accountRepository.find(accountId)
    }
}
