package infrastructure.client

import domain.client.Client
import domain.client.Client.ClientId
import domain.client.ClientRepository
import infrastructure.shared.DTO
import infrastructure.shared.Mapper
import persistence.InMemoryDatabase
import persistence.Record
import persistence.Table
import persistence.client.ClientMapper
import persistence.client.model.ClientDTO
import persistence.shared.DataSource

class ClientRepositoryImpl implements ClientRepository{

    private final DataSource ds
    private final Mapper mapper

    ClientRepositoryImpl(){
        ds = InMemoryDatabase.INSTANCE
        mapper = new ClientMapper()
    }

    @Override
    Client find(ClientId clientId) {
        Record record = ds.findById(Table.Name.CLIENT, clientId.name)
        ClientDTO dto = new ClientDTO().from(record)
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
        ds.create(Table.Name.CLIENT, pogo)
    }

}
