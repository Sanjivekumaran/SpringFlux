package com.sanjive.flux.mysql;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.r2dbc.ConnectionFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.r2dbc.core.DefaultReactiveDataAccessStrategy;
import org.springframework.data.r2dbc.core.R2dbcEntityOperations;
import org.springframework.data.r2dbc.core.R2dbcEntityTemplate;
import org.springframework.data.r2dbc.dialect.MySqlDialect;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;
import org.springframework.r2dbc.core.DatabaseClient;

import io.r2dbc.spi.ConnectionFactory;

@Configuration
@EnableR2dbcRepositories(entityOperationsRef = "mysqlEmployeeEntityTemplate")
public class MysqlConfig {
	
	@Value("${spring.r2dbc.mysql.url}")
	String url;

	@Bean
	@Qualifier(value = "mysqlConnectionFactory")
	ConnectionFactory mysqlConnectionFactory() {
		// TODO Auto-generated method stub
		return ConnectionFactoryBuilder.withUrl("r2dbc:mysql://root:root@127.0.0.1:3306/employeedb").build();
	}

	@Bean
	R2dbcEntityOperations mysqlEmployeeEntityTemplate(
			@Qualifier("mysqlConnectionFactory") ConnectionFactory connectionFactory) {

		DefaultReactiveDataAccessStrategy strategy = new DefaultReactiveDataAccessStrategy(MySqlDialect.INSTANCE);
		DatabaseClient databaseClient = DatabaseClient.builder().connectionFactory(connectionFactory)
				.bindMarkers(MySqlDialect.INSTANCE.getBindMarkersFactory()).build();

		return new R2dbcEntityTemplate(databaseClient, strategy);
	}

}
