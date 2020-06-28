package com.empanada.banking.application.service

import com.empanada.banking.application.model.DepositRequest
import com.empanada.banking.application.usecase.DepositUseCase
import com.empanada.banking.domain.client.Client
import com.empanada.banking.domain.client.ClientRepository
import com.empanada.banking.domain.client.account.money.Money
import com.empanada.banking.infrastructure.client.ClientRepositoryImpl

class DepositService implements DepositUseCase{

    ClientRepository clientRepository

    DepositService(){
        clientRepository = new ClientRepositoryImpl()
    }

    @Override
    void cashDeposit(DepositRequest request){
        Client.ClientId clientId = new Client.ClientId(request.clientId)
        Client client = clientRepository.find(clientId)
        assert client
        Money money = Money.dollar(request.money.amount)
        client.deposit(money)
        clientRepository.update(client)
    }
}
