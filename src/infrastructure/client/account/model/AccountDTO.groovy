package infrastructure.client.account.model

import infrastructure.shared.DTO

/**
 * {
 *   accountId: gui,
 *   balance: [ammount, currency],
 *   }
 *
 * */
class AccountDTO implements DTO{
    String accountId
    String ownerId
    MoneyDTO balance

    AccountDTO(){}

    AccountDTO(String accountId){
        this.accountId = accountId
    }

    private AccountDTO(String accountId, String ownerId, MoneyDTO balance) {
        this.accountId = accountId
        this.ownerId = ownerId
        this.balance = balance
    }

}
