package com.sanjive.flux.mysql;

import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MysqlRepository extends R2dbcRepository<Employee, Integer>{

}
