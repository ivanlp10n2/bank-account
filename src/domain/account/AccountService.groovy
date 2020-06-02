package domain.account

import domain.account.Account.AccountId
import domain.account.money.Money

interface AccountService {
    void deposit(AccountId accountId, Money money)
}