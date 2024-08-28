package dto;

import constant.VehicleType;

public class ParkingLot {

  // Id
  private String parkingLotId;
  // number of floors
  private Integer numberOfFloors;
  // number of slots per floor
  private Integer numberOfSlotsPerFloor;
  // slots if filled or not
  private ParkingLotFloor[] parkingLotFloors;

  public ParkingLot(String parkingLotId, Integer numberOfFloors, Integer numberOfSlotsPerFloor) {
    this.parkingLotId = parkingLotId;
    this.numberOfFloors = numberOfFloors;
    this.numberOfSlotsPerFloor = numberOfSlotsPerFloor;
    this.parkingLotFloors = new ParkingLotFloor[numberOfFloors];
    for(int i = 0; i < numberOfFloors; i++){
      this.parkingLotFloors[i] = new ParkingLotFloor(i + 1, numberOfSlotsPerFloor, parkingLotId);
    }
  }

  public String findEmptySlots(VehicleType vehicleType){
    StringBuilder output = new StringBuilder();
    for(ParkingLotFloor floor: this.parkingLotFloors) {
      output.append("Free slots for ")
            .append(vehicleType)
            .append(" on Floor ")
            .append(floor.getFloorId())
            .append(": ");
      for (ParkingSlot slot : floor.findEmptySlots(vehicleType)) {
        output.append(slot.getSlotId()).append(",");
      }
      output.deleteCharAt(output.length() - 1);
      output.append("\n");
    }
    output.deleteCharAt(output.length() - 1);
    return output.toString();
  }

  public String countEmptySlots(VehicleType vehicleType){
    StringBuilder output = new StringBuilder();
    for(ParkingLotFloor floor: this.parkingLotFloors) {
      output.append("No. of free slots for ")
            .append(vehicleType)
            .append(" on Floor ")
            .append(floor.getFloorId())
            .append(": ").
            append(floor.findEmptySlots(vehicleType).size())
            .append("\n");
    }
    output.deleteCharAt(output.length() - 1);
    return output.toString();
  }

  public String findOccupiedSlots(VehicleType vehicleType){
    StringBuilder output = new StringBuilder();
    for(ParkingLotFloor floor: this.parkingLotFloors) {
      output.append("Occupied slots for ").append(vehicleType).append(" on Floor ").append(floor.getFloorId()).append(": ");
      for (ParkingSlot slot : floor.findOccupiedSlots(vehicleType)) {
        output.append(slot.getSlotId()).append(",");
      }
      output.deleteCharAt(output.length() - 1);
      output.append("\n");
    }
    output.deleteCharAt(output.length() - 1);
    return output.toString();
  }

  public ParkingLotFloor getFloorById(Integer id){
    if(id > numberOfFloors) return null;
    return this.getParkingLotFloors()[id - 1];
  }

  public String getParkingLotId() {
    return parkingLotId;
  }

  public void setParkingLotId(String parkingLotId) {
    this.parkingLotId = parkingLotId;
  }

  public Integer getNumberOfFloors() {
    return numberOfFloors;
  }

  public void setNumberOfFloors(Integer numberOfFloors) {
    this.numberOfFloors = numberOfFloors;
  }

  public Integer getNumberOfSlotsPerFloor() {
    return numberOfSlotsPerFloor;
  }

  public void setNumberOfSlotsPerFloor(Integer numberOfSlotsPerFloor) {
    this.numberOfSlotsPerFloor = numberOfSlotsPerFloor;
  }

  public ParkingLotFloor[] getParkingLotFloors() {
    return parkingLotFloors;
  }

}
