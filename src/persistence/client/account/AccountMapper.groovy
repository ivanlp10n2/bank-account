package persistence.client.account

import domain.client.Client
import domain.client.account.Account
import domain.client.account.money.Money
import infrastructure.shared.Mapper
import persistence.client.account.model.AccountDTO
import persistence.client.account.model.MoneyDTO
import persistence.shared.Utils

class AccountMapper implements Mapper<Account, AccountDTO>{

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
