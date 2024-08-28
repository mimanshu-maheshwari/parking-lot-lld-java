import exception.ParkingLotException;
import utils.FileAdministrator;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class MainTest {
  public static void main(String[] args){
    try {
      var path = Paths.get("output.txt");
      if(Files.exists(path)) {
        Files.delete(path);
      }
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
    FileAdministrator fileAdministrator = FileAdministrator.getInstance();
    try {
      fileAdministrator.readInput(null);
    } catch (ParkingLotException e) {
      throw new RuntimeException(e);
    }
  }
}
