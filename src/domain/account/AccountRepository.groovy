package domain.account

import infrastructure.shared.Repository

interface AccountRepository extends Repository<Account, Account.AccountId> {

}