package domain.account

import domain.account.Account.AccountId
import domain.account.money.Money

interface DepositUseCase {

    deposit(AccountId accountId, Money money)

}