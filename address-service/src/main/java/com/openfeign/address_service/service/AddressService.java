// This line declares the package where this file belongs.
// Packages are like folders that organize related classes together.
package com.openfeign.address_service.service;

// Importing the AddressMapper interface.
// This is used to convert Address entities into AddressResponse DTOs.
import com.openfeign.address_service.configuration.AddressMapper;

// Importing the Address entity class.
// This represents the Address table in the database.
import com.openfeign.address_service.entity.Address;

// Importing the AddressRepository interface.
// This is used to interact with the database (fetch address records).
import com.openfeign.address_service.repository.AddressRepository;

// Importing the AddressResponse record.
// This is a DTO (Data Transfer Object) used to send address data to clients (like APIs).
import com.openfeign.address_service.response.AddressResponse;

// Importing Lombok's @RequiredArgsConstructor annotation.
// This automatically generates a constructor with required arguments (final fields).
import lombok.RequiredArgsConstructor;

// Importing Spring's @Service annotation.
// This marks the class as a "Service" component in the Spring framework.
import org.springframework.stereotype.Service;

/**
 * AddressService is a Spring Service class.
 *
 * It contains business logic for handling address-related operations.
 *
 * @Service → Marks this class as a service so Spring can manage it.
 * @RequiredArgsConstructor → Automatically creates a constructor for all final fields.
 * This means we don’t need to manually write a constructor for dependency injection.
 */
@Service
@RequiredArgsConstructor
public class AddressService {

    // Dependencies (final fields) injected automatically by Spring:
    private final AddressRepository addressRepository; // For database operations
    private final AddressMapper addressMapper;         // For mapping Address → AddressResponse

    /**
     * This method fetches an address by the employee's ID.
     *
     * Steps:
     * 1. Use AddressRepository to query the database for an address linked to the given employeeId.
     * 2. If no address is found, throw a RuntimeException with a clear error message.
     * 3. If found, convert the Address entity → AddressResponse DTO using AddressMapper.
     * 4. Return the AddressResponse to the caller (like a REST controller).
     *
     * @param employeeId - The unique identifier of the employee.
     * @return AddressResponse - A DTO containing the employee's address details.
     */
    public AddressResponse findAddressByEmployeeId(int employeeId) {
        // Step 1: Fetch address from database by employeeId.
        // Step 2: If not found, throw an exception.
        Address address = addressRepository.findAddressByEmployeeId(employeeId)
                .orElseThrow(() -> new RuntimeException("Address not found with employeeId: " + employeeId));

        // Step 3: Convert Address entity → AddressResponse DTO.
        return addressMapper.toResponse(address);
    }
}