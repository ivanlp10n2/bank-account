package com.empanada.banking.domain.client

import com.empanada.banking.domain.client.account.money.Money

interface ClientFactory {
    Client empty(Client.ClientId id)
    Client withMoney(Client.ClientId id, Money money)
    Client withMoney(String name, Money money)
}