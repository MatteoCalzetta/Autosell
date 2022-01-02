package com.autosell.model;

public class Ad {

    private Long id;
    private Long sellerId;
    private Long carId;
    private String price;
    private String state;
    private String kilometers;

    public Ad() {
    }

    public Ad(Long sellerId, Long carId, String price, String state, String kilometers) {
        this.sellerId = sellerId;
        this.carId = carId;
        this.price = price;
        this.state = state;
        this.kilometers = kilometers;
    }

    public Ad(Long id, Long sellerId, Long carId, String price, String state, String kilometers) {
        this.id = id;
        this.sellerId = sellerId;
        this.carId = carId;
        this.price = price;
        this.state = state;
        this.kilometers = kilometers;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSellerId() {
        return sellerId;
    }

    public void setSellerId(Long sellerId) {
        this.sellerId = sellerId;
    }

    public Long getCarId() {
        return carId;
    }

    public void setCarId(Long carId) {
        this.carId = carId;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getKilometers() {
        return kilometers;
    }

    public void setKilometers(String kilometers) {
        this.kilometers = kilometers;
    }

    @Override
    public String toString() {
        return "Ad = [" + id + ", " + sellerId + ", " + carId + ", " + price + ", " + state + ", " + "kilometers}";
    }
}
