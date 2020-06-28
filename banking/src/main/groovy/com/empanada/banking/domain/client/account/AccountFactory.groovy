package com.empanada.banking.domain.client.account


import com.empanada.banking.domain.client.Client
import com.empanada.banking.domain.client.account.money.Money

interface AccountFactory {
    Account empty(Client client)
    Account withMoney(Client client, Money money)
}