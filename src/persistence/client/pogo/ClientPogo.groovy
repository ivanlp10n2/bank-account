package persistence.client.pogo

import persistence.account.pogo.AccountPogo
import persistence.shared.Pogo

class ClientPogo implements Pogo{
    String id
    AccountPogo account
}
