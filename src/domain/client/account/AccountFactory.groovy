package domain.client.account

import domain.client.Client
import domain.client.account.money.Money

interface AccountFactory {
    Account empty(Client client)
    Account withMoney(Client client, Money money)
}