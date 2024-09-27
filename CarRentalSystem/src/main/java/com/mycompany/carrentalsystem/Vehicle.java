package com.mycompany.carrentalsystem;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Melissa.Mumo
 */
public class Vehicle {
    // Since in this scope of the project, we won't be changing these values, let's just declare them as constants
    private final String brand;
    private final String registration;
    private final double dailyRate;
    private boolean isOut;

    // Constructor
    public Vehicle(String brand, String registration, double dailyRate) {
        this.brand = brand;
        this.registration = registration;
        this.dailyRate = dailyRate;
        this.isOut = false;
    }

    Vehicle(String toyota, String camry, String abC123, double d) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    // Getters and setters
    public String getBrand() {
        return brand;
    }

    public String getRegistration() {
        return registration;
    }

    public double getDailyRate() {
        return dailyRate;
    }

    public boolean isOut() {
        return isOut;
    }

    public void rentOut() {
        isOut = true;
    }

    public void returnVehicle() {
        isOut = false;
    }

    public String getModel() {
        throw new UnsupportedOperationException("Not supported yet."); }

    String getVariant() {
        throw new UnsupportedOperationException("Not supported yet."); }
}