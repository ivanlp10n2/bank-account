package domain.account

import domain.account.money.Money
import domain.client.Client

interface AccountFactory {
    Account empty(Client client)
    Account withMoney(Client client, Money money)
}