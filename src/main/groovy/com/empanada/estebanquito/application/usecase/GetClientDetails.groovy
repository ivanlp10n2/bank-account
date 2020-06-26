package com.empanada.estebanquito.application.usecase

import com.empanada.estebanquito.domain.client.account.money.Money

interface GetClientDetails {
    Money getBalance(String clientId)
}