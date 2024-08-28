package repository;

import dto.ParkingLot;
import dto.ParkingLotFloor;
import dto.ParkingSlot;
import dto.Vehicle;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

public class ParkingLotRepository {
  private static ParkingLotRepository instance;
  private Map<String, ParkingLot> parkingLotMap;

  private ParkingLotRepository() {
    this.parkingLotMap = new ConcurrentHashMap<>();
  }

  public static ParkingLotRepository getInstance(){
    if(instance == null){
      return instance = new ParkingLotRepository();
    }
    return instance;
  }

  public Map<String, ParkingLot> getParkingLotMap() {
    return parkingLotMap;
  }

  // assuming only one parking slot is present
  public Optional<ParkingSlot> findParkingSlot(Vehicle vehicle){
    Optional<ParkingLot> lotOptional = this.parkingLotMap.values().stream().findFirst();
    Optional<ParkingSlot> slotOptional = Optional.empty();
    if (lotOptional.isPresent()){
      ParkingLot lot = lotOptional.get();
      for(ParkingLotFloor floor: lot.getParkingLotFloors()){
        slotOptional = floor.findEmptySlot(vehicle.getVehicleType());
        if(slotOptional.isPresent()){
          break;
        }
      }
    }
    return slotOptional;
  }

}
