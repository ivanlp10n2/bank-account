package com.empanada.banking.application.model

import com.empanada.banking.domain.client.account.money.Money

class Dollars {
    BigDecimal amount

    Dollars (BigDecimal amount){
        this.amount = amount
    }

    static Dollars from (Money money){
        new Dollars(money.amount)
    }

    @Override
    boolean equals(Object obj) {
        (obj as Dollars).amount == this.amount
    }
}
