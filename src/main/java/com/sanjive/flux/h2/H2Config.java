//package com.sanjive.flux.h2;
//
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.boot.r2dbc.ConnectionFactoryBuilder;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Lazy;
//import org.springframework.core.io.ClassPathResource;
//import org.springframework.data.r2dbc.config.AbstractR2dbcConfiguration;
//import org.springframework.data.r2dbc.core.DefaultReactiveDataAccessStrategy;
//import org.springframework.data.r2dbc.core.R2dbcEntityOperations;
//import org.springframework.data.r2dbc.core.R2dbcEntityTemplate;
//import org.springframework.data.r2dbc.dialect.H2Dialect;
//import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;
//import org.springframework.r2dbc.connection.init.ConnectionFactoryInitializer;
//import org.springframework.r2dbc.connection.init.ResourceDatabasePopulator;
//import org.springframework.r2dbc.core.DatabaseClient;
//
//import io.r2dbc.h2.CloseableConnectionFactory;
//import io.r2dbc.h2.H2ConnectionConfiguration;
//import io.r2dbc.h2.H2ConnectionFactory;
//import io.r2dbc.spi.ConnectionFactories;
//import io.r2dbc.spi.ConnectionFactory;
//import io.r2dbc.spi.ConnectionFactoryOptions;
//import io.r2dbc.spi.ConnectionFactoryOptions.Builder;
//import jakarta.annotation.PostConstruct;
//
//@Configuration
//@EnableR2dbcRepositories
////(entityOperationsRef = "h2EmployeeEntityTemplate")
//public class H2Config {
//
//	@Bean
//	@Qualifier(value = "h2ConnectionFactory")
//	ConnectionFactory h2ConnectionFactory() {
//		// TODO Auto-generated method stub
//		return ConnectionFactoryBuilder.withUrl("r2dbc:h2:mem://./employeedb").build();
////		return ConnectionFactories.get("r2dbc:h2:file://./employeedb");
//	}
//
////	@Bean
////	R2dbcEntityOperations h2EmployeeEntityTemplate(
////			@Qualifier("h2ConnectionFactory") ConnectionFactory connectionFactory) {
////
////		DefaultReactiveDataAccessStrategy strategy = new DefaultReactiveDataAccessStrategy(H2Dialect.INSTANCE);
////		DatabaseClient databaseClient = DatabaseClient.builder().connectionFactory(connectionFactory)
////				.bindMarkers(H2Dialect.INSTANCE.getBindMarkersFactory()).build();
////
////		return new R2dbcEntityTemplate(databaseClient, strategy);
////	}
////	
////	@PostConstruct
////	public void initialize() {
////		ResourceDatabasePopulator databasePopulator = new ResourceDatabasePopulator();
////		databasePopulator.addScripts(new ClassPathResource("Schema.sql"));
////		databasePopulator.populate(h2ConnectionFactory()).subscribe();
////	}
//
////	@Value("${spring.r2dbc.url}")
////	private String url;
////
////	@Value("${spring.r2dbc.username}")
////	private String username;
////
////	@Value("${spring.r2dbc.password}")
////	private String password;
////
////	@Bean
////	ConnectionFactoryInitializer initializer(@Qualifier("h2ConnectionFactory") ConnectionFactory connectionFactory) {
////
////		ConnectionFactoryInitializer initializer = new ConnectionFactoryInitializer();
////		initializer.setConnectionFactory(connectionFactory);
////		initializer.setDatabasePopulator(new ResourceDatabasePopulator(new ClassPathResource("Schema.sql")));
////
////		return initializer;
////	}
////
////	@Bean
////	ConnectionFactoryBuilder connectionFactoryBuilder() {
////
//////		ConnectionFactoryOptions options = ConnectionFactoryOptions.builder()
//////			    .option(ConnectionFactoryOptions.DRIVER, "h2")
//////			    .option(ConnectionFactoryOptions.USER, username)
//////			    .option(ConnectionFactoryOptions.PASSWORD,password)
//////			    .option(ConnectionFactoryOptions.DATABASE, url)
//////			    .build();
//////		ConnectionFactory connectionFactory = ConnectionFactories.get(url);  
//////		CloseableConnectionFactory connectionFactory = H2ConnectionFactory.inMemory("empdb");
////
////		return ConnectionFactoryBuilder.derivedFrom(connectionFactory());
////	}
////
////	@Bean
////	ConnectionFactory connectionFactory() {
//////		ConnectionFactoryOptions options = ConnectionFactoryOptions.builder()
//////				.option(ConnectionFactoryOptions.DRIVER, "h2").option(ConnectionFactoryOptions.USER, username)
//////				.option(ConnectionFactoryOptions.PASSWORD, password).option(ConnectionFactoryOptions.DATABASE, url)
//////				.build();
//////		ConnectionFactory connectionFactory = ConnectionFactories.get(url);
////		H2ConnectionConfiguration h2=H2ConnectionConfiguration.builder().inMemory("empdb").url("mem:employeedb").username(username).password(password).build();
//////		CloseableConnectionFactory connectionFactory = H2ConnectionFactory.inMemory("empdb");
////		H2ConnectionFactory connectionFactory = new H2ConnectionFactory(h2);
////		return connectionFactory;
////	}
//
////	@Override
////	@Bean
////	static ConnectionFactory connectionFactory() {
////		return ConnectionFactories.get("r2dbc:h2:mem:///employeedb?options=DB_CLOSE_DELAY=-1;DB_CLOSE_ON_EXIT=FALSE");
////	}
//
////	static ConnectionFactory inMemory() {
//////	        H2ConnectionFactory connectionFactory = new H2ConnectionFactory(H2ConnectionConfiguration.builder()
//////	                .inMemory("...")
//////	                .property(H2ConnectionOption.DB_CLOSE_DELAY, "-1")
//////	                .build());
////		return H2ConnectionFactory.inMemory("employeedb");
////	}
////    static ConnectionFactory file() {
////        return new H2ConnectionFactory(
////                H2ConnectionConfiguration.builder()
////                        //.inMemory("testdb")
////                        .file("./employeedb")
////                        .username("sa")
////                        .password("")
////                        .build()
////        );
////    }
//
//}