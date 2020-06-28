package com.empanada.persistence.api

interface DataSource {
    void create(String tableName, AggregateDTO dto)
    DTO findById(String tableName, AggregateDTO dto)
    void update(String tableName, AggregateDTO dto)

}