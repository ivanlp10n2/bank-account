package infrastructure.client.account.model

import infrastructure.shared.AggregateDTO

class ClientDTO implements AggregateDTO {
    String id
    AccountDTO account

    ClientDTO(){}

    ClientDTO(String id){
        this.id = id
    }
    ClientDTO(String id, AccountDTO accountDTO){
        this.id = id
        this.account = accountDTO
    }

    @Override
    String getAggregateId() {
        id
    }
}
