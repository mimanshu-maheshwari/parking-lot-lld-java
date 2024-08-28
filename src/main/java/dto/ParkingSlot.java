package dto;

import constant.VehicleType;

public class ParkingSlot {
  private final Integer slotId;
  private final Integer floorId;
  private final String parkingLotId;
  private final VehicleType allowedVehicleType;
  private Vehicle vehicle;

  public ParkingSlot(Integer slotId, VehicleType allowedVehicleType, Integer floorId, String parkingLotId) {
    this.slotId = slotId;
    this.allowedVehicleType = allowedVehicleType;
    this.floorId = floorId;
    this.parkingLotId = parkingLotId;
  }

  public Integer getSlotId() {
    return slotId;
  }

  public VehicleType getAllowedVehicleType() {
    return allowedVehicleType;
  }

  public Vehicle getVehicle() {
    return vehicle;
  }

  public void setVehicle(Vehicle vehicle) {
    this.vehicle = vehicle;
  }

  public Integer getFloorId() {
    return floorId;
  }

  public String getParkingLotId() {
    return parkingLotId;
  }

  @Override
  public String toString() {
    return "ParkingSlot{" +
      "slotId=" + slotId +
      ", floorId=" + floorId +
      ", parkingLotId='" + parkingLotId + '\'' +
      ", allowedVehicleType=" + allowedVehicleType +
      ", vehicle=" + vehicle +
      '}';
  }

}
