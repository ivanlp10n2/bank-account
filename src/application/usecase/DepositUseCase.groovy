package application.usecase

import application.model.DepositRequest

interface DepositUseCase {
    void cashDeposit(DepositRequest depositRequest)
}