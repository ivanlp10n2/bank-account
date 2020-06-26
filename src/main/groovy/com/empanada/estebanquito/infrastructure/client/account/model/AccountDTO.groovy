package com.empanada.estebanquito.infrastructure.client.account.model

import com.empanada.estebanquito.infrastructure.shared.DTO


class AccountDTO implements DTO{
    String accountId
    String ownerId
    MoneyDTO balance

    AccountDTO(){}

    AccountDTO(String accountId){
        this.accountId = accountId
    }

    private AccountDTO(String accountId, String ownerId, MoneyDTO balance) {
        this.accountId = accountId
        this.ownerId = ownerId
        this.balance = balance
    }

}
