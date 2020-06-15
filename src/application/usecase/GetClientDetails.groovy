package application.usecase

import domain.client.account.money.Money

interface GetClientDetails {
    Money getBalance()
}