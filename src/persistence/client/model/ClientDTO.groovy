package persistence.client.model

import infrastructure.shared.DTO
import persistence.client.account.model.AccountDTO

class ClientDTO implements DTO{
    String id
    AccountDTO account

    ClientDTO(){}

    ClientDTO(String id, AccountDTO accountDTO){
        this.id = id
        this.account = accountDTO
    }

    @Override
    DTO from(Map map) {
        this.id = map.id
        this.account = new AccountDTO().from(map.account)
        this
    }
}
