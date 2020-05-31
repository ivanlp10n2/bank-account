package domain.client

import domain.account.Money
import domain.client.Client.ClientId

interface ClientFactory {
    Client empty(ClientId id)
    Client withMoney(ClientId id, Money money)
    Client withMoney(String name, Money money)
}