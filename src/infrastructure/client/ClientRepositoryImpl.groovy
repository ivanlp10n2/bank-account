package infrastructure.client

import domain.client.Client
import domain.client.Client.ClientId
import domain.client.ClientRepository
import infrastructure.client.account.model.ClientDTO
import infrastructure.shared.DTO
import infrastructure.shared.Mapper
import persistence.api.DataSource
import persistence.impl.InMemoryDatabase

class ClientRepositoryImpl implements ClientRepository{

    private final DataSource ds
    private final Mapper mapper
    private final String CLIENT_TABLE = "Client"

    ClientRepositoryImpl(){
        ds = InMemoryDatabase.INSTANCE
        mapper = new ClientMapper()
    }

    @Override
    Client find(ClientId clientId) {
        ClientDTO dtoId = new ClientDTO(clientId.name)
        DTO dto = ds.findById(CLIENT_TABLE, dtoId)
        assert validateIntegrity(dto)
        Client client = mapper.map( dto )
        assert validateIntegrity(client)
        client
    }

    private Boolean validateIntegrity(DTO dto ) {
        dto
    }

    private Boolean validateIntegrity(Client client) {
        client
    }

    @Override
    void add(Client client) {
        DTO pogo = mapper.map(client)
        ds.create(CLIENT_TABLE, pogo)
    }

    @Override
    Client update(Client client) {
        ClientDTO dto = mapper.map(client)
        ds.update(CLIENT_TABLE, dto)
    }
}
