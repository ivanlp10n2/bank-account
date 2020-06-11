package persistence.client.account.model

import infrastructure.shared.Serializable

/**
 * {
 *   accountId: gui,
 *   activities:[acitivtyId, owner, timestamp, operation, balance]
 *   balance: [ammount, currency],
 *   }
 *
 * */
class Account implements Serializable{
    String accountId
    List<Activity> activities
    List<Money> balance
}
