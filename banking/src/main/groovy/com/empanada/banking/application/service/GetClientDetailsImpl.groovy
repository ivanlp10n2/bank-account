package com.empanada.banking.application.service

import com.empanada.banking.application.model.Dollars
import com.empanada.banking.application.usecase.GetClientDetails
import com.empanada.banking.domain.client.Client
import com.empanada.banking.domain.client.ClientRepository
import com.empanada.banking.infrastructure.client.ClientRepositoryImpl

class GetClientDetailsImpl implements GetClientDetails{

    ClientRepository clientRepository

    GetClientDetailsImpl(){
        clientRepository = new ClientRepositoryImpl()
    }

    @Override
    Dollars getBalance(String sClientId) {
        assert (sClientId)
        Client.ClientId clientId = new Client.ClientId(sClientId)
        Client client = clientRepository.find(clientId)
        Dollars.from(client.accountBalance())
    }
}
