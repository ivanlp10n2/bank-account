package infrastructure.client

import domain.client.Client
import domain.client.Client.ClientId
import domain.client.ClientRepository
import domain.client.account.activity.Activity
import infrastructure.shared.DataSource
import infrastructure.shared.Mapper
import infrastructure.shared.DTO
import persistence.InMemoryDatabase
import persistence.client.ClientMapper
import persistence.client.model.ClientDTO
import persistence.shared.Serializer

class ClientRepositoryImpl implements ClientRepository{
    private final static String CLIENT_COLLECTION = "Client"
    private final static String ACCOUNT_SUBSET = "Account"
    private final static String ACTIVITIES_SUBSET = "Activities"

    private final DataSource ds
    private final Mapper mapper

    ClientRepositoryImpl(){
        ds = InMemoryDatabase.INSTANCE
        mapper = new ClientMapper()
    }

    @Override
    Client find(ClientId clientId) {
        String result = ds.findById(CLIENT_COLLECTION, clientId.name)
        ClientDTO dto = new ClientDTO().from(Serializer.deserialize(result))
        Client client = mapper.map( dto )
        assert validateIntegrity(client)
        client
    }

    private Boolean validateIntegrity(Client client) {
        client
    }

    @Override
    void add(Client client) {
        DTO pogo = mapper.map(client)
        String sPogo = Serializer.serialize(pogo)
        ds.add(CLIENT_COLLECTION, sPogo)
    }

    @Override
    void addNewActivities(Client client) {
            client.account.activities.each { Activity activity ->
                if (!activity.id)
                    saveActivity(mapper.map(activity))
        }
    }

    void saveActivity(DTO activity) {
        ds.add(ACTIVITIES_SUBSET, activity)
    }
}
