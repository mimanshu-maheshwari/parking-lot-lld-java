package service;

import dto.ParkingSlot;
import dto.Ticket;
import dto.Vehicle;
import repository.ParkingLotRepository;

import java.util.Optional;

public class ParkVehicleCommand implements Command{

  private final ParkingLotRepository parkingLotRepository = ParkingLotRepository.getInstance();

  // input: park_vehicle <vehicle_type> <reg_no> <color>
  // output:
  // 1) Parked vehicle. Ticket ID: <ticket_id>
  // 2) Print "Parking Lot Full" if slot is not available for that vehicle type.

  @Override
  public String execute(String[] details) {
    Vehicle vehicle = Vehicle.parseVehicle(details);
    Optional<ParkingSlot> slotOptional = parkingLotRepository.findParkingSlot(vehicle);
    if (slotOptional.isPresent()){
      ParkingSlot slot = slotOptional.get();
      slot.setVehicle(vehicle);
      int floorId = slot.getFloorId();
      Ticket ticket = Ticket.generateTicket(slot.getParkingLotId(), floorId, slot.getSlotId());
      System.out.println("Parked vehicle. Ticket ID: " + ticket);
      return "Parked vehicle. Ticket ID: " + ticket;
    }else {
      System.out.println("Parking Lot Full");
      return "Parking Lot Full";
    }
  }

}
