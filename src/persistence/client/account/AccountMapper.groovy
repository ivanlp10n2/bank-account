package persistence.account


import persistence.account.model.Account
import infrastructure.shared.Mapper

class AccountMapper implements Mapper<domain.client.account.Account, Account>{
    @Override
    Account map(domain.client.account.Account obj) {
        return null
    }

    @Override
    domain.client.account.Account map(Account obj) {
        return null
    }
}
