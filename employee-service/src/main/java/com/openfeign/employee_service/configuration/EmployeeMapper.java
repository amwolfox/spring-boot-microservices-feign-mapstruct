// This line declares the package where this file belongs.
// Think of a package as a folder that groups related classes together.
package com.openfeign.employee_service.configuration;

// Importing the Employee class from the 'entity' package.
// This represents the Employee object in your system (like a database record).
import com.openfeign.employee_service.entity.Employee;

// Importing the EmployeeResponse class from the 'response' package.
// This is usually a Data Transfer Object (DTO) used to send employee data to clients (like APIs).
import com.openfeign.employee_service.response.EmployeeResponse;

// Importing MapStruct's @Mapper annotation.
// MapStruct is a library that automatically generates code to convert one object into another.
import org.mapstruct.Mapper;

// Importing MapStruct's @Mapping annotation.
// This allows us to define specific rules for how fields should be mapped between objects.
import org.mapstruct.Mapping;

/**
 * This interface defines a "mapper" that converts Employee objects into EmployeeResponse objects.
 *
 * MapStruct will automatically generate the implementation code at compile time.
 *
 * The 'componentModel = "spring"' part tells MapStruct to make this mapper a Spring Bean,
 * so it can be injected and used anywhere in the Spring application.
 */
@Mapper(componentModel = "spring")
public interface EmployeeMapper {

    /**
     * This method converts an Employee object into an EmployeeResponse object.
     *
     * @Mapping(target = "addressResponse", ignore = true)
     * - This tells MapStruct to ignore the 'addressResponse' field when mapping.
     *   (Maybe because address mapping is handled separately or not needed here.)
     *
     * @param employee - The source object (Employee) that contains data from the database.
     * @return EmployeeResponse - The target object that will be sent to clients (like in an API response).
     */
    @Mapping(target = "addressResponse", ignore = true)
    EmployeeResponse toResponse(Employee employee);
}