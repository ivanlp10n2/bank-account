package domain.account

import infrastructure.shared.Repository

interface AccountRepository extends Repository<Account, Account.AccountId> {
    void updateActivities(Account account)
}