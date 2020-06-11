package persistence.client.account

import domain.client.account.Account
import domain.client.account.money.Money
import infrastructure.shared.Mapper
import persistence.client.account.model.AccountDTO
import persistence.client.account.model.MoneyDTO
import persistence.shared.Utils

class AccountMapper implements Mapper<Account, AccountDTO>{
    private final ActivityMapper activityMapper

    AccountMapper(){
        activityMapper =  new ActivityMapper()
    }

    @Override
    AccountDTO map(Account account) {
        AccountDTO dto = new AccountDTO()
        dto.accountId = Utils.random()
        dto.ownerId = account.id.owner.id.name
        dto.balance = [] << new MoneyDTO(   account.balance.currency.name(),
                                            account.balance.amount)
        dto.activities = activityMapper.mapActivities(account.activities)
        dto
    }

    @Override
    Account map(AccountDTO account) {
        Account.AccountId accountId = new Account.AccountId()
        Money money = account.balance
        Account.of(accountId, money, activityMapper.map(account.activities))
    }


}
