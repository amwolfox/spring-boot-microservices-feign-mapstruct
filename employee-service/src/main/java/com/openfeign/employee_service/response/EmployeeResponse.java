// This line declares the package where this file belongs.
// Packages are like folders that organize related classes together.
package com.openfeign.employee_service.response;

/**
 * This is a Java "record" called EmployeeResponse.
 *
 * A record is a special type of class introduced in Java 14 (finalized in Java 16).
 * It is mainly used to hold data (like a DTO - Data Transfer Object).
 *
 * Records automatically generate:
 * - A constructor with all fields
 * - Getter methods for each field
 * - equals(), hashCode(), and toString() methods
 *
 * So you don’t have to write all the boilerplate code yourself.
 */
public record EmployeeResponse(
        int id,                        // Unique identifier for the employee (like a primary key in a database)
        String name,                   // The employee's full name
        String email,                  // The employee's email address
        String age,                    // The employee's age (stored as a String here, though often age is an int)
        AddressResponse addressResponse // Nested object holding the employee's address details
) {
    // No need to write getters, setters, or constructors.
    // Java automatically provides them for you in a record.
}