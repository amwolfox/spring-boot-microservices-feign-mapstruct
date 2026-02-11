// This line declares the package where this file belongs.
// Packages are like folders that organize related classes together.
package com.openfeign.employee_service.response;

/**
 * This is a Java "record" called AddressResponse.
 *
 * A record is a special type of class introduced in Java 14 (and finalized in Java 16).
 * It is mainly used to hold data (like a DTO - Data Transfer Object).
 *
 * Records automatically generate:
 * - A constructor with all fields
 * - Getter methods for each field
 * - equals(), hashCode(), and toString() methods
 *
 * So you don’t have to write all the boilerplate code yourself.
 */
public record AddressResponse(
        int id,       // Unique identifier for the address (like a primary key in a database)
        String city,  // The city where the employee lives
        String state  // The state where the employee lives
) {
    // No need to write getters, setters, or constructors.
    // Java automatically provides them for you in a record.
}