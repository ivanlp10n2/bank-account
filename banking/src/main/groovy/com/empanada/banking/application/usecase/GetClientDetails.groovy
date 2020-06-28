package com.empanada.banking.application.usecase

import com.empanada.banking.application.model.Dollars

interface GetClientDetails {
    Dollars getBalance(String clientId)
}