package persistence.client.account.model


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

    AccountDTO(String accountId, String ownerId, MoneyDTO balance) {
        this.accountId = accountId
        this.ownerId = ownerId
        this.balance = balance
    }

    @Override
    DTO from(Map map) {
        this.accountId = map.accountId
        this.ownerId = map.ownerId
        this.balance = new MoneyDTO().from(map.balance)
        this
    }
}
