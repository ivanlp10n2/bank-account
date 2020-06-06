package persistence.account.pogo

import persistence.shared.Pogo

/**
 * {
 *   accountId: gui,
 *   activities:[acitivtyId, operation, balance]
 *   balance: [ammount, currency],
 *   }
 *
 * */
class AccountPogo implements Pogo{
    String accountId
    List<ActivityPogo> activities
    List<MoneyPogo> balance

}
