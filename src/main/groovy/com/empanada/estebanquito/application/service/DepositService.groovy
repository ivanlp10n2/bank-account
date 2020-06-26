package com.empanada.estebanquito.application.service

import com.empanada.estebanquito.application.model.DepositRequest
import com.empanada.estebanquito.application.usecase.DepositUseCase
import com.empanada.estebanquito.domain.client.Client
import com.empanada.estebanquito.domain.client.ClientRepository
import com.empanada.estebanquito.domain.client.account.money.Money
import com.empanada.estebanquito.infrastructure.client.ClientRepositoryImpl

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
