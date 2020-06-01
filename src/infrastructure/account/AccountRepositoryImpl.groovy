package infrastructure.account

import domain.account.Account
import domain.account.AccountRepository
import infrastructure.shared.InMemoryDatabase

class AccountRepositoryImpl implements AccountRepository {

    InMemoryDatabase db

    @Override
    Account find(Account.AccountId identifier) {
        Account account = db.findAccount(identifier)
        assert account
        return null
    }
}
