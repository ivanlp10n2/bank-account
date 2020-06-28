package com.empanada.banking.application.usecase

import com.empanada.banking.application.model.DepositRequest

interface DepositUseCase {
    void cashDeposit(DepositRequest depositRequest)
}