package application

import application.model.DepositRequest
import domain.account.AccountRepository
import domain.account.money.Money
import domain.client.Client
import domain.client.ClientRepository
import infrastructure.account.AccountFactoryImpl
import infrastructure.client.ClientRepositoryImpl

class DepositService implements DepositUseCase{

    ClientRepository clientRepository
    AccountRepository accountRepository

    DepositService(){
        clientRepository = new ClientRepositoryImpl()
        accountRepository = new AccountFactoryImpl()
    }

    @Override
    void cashDeposit(DepositRequest request){
        Client client= clientRepository.find(request.clientId)
        assert client
        client.deposit(Money.Factory.of(request.money))
    }

}
