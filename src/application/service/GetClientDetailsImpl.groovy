package application.service

import application.usecase.GetClientDetails
import domain.client.ClientRepository
import domain.client.account.money.Money
import infrastructure.client.ClientRepositoryImpl

class GetClientDetailsImpl implements GetClientDetails{

    ClientRepository clientRepository

    GetClientDetailsImpl(){
        clientRepository = new ClientRepositoryImpl()
    }

    @Override
    Money getBalance() {
        clientRepository.find()
    }
}
