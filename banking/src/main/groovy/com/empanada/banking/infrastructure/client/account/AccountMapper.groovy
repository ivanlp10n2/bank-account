package com.empanada.banking.infrastructure.client.account

import com.empanada.banking.domain.client.Client
import com.empanada.banking.domain.client.account.Account
import com.empanada.banking.domain.client.account.money.Money
import com.empanada.banking.infrastructure.client.account.model.AccountDTO
import com.empanada.banking.infrastructure.client.account.model.MoneyDTO
import com.empanada.banking.infrastructure.shared.Mapper
import com.empanada.persistence.shared.Utils


class AccountMapper implements Mapper<Account, AccountDTO> {

    @Override
    AccountDTO map(Account account) {
        AccountDTO dto = new AccountDTO()
        dto.accountId = Utils.random()
        dto.ownerId = account.id.owner.id.name
        dto.balance = new MoneyDTO(   account.balance.currency.name(),
                                            account.balance.amount)
        dto
    }

    @Override
    Account map(AccountDTO account) {
        Client.ClientId clientId = new Client.ClientId(account.ownerId)
        Client client = new Client(clientId)
        Account.AccountId accountId = new Account.AccountId(client)
        Money money = new Money(Money.Currency.USD, account.balance.amount)
        Account.of(accountId, money)
    }


}
