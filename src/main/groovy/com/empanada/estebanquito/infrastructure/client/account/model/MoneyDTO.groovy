package com.empanada.estebanquito.infrastructure.client.account.model

import com.empanada.estebanquito.infrastructure.shared.DTO

/**
 * {
 *     amount: amount,
 *     currency: currency
 * }
 * */
class MoneyDTO implements DTO{
    String currency
    BigDecimal amount

    MoneyDTO(){}

    MoneyDTO (String currency, BigDecimal amount){
        this.amount = amount
        this.currency = currency
    }

    static MoneyDTO of(String currency, BigDecimal amount){
        new MoneyDTO(currency, amount)
    }
}
