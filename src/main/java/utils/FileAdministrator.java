package utils;

import constant.Action;
import exception.ParkingLotException;
import service.CommandService;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.logging.Logger;

// TODO: will need to split in separate file as FileWriter and reader.
public class FileAdministrator {
  private static FileAdministrator instance;

  private static final String DEFAULT_INPUT_FILE = "input.txt";
  private static final String DEFAULT_OUTPUT_FILE = "output.txt";
  private static final String DEFAULT_OUTPUT_FILE_TYPE = "UTF-8";
  private static final Logger LOGGER = Logger.getLogger(FileAdministrator.class.getName());

  private final CommandService commandService = CommandService.getInstance();
  private final InputParser inputParser = InputParser.getInstance();

  private FileAdministrator(){}

  public void readInput(String fileName) throws ParkingLotException {
    if(null == fileName || fileName.isBlank() || fileName.isEmpty()) {
      fileName =  DEFAULT_INPUT_FILE;
    }
    // LOGGER.info(fileName);
    try(InputStream stream = FileAdministrator.class.getClassLoader().getResourceAsStream(fileName);
        BufferedReader br = new BufferedReader(new InputStreamReader(stream));){
      String line;
      while((line = br.readLine()) != null) {
        String[] values = line.split("\\s+");
        Action action = inputParser.parseInput(values);
        if (Action.EXIT.equals(action)){
          return;
        }else if( Action.NONE.equals(action)) {
          throw new ParkingLotException("Invalid action requested.");
        }else {
          commandService.executeCommand(action, values);
        }
      }
    } catch (IOException e){
      LOGGER.severe("Unable to read input file.");
      throw new ParkingLotException("Unable to read input file. " + e.getMessage(), e);
    }
  }

  public static void appendOutput(String data) throws ParkingLotException {
    if (data == null || data.isEmpty() || data.isBlank()) return;
    try(BufferedWriter bw =
          new BufferedWriter(new OutputStreamWriter(new FileOutputStream(DEFAULT_OUTPUT_FILE, true), DEFAULT_OUTPUT_FILE_TYPE))){
      bw.write(data);
      bw.newLine();
    }catch (IOException e){
      LOGGER.severe("Unable to write data to output file.");
      throw new ParkingLotException("Unable to write data to output file. " + e.getMessage(), e);
    }
  }

  public static FileAdministrator getInstance(){
    if(FileAdministrator.instance == null){
      return FileAdministrator.instance = new FileAdministrator();
    }
    return FileAdministrator.instance;
  }

}
