package com.manju7.testapp;

public class CarDetails {

    String address;
    String coordinates;
    String engineType;
    String exterior;
    String fuel;
    String interior;
    String name;
    String vin;

    public CarDetails(String address, String coordinates, String engineType, String exterior, String fuel, String interior, String name, String vin) {
        this.address = address;
        this.coordinates = coordinates;
        this.engineType = engineType;
        this.exterior = exterior;
        this.fuel = fuel;
        this.interior = interior;
        this.name = name;
        this.vin = vin;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(String coordinates) {
        this.coordinates = coordinates;
    }

    public String getEngineType() {
        return engineType;
    }

    public void setEngineType(String engineType) {
        this.engineType = engineType;
    }

    public String getExterior() {
        return exterior;
    }

    public void setExterior(String exterior) {
        this.exterior = exterior;
    }

    public String getFuel() {
        return fuel;
    }

    public void setFuel(String fuel) {
        this.fuel = fuel;
    }

    public String getInterior() {
        return interior;
    }

    public void setInterior(String interior) {
        this.interior = interior;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }
}
