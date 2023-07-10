package com.sanjive.flux;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;
import org.springframework.r2dbc.connection.init.ConnectionFactoryInitializer;
import org.springframework.r2dbc.connection.init.ResourceDatabasePopulator;
import org.springframework.web.reactive.config.EnableWebFlux;

import io.r2dbc.spi.ConnectionFactory;

@SpringBootApplication
@EnableWebFlux
public class SpringFluxApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringFluxApplication.class, args);
	}

//	@Bean
//	ConnectionFactoryInitializer initializer(@Qualifier("h2ConnectionFactory") ConnectionFactory connectionFactory) {
//
//		ConnectionFactoryInitializer initializer = new ConnectionFactoryInitializer();
//		initializer.setConnectionFactory(connectionFactory);
//		initializer.setDatabasePopulator(new ResourceDatabasePopulator(new ClassPathResource("Schema.sql")));
//
//		return initializer;
//	}
}
