package com.empanada.estebanquito.application.usecase

import com.empanada.estebanquito.application.model.DepositRequest

interface DepositUseCase {
    void cashDeposit(DepositRequest depositRequest)
}