package persistence.client.account.model

import infrastructure.shared.Serializable

/**
 * {
 *     amount: amount,
 *     currency: currency
 * }
 * */
class Money implements Serializable {
    BigDecimal amount
    String currency
}
