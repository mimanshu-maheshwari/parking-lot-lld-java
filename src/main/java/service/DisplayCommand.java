package service;

import constant.DisplayType;
import constant.VehicleType;
import repository.ParkingLotRepository;

public class DisplayCommand implements Command {

  private final ParkingLotRepository parkingLotRepository = ParkingLotRepository.getInstance();

//  display free_count <vehicle_type>
//  No. of free slots for <vehicle_type> on Floor <floor_no>: <no_of_free_slots>
//  The above will be printed for each floor.

//  display free_slots <vehicle_type>
//  Free slots for <vehicle_type> on Floor <floor_no>: <comma_separated_values_of_slot_nos>
//  The above will be printed for each floor.

//  display occupied_slots <vehicle_type>
//  Occupied slots for <vehicle_type> on Floor <floor_no>: <comma_separated_values_of_slot_nos>
//  The above will be printed for each floor.

  @Override
  // assuming only one parking lot
  public String execute(String[] details) {
    DisplayType displayType = DisplayType.valueOf(details[1].trim().toUpperCase());
    VehicleType vehicleType = VehicleType.valueOf(details[2].trim().toUpperCase());
    String output = switch (displayType){
      case FREE_COUNT -> parkingLotRepository.getParkingLotMap().values().stream().findFirst().get().countEmptySlots(vehicleType);
      case FREE_SLOTS -> parkingLotRepository.getParkingLotMap().values().stream().findFirst().get().findEmptySlots(vehicleType);
      case OCCUPIED_SLOTS -> parkingLotRepository.getParkingLotMap().values().stream().findFirst().get().findOccupiedSlots(vehicleType);
      default -> "";
    };
    System.out.println(output);
    return output;
  }


}
