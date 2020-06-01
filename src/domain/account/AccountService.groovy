package domain.account

import domain.account.activity.Activity
import domain.account.money.Money

class AccountService implements DepositUseCase{

    AccountRepository accountRepository

    AccountService(AccountRepository accountRepository){
        this.accountRepository = accountRepository
    }
    @Override
    def deposit(Account.AccountId accountId, Money money) {
        Account account = accountRepository.find(accountId)
        assert account

        Activity activity = Activity.Factory.depositMoney(money)
    }
}
