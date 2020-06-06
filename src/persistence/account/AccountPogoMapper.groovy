package persistence.account

import domain.account.Account
import persistence.account.pogo.AccountPogo
import persistence.shared.PogoMapper

class AccountPogoMapper implements PogoMapper<Account, AccountPogo>{
    @Override
    Account map(AccountPogo obj) {
        return null
    }
}
