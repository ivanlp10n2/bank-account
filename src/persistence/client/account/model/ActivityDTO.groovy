package persistence.client.account.model

import infrastructure.shared.DTO

/**
*   {
 *   acitivtyId,
 *   operation,
 *   balance
 *  }
 */
class ActivityDTO implements DTO{
    String activityId
    Date timestamp
    String operation
    MoneyDTO balance

    ActivityDTO(String activityId, Date timestamp, String operation, MoneyDTO balance) {
        this.activityId = activityId
        this.timestamp = timestamp
        this.operation = operation
        this.balance = balance
    }

    ActivityDTO(){}

    @Override
    DTO from(Map map) {
        return null
    }
}
