package com.example.cscproject;

import java.io.Serializable;

public class car implements Serializable{
    public String carPlate;
    public String carBrand;
    public String carModel;
    public double carPrice;
    public int carYears;
    public String carPic;
    public String carStatus;

    public car() {}

    public String getCarPlate() {
        return carPlate;
    }

    public void setCarPlate(String carPlate) {
        this.carPlate = carPlate;
    }

    public String getCarBrand() {
        return carBrand;
    }

    public void setCarBrand(String carBrand) {
        this.carBrand = carBrand;
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public double getCarPrice() {
        return carPrice;
    }

    public void setCarPrice(double carPrice) {
        this.carPrice = carPrice;
    }

    public int getCarYears() {
        return carYears;
    }

    public void setCarYears(int carYears) {
        this.carYears = carYears;
    }

    public String getCarPic() {
        return carPic;
    }

    public void setCarPic(String carPic) {
        this.carPic = carPic;
    }

    public String getCarStatus() {
        return carStatus;
    }

    public void setCarStatus(String carStatus) {
        this.carStatus = carStatus;
    }

    @Override
    public String toString() {
        return "car{" +
                "carPlate='" + carPlate + '\'' +
                ", carBrand='" + carBrand + '\'' +
                ", carModel='" + carModel + '\'' +
                ", carPrice=" + carPrice +
                ", carYears=" + carYears +
                ", carPic='" + carPic + '\'' +
                ", carStatus='" + carStatus + '\'' +
                '}';
    }
}