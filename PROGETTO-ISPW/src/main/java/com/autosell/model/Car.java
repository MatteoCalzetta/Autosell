package com.autosell.model;

public class Car {

    private Long id;
    private String manufacturer;
    private String model;
    private String fuelType;
    private String horsepower;
    private String doorsNumber;
    private String seatsNumber;
    private String color;
    private String transmissionType;
    private String carBody;

    public Car() {
    }

    public Car(Long id, String manufacturer, String model, String fuelType, String horsepower, String doorsNumber, String seatsNumber, String color, String transmissionType, String carBody) {
        this.id = id;
        this.manufacturer = manufacturer;
        this.model = model;
        this.fuelType = fuelType;
        this.horsepower = horsepower;
        this.doorsNumber = doorsNumber;
        this.seatsNumber = seatsNumber;
        this.color = color;
        this.transmissionType = transmissionType;
        this.carBody = carBody;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public String getHorsepower() {
        return horsepower;
    }

    public void setHorsepower(String horsepower) {
        this.horsepower = horsepower;
    }

    public String getDoorsNumber() {
        return doorsNumber;
    }

    public void setDoorsNumber(String doorsNumber) {
        this.doorsNumber = doorsNumber;
    }

    public String getSeatsNumber() {
        return seatsNumber;
    }

    public void setSeatsNumber(String seatsNumber) {
        this.seatsNumber = seatsNumber;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getTransmissionType() {
        return transmissionType;
    }

    public void setTransmissionType(String transmissionType) {
        this.transmissionType = transmissionType;
    }

    public String getCarBody() {
        return carBody;
    }

    public void setCarBody(String carBody) {
        this.carBody = carBody;
    }

    @Override
    public String toString() {
        return "Car = [" + id + ", " + manufacturer + ", " + model + ", " + fuelType + ", " + horsepower + ", "
                + doorsNumber + ", " + seatsNumber + ", " + color + ", " + transmissionType + ", " + carBody + "]";

    }
}
