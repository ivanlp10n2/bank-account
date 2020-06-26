package com.empanada.estebanquito.domain.client.account

import com.empanada.estebanquito.domain.client.Client
import com.empanada.estebanquito.domain.client.account.money.Money

interface AccountFactory {
    Account empty(Client client)
    Account withMoney(Client client, Money money)
}