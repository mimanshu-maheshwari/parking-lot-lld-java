package dto;

import constant.VehicleType;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ParkingLotFloor {
  private final Integer floorId;
  private final String parkingLotId;
  private ParkingSlot[] parkingSlots;

  public ParkingLotFloor(Integer floorId, Integer numberOfParkingSlots, String parkingLotId) {
    this.floorId = floorId;
    this.parkingLotId = parkingLotId;
    // sets parking slots for floor
    this.parkingSlots = new ParkingSlot[numberOfParkingSlots];
    for(int i = 0; i < numberOfParkingSlots; i++){
      if(i > 2 ){
        parkingSlots[i] = new ParkingSlot(i + 1, VehicleType.CAR, floorId, parkingLotId);
      } else if(i > 0){
        parkingSlots[i] = new ParkingSlot(i + 1, VehicleType.BIKE, floorId, parkingLotId);
      } else {
        parkingSlots[i] = new ParkingSlot(i + 1, VehicleType.TRUCK, floorId, parkingLotId);
      }
    }
  }

  public ParkingSlot getSlotById(Integer id){
    if(id > parkingSlots.length){
      return null;
    }
    return parkingSlots[id - 1];
  }

  public Optional<ParkingSlot> findEmptySlot(VehicleType vehicleType){
    for(ParkingSlot slot: this.parkingSlots){
      if(slot.getAllowedVehicleType().equals(vehicleType) && slot.getVehicle() == null){
        return Optional.of(slot);
      }
    }
    return Optional.empty();
  }

  public List<ParkingSlot> findEmptySlots(VehicleType vehicleType){
    List<ParkingSlot> slots = new ArrayList<>();
    for(ParkingSlot slot: this.parkingSlots){
      if(slot.getAllowedVehicleType().equals(vehicleType) && slot.getVehicle() == null){
        slots.add(slot);
      }
    }
    return slots;
  }

  public List<ParkingSlot> findOccupiedSlots(VehicleType vehicleType){
    List<ParkingSlot> slots = new ArrayList<>();
    for(ParkingSlot slot: this.parkingSlots){
      if(slot.getAllowedVehicleType().equals(vehicleType) && slot.getVehicle() != null){
        slots.add(slot);
      }
    }
    return slots;
  }

  public Integer getFloorId() {
    return floorId;
  }

  public ParkingSlot[] getParkingSlots() {
    return parkingSlots;
  }

  public void setParkingSlots(ParkingSlot[] parkingSlots) {
    this.parkingSlots = parkingSlots;
  }

  public String getParkingLotId() {
    return parkingLotId;
  }

}
