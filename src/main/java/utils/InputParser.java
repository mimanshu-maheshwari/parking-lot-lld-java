package utils;

import constant.Action;
import exception.ParkingLotException;

import java.util.Arrays;
import java.util.logging.Logger;

public class InputParser {

  private static InputParser instance;
  private static final Logger LOGGER = Logger.getLogger(InputParser.class.getName());

  private InputParser(){}

  public Action parseInput(String[] values) throws ParkingLotException {
    //String[] values = line.split("\\s+");
    Action action = Action.NONE;
    try {
      if (values.length > 0) {
        String actionString = values[0];
         action = Action.valueOf(actionString.trim().toUpperCase());
        // LOGGER.info("Found action: " + action);
        return action;
      }
    } catch (IllegalArgumentException e){
      LOGGER.severe("Unable to parse input: " + Arrays.toString(values) + "\n" + e.getMessage());
      throw new ParkingLotException("Unable to parse input.");
    }
    return action;
  }

  public static InputParser getInstance() {
    if (InputParser.instance == null)
      return instance = new InputParser();
    return instance;
  }

}
