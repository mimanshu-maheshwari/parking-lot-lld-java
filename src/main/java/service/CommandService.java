package service;

import constant.Action;
import exception.ParkingLotException;
import utils.FileAdministrator;

import java.util.logging.Logger;

public class CommandService {
  private static CommandService instance;
  private static final Logger logger = Logger.getLogger(CommandService.class.getName());

  private CommandService(){}

  public void executeCommand(Action action, String[] details) throws ParkingLotException {
    String output = switch (action){
      case CREATE_PARKING_LOT -> new CreateParkingLotCommand().execute(details);
      case DISPLAY -> new DisplayCommand().execute(details);
      case PARK_VEHICLE -> new ParkVehicleCommand().execute(details);
      case UNPARK_VEHICLE-> new UnparkVehicleCommand().execute(details);
      case NONE, EXIT -> null;
    };
    FileAdministrator.appendOutput(output);
  }

  public static CommandService getInstance(){
    if (instance == null){
      return instance = new CommandService();
    }
    return instance;
  }
}
