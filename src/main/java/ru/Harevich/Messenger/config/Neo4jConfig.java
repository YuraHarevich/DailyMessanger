package ru.Harevich.Messenger.config;

import org.neo4j.driver.Driver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.neo4j.core.transaction.Neo4jTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
public class Neo4jConfig {

    @Bean
    public Neo4jTransactionManager transactionManagerNeo4j(Driver driver) {
        // Driver будет автоматически сконфигурирован Spring Boot на основе application.properties
        return new Neo4jTransactionManager(driver);
    }
}