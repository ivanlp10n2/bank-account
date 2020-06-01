package infrastructure.shared

interface InMemoryDatabase {

    findUser(long userId)
    findAccount(long accountId)

}