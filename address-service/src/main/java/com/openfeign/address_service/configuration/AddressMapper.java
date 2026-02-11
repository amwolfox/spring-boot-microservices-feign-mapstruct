// This line declares the package where this file belongs.
// Packages are like folders that organize related classes together.
package com.openfeign.address_service.configuration;

// Importing the Address entity class.
// This represents the Address table in the database.
import com.openfeign.address_service.entity.Address;

// Importing the AddressResponse record.
// This is a Data Transfer Object (DTO) used to send address data to clients (like APIs).
import com.openfeign.address_service.response.AddressResponse;

// Importing MapStruct's @Mapper annotation.
// MapStruct is a library that automatically generates code to convert one object into another.
import org.mapstruct.Mapper;

/**
 * This interface defines a "mapper" that converts Address objects into AddressResponse objects.
 *
 * MapStruct will automatically generate the implementation code at compile time.
 *
 * The 'componentModel = "spring"' part tells MapStruct to make this mapper a Spring Bean,
 * so it can be injected and used anywhere in the Spring application.
 */
@Mapper(componentModel = "spring")
public interface AddressMapper {

    /**
     * This method converts an Address entity (from the database) into an AddressResponse DTO.
     *
     * @param address - The source object (Address) that contains data from the database.
     * @return AddressResponse - The target object that will be sent to clients (like in an API response).
     *
     * Note: MapStruct automatically maps fields with the same names.
     * Since Address and AddressResponse both have fields like id, city, and state,
     * MapStruct will handle the conversion without extra configuration.
     */
    public AddressResponse toResponse(Address address);
}