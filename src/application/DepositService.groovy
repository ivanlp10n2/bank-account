package application

import application.model.DepositRequest
import domain.account.AccountRepository
import domain.account.money.Money
import domain.client.Client
import domain.client.ClientRepository
import infrastructure.account.AccountRepositoryImpl
import infrastructure.client.ClientRepositoryImpl

class DepositService implements DepositUseCase{

    ClientRepository clientRepository
    AccountRepository accountRepository

    DepositService(){
        clientRepository = new ClientRepositoryImpl()
        accountRepository = new AccountRepositoryImpl()
    }

    @Override
    void cashDeposit(DepositRequest request){
        Client client= clientRepository.find(request.clientId)
        assert client
        client.deposit(Money.of(request.money))
    }

}
