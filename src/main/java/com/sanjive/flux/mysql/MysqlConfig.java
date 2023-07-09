package com.sanjive.flux.mysql;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.r2dbc.ConnectionFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.r2dbc.core.DefaultReactiveDataAccessStrategy;
import org.springframework.data.r2dbc.core.R2dbcEntityOperations;
import org.springframework.data.r2dbc.core.R2dbcEntityTemplate;
import org.springframework.data.r2dbc.dialect.MySqlDialect;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;
import org.springframework.r2dbc.core.DatabaseClient;

import io.r2dbc.spi.ConnectionFactories;
import io.r2dbc.spi.ConnectionFactory;

@Configuration
public class MysqlConfig {

	@Bean
    @Qualifier(value = "mysqlConnectionFactory")
	 ConnectionFactory mysqlConnectionFactory() {
		// TODO Auto-generated method stub
		return ConnectionFactoryBuilder.withUrl("r2dbc:mysql://root:root@127.0.0.1:3306/employeedb").build();
	}
	
}
