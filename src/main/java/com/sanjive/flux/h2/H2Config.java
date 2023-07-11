package com.sanjive.flux.h2;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.r2dbc.ConnectionFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.r2dbc.core.DefaultReactiveDataAccessStrategy;
import org.springframework.data.r2dbc.core.R2dbcEntityOperations;
import org.springframework.data.r2dbc.core.R2dbcEntityTemplate;
import org.springframework.data.r2dbc.dialect.H2Dialect;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;
import org.springframework.r2dbc.core.DatabaseClient;

import io.r2dbc.spi.ConnectionFactory;

@Configuration
@EnableR2dbcRepositories( entityOperationsRef = "h2EmployeeEntityTemplate")
public class H2Config {

	@Value("${spring.r2dbc.h2.url}")
	String url;
	
	@Value("${spring.r2dbc.h2.username}")
	String username;
	
	@Value("${spring.r2dbc.h2.password}")
	String password;
	
	@Bean
	@Qualifier(value = "h2ConnectionFactory")
	ConnectionFactory h2ConnectionFactory() {
		// TODO Auto-generated method stub
		return ConnectionFactoryBuilder.withUrl(url).username(username).password(password).build();
	}
	
	@Bean
	R2dbcEntityOperations h2EmployeeEntityTemplate(
			@Qualifier("h2ConnectionFactory") ConnectionFactory connectionFactory) {

		DefaultReactiveDataAccessStrategy strategy = new DefaultReactiveDataAccessStrategy(H2Dialect.INSTANCE);
		DatabaseClient databaseClient = DatabaseClient.builder().connectionFactory(connectionFactory)
				.bindMarkers(H2Dialect.INSTANCE.getBindMarkersFactory()).build();

		return new R2dbcEntityTemplate(databaseClient, strategy);
	
	}
}