package infrastructure.account

import domain.account.Account
import domain.account.AccountRepository
import infrastructure.shared.DataMapper
import infrastructure.shared.InMemoryDatabase

class AccountRepositoryImpl implements AccountRepository {

    InMemoryDatabase db
    DataMapper<Account> dataMapper

    @Override
    Account find(Account.AccountId identifier) {
        String json = db.findAccount(identifier)
        Account account = dataMapper.map(json)
        assert validateIntegrity(account)
        account
    }


    Boolean validateIntegrity(Account account) {
        true
    }
}
