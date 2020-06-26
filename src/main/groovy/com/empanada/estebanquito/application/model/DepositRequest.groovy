package com.empanada.estebanquito.application.model

class DepositRequest {
    final String clientId
    final Dollars money

    private DepositRequest(String clientId, Dollars money){
        this.clientId = clientId
        this.money = money
    }

    static DepositRequest of(String clientId, Dollars money){
        new DepositRequest(clientId, money)
    }
}
