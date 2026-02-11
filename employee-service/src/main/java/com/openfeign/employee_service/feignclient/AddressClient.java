// This line declares the package where this file belongs.
// Packages are like folders that organize related classes together.
package com.openfeign.employee_service.feignclient;

// Importing the AddressResponse class.
// This is the object that will hold the response data we get from the address service.
import com.openfeign.employee_service.response.AddressResponse;

// Importing the @FeignClient annotation from Spring Cloud OpenFeign.
// This annotation is used to declare a REST client that can call another microservice.
import org.springframework.cloud.openfeign.FeignClient;

// Importing @GetMapping annotation.
// This tells Spring that we want to make an HTTP GET request to a specific endpoint.
import org.springframework.web.bind.annotation.GetMapping;

// Importing @PathVariable annotation.
// This allows us to pass dynamic values (like employeeId) into the URL path.
import org.springframework.web.bind.annotation.PathVariable;

/**
 * This interface defines a Feign client for communicating with the "address-service".
 *
 * Feign is a tool that makes calling REST APIs much easier.
 * Instead of writing boilerplate code (like RestTemplate or WebClient),
 * Feign automatically generates the HTTP request code for us.
 *
 * @FeignClient annotation:
 * - name = "address-service" → Logical name of the service (used for identification).
 * - url = "http://localhost:8081" → The base URL where the service is running.
 * - path = "/address-service" → A common prefix for all endpoints in this service.
 */
@FeignClient(name = "address-service" , url = "http://localhost:8081" , path = "/address-service")
public interface AddressClient {

    /**
     * This method calls the endpoint: GET http://localhost:8081/address-service/address/{employeeId}
     *
     * @GetMapping("/address/{employeeId}")
     * - Defines the REST endpoint we want to call.
     * - {employeeId} is a placeholder that will be replaced with the actual employee ID.
     *
     * @PathVariable int employeeId
     * - This tells Feign to take the method parameter (employeeId) and insert it into the URL.
     *
     * @return AddressResponse
     * - The response from the address service will be automatically converted into an AddressResponse object.
     */
    @GetMapping("/address/{employeeId}")
    AddressResponse getAddressByEmployeeId(@PathVariable int employeeId);
}