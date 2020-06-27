package com.empanada.estebanquito.application.usecase

import com.empanada.estebanquito.application.model.Dollars

interface GetClientDetails {
    Dollars getBalance(String clientId)
}