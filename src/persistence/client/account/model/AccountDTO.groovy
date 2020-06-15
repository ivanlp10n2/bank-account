package persistence.client.account.model

import infrastructure.shared.DTO

/**
 * {
 *   accountId: gui,
 *   activities:[acitivtyId, owner, timestamp, operation, balance]
 *   balance: [ammount, currency],
 *   }
 *
 * */
class AccountDTO implements DTO{
    String accountId
    String ownerId
    List<ActivityDTO> activities
    List<MoneyDTO> balance

    @Override
    DTO from(Map map) {

    }
}
