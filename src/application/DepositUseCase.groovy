package application

import domain.account.Account
import domain.account.money.Money

interface DepositUseCase {

    cashDeposit(Account.AccountId accountId, Money money)
}