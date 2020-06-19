package application.service

import application.usecase.GetClientDetails
import domain.client.Client
import domain.client.ClientRepository
import domain.client.account.money.Money
import infrastructure.client.ClientRepositoryImpl

class GetClientDetailsImpl implements GetClientDetails{

    ClientRepository clientRepository

    GetClientDetailsImpl(){
        clientRepository = new ClientRepositoryImpl()
    }

    @Override
    Money getBalance(String sClientId) {
        assert (sClientId)
        Client.ClientId clientId = new Client.ClientId(sClientId)
        Client client = clientRepository.find(clientId)
        client.account.balance
    }
}
