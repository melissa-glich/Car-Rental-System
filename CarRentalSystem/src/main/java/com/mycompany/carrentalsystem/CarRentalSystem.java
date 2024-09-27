package com.mycompany.carrentalsystem;

import java.util.Scanner;

public class CarRentalSystem {

  public static void main(String[] args) {
      try (Scanner scanner = new Scanner(System.in)) {
          RentalAgency rentalAgency = new RentalAgency();
          
          // Creating vehicles (assuming data is still relevant)
          rentalAgency.addVehicle(new Vehicle("Toyota", "Camry", "ABC-123", 50.0));
          rentalAgency.addVehicle(new Vehicle("Honda", "Civic", "DEF-456", 45.0));
          rentalAgency.addVehicle(new Vehicle("Subaru", "Legacy", "GHI-789", 40.0));
          rentalAgency.addVehicle(new Vehicle("Mercedes Benz", "AMG 63", "JKL-012", 60.0));
          
          boolean keepRunning = true;
          
          while (keepRunning) {
              System.out.println("\nChoose an option:");
              System.out.println("1. Rent Vehicle");
              System.out.println("2. Return Vehicle");
              System.out.println("3. Exit");
              
              int option = scanner.nextInt();
              scanner.nextLine(); // Consume the newline character
              
              switch (option) {
                  case 1 -> rentVehicle(scanner, rentalAgency);
                      
                  case 2 -> returnVehicle(scanner, rentalAgency);
                      
                  case 3 -> {
                      System.out.println("Exiting...");
                      keepRunning = false;
                  }
                      
                  default -> System.out.println("Invalid option. Please try again.");
              }
          } }
  }

  private static void rentVehicle(Scanner scanner, RentalAgency rentalAgency) {
    // List available vehicles
    System.out.println("\nAvailable vehicles to rent:");
    for (int i = 0; i < rentalAgency.getAvailableVehicles().size(); i++) {
      Vehicle vehicle = rentalAgency.getAvailableVehicles().get(i);
      System.out.println((i + 1) + ". " + vehicle.getBrand() + " " + vehicle.getVariant() + " (" + vehicle.getRegistration() + ") - $" + vehicle.getDailyRate() + " per day");
    }

    System.out.println((rentalAgency.getAvailableVehicles().size() + 1) + ". Exit");

    System.out.print("\nSelect the vehicle you want to rent: ");
    int vehicleChoice = scanner.nextInt();
    scanner.nextLine(); // Consume newline

    if (vehicleChoice == rentalAgency.getAvailableVehicles().size() + 1) {
      System.out.println("Exiting...");
      return; // Return to the main menu
    }

    if (vehicleChoice > 0 && vehicleChoice <= rentalAgency.getAvailableVehicles().size()) {
      Vehicle vehicleToRent = rentalAgency.getAvailableVehicles().get(vehicleChoice - 1);

      System.out.print("Enter your name: ");
      String renterName = scanner.nextLine();
      System.out.print("Enter your city: ");
      String renterCity = scanner.nextLine();
      System.out.print("Enter your contact number: ");
      String renterContactNumber = scanner.nextLine();

      Renter renter = new Renter(renterName, renterCity, renterContactNumber);
      rentalAgency.rentVehicle(renter, vehicleToRent);

      System.out.println("\n" + renterName + " has rented the vehicle: " + vehicleToRent.getBrand() + " " + vehicleToRent.getVariant() + " (" + vehicleToRent.getRegistration() + ")");
    } else {
      System.out.println("Invalid vehicle selection.");
    }
  }

  private static void returnVehicle(Scanner scanner, RentalAgency rentalAgency) {
    System.out.print("\nEnter your contact number: ");
    String contactNumber = scanner.nextLine();

    Renter renter = rentalAgency.findRenterByContactNumber(contactNumber);
    if (renter == null) {
      System.out.println("No rental record found for this contact number.");
      return;
    }

    Vehicle rentedVehicle = rentalAgency.findVehicleRentedByRenter(renter);
    if (rentedVehicle == null) {
      System.out.println("No vehicle rented under this contact number.");
      return;
    }

    System.out.println("\nYou have rented the following vehicle:");
    System.out.println(rentedVehicle.getBrand() + " " + rentedVehicle.getVariant() + " (" + rentedVehicle.getRegistration() + ")");
    System.out.print("Do you want to return this vehicle? (yes/no): ");
    String confirmation = scanner.nextLine();

    if (confirmation.equalsIgnoreCase("yes")) {
      rentalAgency.returnVehicle(rentedVehicle);
      System.out.println("Vehicle returned successfully.");
    } else {
      System.out.println("Return process canceled.");
    }
  }
}