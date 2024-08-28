package dto;

import constant.VehicleType;

public class Vehicle {
  private String registrationNumber;
  private String color;
  private VehicleType vehicleType;

  public Vehicle(String registrationNumber, String color, VehicleType vehicleType) {
    this.registrationNumber = registrationNumber;
    this.color = color;
    this.vehicleType = vehicleType;
  }

  public static Vehicle parseVehicle(String[] details){
    return new Vehicle(details[2], details[3], VehicleType.valueOf(details[1].trim().toUpperCase()));
  }

  public String getRegistrationNumber() {
    return registrationNumber;
  }

  public void setRegistrationNumber(String registrationNumber) {
    this.registrationNumber = registrationNumber;
  }

  public String getColor() {
    return color;
  }

  public void setColor(String color) {
    this.color = color;
  }

  public VehicleType getVehicleType() {
    return vehicleType;
  }

  public void setVehicleType(VehicleType vehicleType) {
    this.vehicleType = vehicleType;
  }

}
