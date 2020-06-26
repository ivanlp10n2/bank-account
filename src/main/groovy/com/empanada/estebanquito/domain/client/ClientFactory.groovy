package com.empanada.estebanquito.domain.client

import com.empanada.estebanquito.domain.client.Client.ClientId
import com.empanada.estebanquito.domain.client.account.money.Money

interface ClientFactory {
    Client empty(ClientId id)
    Client withMoney(ClientId id, Money money)
    Client withMoney(String name, Money money)
}