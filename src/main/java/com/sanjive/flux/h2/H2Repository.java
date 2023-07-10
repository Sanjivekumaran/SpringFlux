package com.sanjive.flux.h2;

import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface H2Repository extends R2dbcRepository<Employee, Integer>{

}
