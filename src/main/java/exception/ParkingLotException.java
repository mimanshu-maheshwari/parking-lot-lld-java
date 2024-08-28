package exception;

public class ParkingLotException extends  Exception{

  public ParkingLotException(String message, Exception e) {
    super(message, e);
  }
  public ParkingLotException(String message) {
    super(message);
  }
}
