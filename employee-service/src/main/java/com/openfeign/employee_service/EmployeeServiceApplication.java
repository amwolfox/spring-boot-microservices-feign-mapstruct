// This line declares the package where this file belongs.
// Packages are like folders that organize related classes together.
package com.openfeign.employee_service;

// Importing Spring Boot's main classes.
// These are needed to start and configure a Spring Boot application.
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// Importing the @EnableFeignClients annotation.
// This enables Feign clients in the application (so we can call other microservices easily).
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * This is the main entry point of the Employee Service application.
 *
 * @SpringBootApplication:
 * - A convenience annotation that combines:
 *   1. @Configuration → Marks this class as a source of bean definitions.
 *   2. @EnableAutoConfiguration → Automatically configures Spring based on dependencies.
 *   3. @ComponentScan → Scans for Spring components (like @Service, @Repository, @Controller).
 *
 * @EnableFeignClients:
 * - Enables Feign clients in this application.
 * - This allows us to use interfaces annotated with @FeignClient to call other microservices.
 */
@SpringBootApplication
@EnableFeignClients
public class EmployeeServiceApplication {

    /**
     * The main method is the starting point of any Java application.
     *
     * SpringApplication.run():
     * - Boots up the Spring application.
     * - Starts the embedded server (like Tomcat).
     * - Initializes all beans and configurations.
     *
     * @param args - Command-line arguments (not usually needed for basic apps).
     */
    public static void main(String[] args) {
        SpringApplication.run(EmployeeServiceApplication.class, args);
    }
}