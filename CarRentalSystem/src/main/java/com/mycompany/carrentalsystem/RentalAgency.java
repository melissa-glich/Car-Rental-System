/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.carrentalsystem;

/**
 *
 * @author Melissa.Mumo
 */
import java.util.ArrayList;
import java.util.List;

public class RentalAgency {
  private final List<Vehicle> availableVehicles;
  private final List<Vehicle> rentedVehicles;
  private final List<Renter> renters; // List of renters

  // Constructor
  public RentalAgency() {
    availableVehicles = new ArrayList<>();
    rentedVehicles = new ArrayList<>();
    renters = new ArrayList<>();
  }

  // Methods
  public void addVehicle(Vehicle vehicle) {
    availableVehicles.add(vehicle);
  }

  public void rentVehicle(Renter renter, Vehicle vehicle) {
    if (!vehicle.isOut()) {
      rentedVehicles.add(vehicle);
      availableVehicles.remove(vehicle);
      renters.add(renter); // Add renter to the list when they rent a vehicle
      vehicle.rentOut();
    } else {
      System.out.println("Vehicle is already rented.");
    }
  }

  public void returnVehicle(Vehicle vehicle) {
    if (vehicle.isOut()) {
      rentedVehicles.remove(vehicle);
      availableVehicles.add(vehicle);
      vehicle.returnVehicle();
    } else {
      System.out.println("Vehicle is not currently rented.");
    }
  }

  // Getter methods
  public List<Vehicle> getAvailableVehicles() {
    return availableVehicles;
  }

  public List<Vehicle> getRentedVehicles() {
    return rentedVehicles;
  }

  public List<Renter> getRenters() {
    return renters;
  }

  // New method to find a vehicle rented by a specific renter
  public Vehicle findVehicleRentedByRenter(Renter renter) {
    for (Vehicle vehicle : rentedVehicles) {
      // For now, assume a one-to-one relationship between renter and vehicle
      if (renters.contains(renter)) {
        return vehicle;
      }
    }
    return null; // Return null if no vehicle is found for the renter
  }

  // Method to find a renter by contact number
  public Renter findRenterByContactNumber(String contactNumber) {
    for (Renter renter : renters) {
      if (renter.getContactNumber().equals(contactNumber)) {
        return renter;
      }
    }
    return null; // Return null if no renter is found with this contact number
  }

    String returnCar(String xyZ999) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
