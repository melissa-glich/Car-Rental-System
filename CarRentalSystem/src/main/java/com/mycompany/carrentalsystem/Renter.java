/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.carrentalsystem;

/**
 *
 * @author Melissa.Mumo
 */
public class Renter {
  // Since we won't change these values, declare them as constants
  private final String fullName;
  private final String city;
  private final String contactNumber;

  // Constructor
  public Renter(String fullName, String city, String contactNumber) {
    this.fullName = fullName;
    this.city = city;
    this.contactNumber = contactNumber;
  }

  // Getters
  public String getFullName() {
    return fullName;
  }

  public String getCity() {
    return city;
  }

  public String getContactNumber() {
    return contactNumber;
  }
}