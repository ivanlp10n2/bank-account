package com.empanada.estebanquito.persistence.api

import com.empanada.estebanquito.infrastructure.shared.AggregateDTO
import com.empanada.estebanquito.infrastructure.shared.DTO

interface DataSource {
    void create(String tableName, AggregateDTO dto)
    DTO findById(String tableName, AggregateDTO dto)
    void update(String tableName, AggregateDTO dto)

}