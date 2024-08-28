package dto;

public class Ticket {
  private static final String SEPARATOR = "_";
  private String parkingLotId;
  private Integer floorNbr;
  private Integer slotNbr;

  private Ticket(String parkingLotId, Integer floorNbr, Integer slotNbr) {
    this.parkingLotId = parkingLotId;
    this.floorNbr = floorNbr;
    this.slotNbr = slotNbr;
  }

  public static Ticket parseTicket(String ticket){
    String[] tstr = ticket.split(SEPARATOR);
    return new Ticket(
      tstr[0],
      Integer.valueOf(tstr[1]),
      Integer.valueOf(tstr[2])
    );
  }

  public static Ticket generateTicket(String parkingLotId, Integer floorNbr, Integer slotNbr){
    return new Ticket(parkingLotId, floorNbr, slotNbr);
  }

  @Override
  public String toString(){
    return parkingLotId + SEPARATOR + floorNbr + SEPARATOR + slotNbr;
  }

  public String getParkingLotId() {
    return parkingLotId;
  }

  public Integer getFloorNbr() {
    return floorNbr;
  }

  public Integer getSlotNbr() {
    return slotNbr;
  }

}
