package persistence.api

import infrastructure.shared.AggregateDTO
import infrastructure.shared.DTO

interface DataSource {
    void create(String tableName, AggregateDTO dto)
    DTO findById(String tableName, AggregateDTO dto)
    void update(String tableName, AggregateDTO dto)

}