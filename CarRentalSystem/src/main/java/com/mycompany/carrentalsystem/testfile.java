/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.carrentalsystem;

/**
 *
 * @author lenovo
 */
CarTest.java

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CarTest {

    @Test
    public void testCarCreation() {
        Car car = new Car("Honda", "Civic", "XYZ789", 50.0);
        assertEquals("Honda", car.getMake());
        assertEquals("Civic", car.getModel());
        assertEquals("XYZ789", car.getLicensePlate());
        assertEquals(50.0, car.getRentalPricePerDay());
        assertFalse(car.isRented());
    }

    @Test
    public void testRentCar() {
        Car car = new Car("Ford", "Focus", "LMN456", 60.0);
        car.rent();
        assertTrue(car.isRented());
    }

    @Test
    public void testReturnCar() {
        Car car = new Car("Chevrolet", "Malibu", "OPQ123", 55.0);
        car.rent();
        assertTrue(car.isRented());
        car.returnCar();
        assertFalse(car.isRented());
    }

    @Test
    public void testCarRentalPrice() {
        Car car = new Car("Nissan", "Altima", "RST789", 45.0);
        assertEquals(45.0, car.getRentalPricePerDay());
    }
}

CustomerTest.java

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CustomerTest {

    @Test
    public void testCustomerCreation() {
        Customer customer = new Customer("Alice Smith", "C002");
        assertEquals("Alice Smith", customer.getName());
        assertEquals("C002", customer.getId());
    }

    @Test
    public void testCustomerId() {
        Customer customer = new Customer("Bob Johnson", "C003");
        assertEquals("C003", customer.getId());
    }

    @Test
    public void testCustomerName() {
        Customer customer = new Customer("Charlie Brown", "C004");
        assertEquals("Charlie Brown", customer.getName());
    }
}





RentalAgencyTest.java


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RentalAgencyTest {
    private RentalAgency agency;
    private Car car1;
    private Customer customer1;

    @BeforeEach
    public void setUp() {
        agency = new RentalAgency();
        car1 = new Car("Toyota", "Corolla", "ABC123", 40.0);
        customer1 = new Customer("John Doe", "C001");
        agency.addCar(car1);
        agency.addCustomer(customer1);
    }

    @Test
    public void testRentCarSuccess() {
        String result = agency.rentCar("ABC123", "C001", 3);
        assertEquals("Car rented successfully. Total cost: $120.0", result);
    }

    @Test
    public void testRentCarNotFound() {
        String result = agency.rentCar("XYZ999", "C001", 3);
        assertEquals("Car not found.", result);
    }

    @Test
    public void testRentCarAlreadyRented() {
        agency.rentCar("ABC123", "C001", 3);
        String result = agency.rentCar("ABC123", "C001", 2);
        assertEquals("Car is already rented.", result);
    }

    @Test
    public void testReturnCarSuccess() {
        agency.rentCar("ABC123", "C001", 3);
        String result = agency.returnCar("ABC123");
        assertEquals("Car returned successfully.", result);
    }

    @Test
    public void testReturnCarNotRented() {
        String result = agency.returnCar("ABC123");
        assertEquals("Car is not rented.", result);
    }

    @Test
    public void testReturnCarNotFound() {
        String result = agency.returnCar("XYZ999");
        assertEquals("Car not found.", result);
    }

    private void assertEquals(String car_not_found) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}