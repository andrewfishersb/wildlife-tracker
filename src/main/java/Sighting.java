import org.sql2o.*;
import java.sql.Timestamp;
import java.util.Date;

public class Sighting{
  private int id;
  private int animalId;
  private String rangerName;
  private String location; //maybe constance or an array or something add
  private Timestamp timeSpotted;

  public Sighting(String rangerName, String location){
    this.rangerName = rangerName;
    this.location = location;
    // this.timeSpotted = now();
  }

  public Timestamp getTimeSpotted(){
    return timeSpotted;
  }
  //all equal find save delete
}
