import exception.ParkingLotException;
import utils.FileAdministrator;

public class Main {

  public static void main(String[] args) {
    FileAdministrator fileAdministrator = FileAdministrator.getInstance();
    try {
      fileAdministrator.readInput(null);
    } catch (ParkingLotException e) {
      throw new RuntimeException(e);
    }
  }

}