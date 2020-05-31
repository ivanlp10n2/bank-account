package domain.client

interface ClientRepository {

   Client find(long userId)
   Client create()

}
