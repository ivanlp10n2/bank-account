package application

import application.model.DepositRequest
import domain.account.Account
import domain.account.AccountRepository
import domain.account.AccountService
import domain.account.AccountServiceImpl
import domain.account.money.Money
import domain.client.Client
import domain.client.ClientRepository
import infrastructure.account.AccountRepositoryImpl
import infrastructure.client.ClientRepositoryImpl

class DepositService implements DepositUseCase{

    AccountRepository accountRepository
    AccountService accountService

    DepositService(){
        accountRepository = new AccountRepositoryImpl()
        accountService = new AccountServiceImpl()
    }

    @Override
    void cashDeposit(DepositRequest request){
        Account account= accountRepository.find(request.accountId)
        assert account
        account.deposit(request.money)
        accountRepository.add(account)
    }

}
