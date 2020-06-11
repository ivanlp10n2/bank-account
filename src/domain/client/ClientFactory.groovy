package domain.client

import domain.client.Client.ClientId
import domain.client.account.money.Money

interface ClientFactory {
    Client empty(ClientId id)
    Client withMoney(ClientId id, Money money)
    Client withMoney(String name, Money money)
}