package service;

import dto.ParkingLot;
import repository.ParkingLotRepository;

public class CreateParkingLotCommand implements Command{

  private final ParkingLotRepository parkingLotRepository = ParkingLotRepository.getInstance();

  // input:
  // create_parking_lot <parking_lot_id> <no_of_floors> <no_of_slots_per_floor>
  // output:
  // Created parking lot with <no_of_floors> floors and <no_of_slots_per_floor> slots per floor
  @Override
  public String execute(String[] details) {
    ParkingLot parkingLot = new ParkingLot(
      details[1],
      Integer.valueOf(details[2]),
      Integer.valueOf(details[3])
    );
    this.parkingLotRepository.getParkingLotMap().put(parkingLot.getParkingLotId(), parkingLot);
    System.out.println("Created parking lot with "
                         + parkingLot.getNumberOfFloors()
                         + " floors and "
                         + parkingLot.getNumberOfSlotsPerFloor()
                         + " slots per floor"
    );
    return "Created parking lot with "
      + parkingLot.getNumberOfFloors()
      + " floors and "
      + parkingLot.getNumberOfSlotsPerFloor()
      + " slots per floor";
  }

}
