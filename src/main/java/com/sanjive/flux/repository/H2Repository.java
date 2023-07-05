package com.sanjive.flux.repository;

import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;

import com.sanjive.flux.model.Employee;

@Repository
public interface H2Repository extends R2dbcRepository<Employee, Integer> {

}
