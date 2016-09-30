import org.sql2o.*;

public class Sighting{
  private int id;
  private int animalId;
  private String rangerName;
  private String location; //maybe constance or an array or something add

  public Sighting(String rangerName, String location){
    this.rangerName = rangerName;
    this.location = location;
  }

  //all equal find save delete
}
