package com.empanada.estebanquito.application.service

import com.empanada.estebanquito.application.model.Dollars
import com.empanada.estebanquito.application.usecase.GetClientDetails
import com.empanada.estebanquito.domain.client.Client
import com.empanada.estebanquito.domain.client.ClientRepository
import com.empanada.estebanquito.infrastructure.client.ClientRepositoryImpl

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
        Dollars.from(client.account.balance)
    }
}
