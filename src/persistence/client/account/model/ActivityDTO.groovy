package persistence.client.account.model

import infrastructure.shared.Serializable

/**
*   {
 *   acitivtyId,
 *   operation,
 *   balance
 *  }
 */
class Activity implements Serializable{
    String activityId
    String operation
    Money balance
}
