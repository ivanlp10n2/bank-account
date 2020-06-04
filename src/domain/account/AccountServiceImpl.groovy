package domain.account

import domain.account.activity.Activity
import domain.account.money.Money
import infrastructure.account.AccountRepositoryImpl

class AccountServiceImpl implements AccountService{

    private final AccountRepository accountRepository

    AccountServiceImpl(){
        this.accountRepository = new AccountRepositoryImpl()
    }
    @Override
    void deposit(Account.AccountId accountId, Money money) {
        Account account = accountRepository.find(accountId)
        assert account
        account.deposit(money)
    }
}
