package persistence.client.model

import infrastructure.shared.Serializable
import persistence.client.account.model.Account

class Client implements Serializable{
    String id
    Account account
}
