package service;

import dto.ParkingLot;
import dto.ParkingLotFloor;
import dto.ParkingSlot;
import dto.Ticket;
import dto.Vehicle;
import repository.ParkingLotRepository;

public class UnparkVehicleCommand implements Command{

  private final ParkingLotRepository parkingLotRepository = ParkingLotRepository.getInstance();

  // input: unpark_vehicle <ticket_id>
  // output:
  // 1) Un-parked vehicle with Registration Number: <reg_no> and Color: <color>
  // 2) Print "Invalid Ticket" if ticket is invalid or parking slot is not occupied.
  @Override
  public String execute(String[] details) {
    Ticket ticket = Ticket.parseTicket(details[1]);
    int floorNbr = ticket.getFloorNbr();
    int slotNbr = ticket.getSlotNbr();
    String parkingLotId = ticket.getParkingLotId();
    ParkingLot lot = this.parkingLotRepository.getParkingLotMap().get(parkingLotId);
    if(lot == null){
      System.out.println("Invalid Ticket");
      return "Invalid Ticket";
    }
    ParkingLotFloor floor = lot.getFloorById(floorNbr);
    if(floor == null){
      System.out.println("Invalid Ticket");
      return "Invalid Ticket";
    }
    ParkingSlot slot = floor.getSlotById(slotNbr);
    if(slot == null){
      System.out.println("Invalid Ticket");
      return "Invalid Ticket";
    }
    Vehicle vehicle = slot.getVehicle();
    if(vehicle == null){
      System.out.println("Invalid Ticket");
      return "Invalid Ticket";
    } else {
      slot.setVehicle(null);
      System.out.println("Un-parked vehicle with Registration Number: " + vehicle.getRegistrationNumber() + " and Color: " + vehicle.getColor() );
      return "Un-parked vehicle with Registration Number: " + vehicle.getRegistrationNumber() + " and Color: " + vehicle.getColor();
    }
  }

}
