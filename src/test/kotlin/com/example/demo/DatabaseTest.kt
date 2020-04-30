package com.example.demo

import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.util.TestPropertyValues
import org.springframework.context.ApplicationContextInitializer
import org.springframework.context.ConfigurableApplicationContext
import org.springframework.test.context.ContextConfiguration
import org.testcontainers.containers.PostgreSQLContainer
import org.testcontainers.junit.jupiter.Container
import org.testcontainers.junit.jupiter.Testcontainers

class KPostgresContainer: PostgreSQLContainer<KPostgresContainer>()

@Testcontainers
@SpringBootTest
@ContextConfiguration(initializers = [DatabaseTest.Initializer::class])
class DatabaseTest {

    companion object {
        @Container
        val container = KPostgresContainer()
                .withExposedPorts(5432)
                .withDatabaseName("test")
                .withUsername("postgres")
                .withPassword("postgres")
    }

    class Initializer : ApplicationContextInitializer<ConfigurableApplicationContext> {
        override fun initialize(applicationContext: ConfigurableApplicationContext) {
            TestPropertyValues.of(
                    "spring.datasource.url=jdbc:postgresql://localhost:${container.firstMappedPort}/test"
            ).applyTo(applicationContext.environment)
        }
    }

}