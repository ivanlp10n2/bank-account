package com.empanada.banking.infrastructure.client.account.model

import com.empanada.persistence.api.DTO

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
