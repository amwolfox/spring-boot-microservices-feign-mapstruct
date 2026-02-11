// This line declares the package where this file belongs.
// Packages are like folders that organize related classes together.
package com.openfeign.employee_service.service;

// Importing the EmployeeMapper interface.
// This is used to convert Employee objects into EmployeeResponse objects.
import com.openfeign.employee_service.configuration.EmployeeMapper;

// Importing the Employee entity class.
// This represents the Employee table in the database.
import com.openfeign.employee_service.entity.Employee;

// Importing the AddressClient interface.
// This is a Feign client used to call the Address microservice.
import com.openfeign.employee_service.feignclient.AddressClient;

// Importing the EmployeeRepository interface.
// This is used to interact with the database (fetch employee records).
import com.openfeign.employee_service.repository.EmployeeRepository;

// Importing the AddressResponse record.
// This holds address details returned from the Address microservice.
import com.openfeign.employee_service.response.AddressResponse;

// Importing the EmployeeResponse record.
// This holds employee details (including address) that will be sent back to the client.
import com.openfeign.employee_service.response.EmployeeResponse;

// Importing Lombok's @RequiredArgsConstructor annotation.
// This automatically generates a constructor with required arguments (final fields).
import lombok.RequiredArgsConstructor;

// Importing Spring's @Service annotation.
// This marks the class as a "Service" component in the Spring framework.
import org.springframework.stereotype.Service;

/**
 * EmployeeService is a Spring Service class.
 *
 * It contains business logic for handling employee-related operations.
 *
 * @Service → Marks this class as a service so Spring can manage it.
 * @RequiredArgsConstructor → Automatically creates a constructor for all final fields.
 * This means we don’t need to manually write a constructor for dependency injection.
 */
@Service
@RequiredArgsConstructor
public class EmployeeService {

    // Dependencies (final fields) injected automatically by Spring:
    private final EmployeeRepository employeeRepository; // For database operations
    private final EmployeeMapper employeeMapper;         // For mapping Employee → EmployeeResponse
    private final AddressClient addressClient;           // For calling the Address microservice

    /**
     * This method fetches an employee by their ID and also retrieves their address.
     *
     * Steps:
     * 1. Fetch employee details from the database using EmployeeRepository.
     * 2. Convert Employee entity → EmployeeResponse DTO using EmployeeMapper.
     * 3. Call AddressClient (Feign client) to get the employee's address from another microservice.
     * 4. Combine employee details + address into a final EmployeeResponse object.
     * 5. Return the complete EmployeeResponse to the caller (like a REST controller).
     *
     * @param id - The unique identifier of the employee.
     * @return EmployeeResponse - A DTO containing employee + address details.
     */
    public EmployeeResponse getEmployeeById(int id) {
        // Step 1: Fetch employee from database.
        // If employee is not found, throw a RuntimeException.
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found"));

        // Step 2: Convert Employee entity → EmployeeResponse DTO (without address yet).
        EmployeeResponse employeeResponse = employeeMapper.toResponse(employee);

        // Step 3: Call Address microservice to fetch address by employeeId.
        AddressResponse address = addressClient.getAddressByEmployeeId(id);

        // Step 4: Create a new EmployeeResponse object that includes both employee + address.
        return new EmployeeResponse(
                employeeResponse.id(),     // Employee ID
                employeeResponse.name(),   // Employee Name
                employeeResponse.email(),  // Employee Email
                employeeResponse.age(),    // Employee Age
                address                    // Employee Address (from AddressResponse)
        );
    }
}