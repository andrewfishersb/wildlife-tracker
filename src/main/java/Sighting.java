import org.sql2o.*;
import java.sql.Timestamp;
import java.util.Date;
import java.text.DateFormat;
import java.util.List;

public class Sighting implements DatabaseManagement{
  private int id;
  private int animalId;
  private String rangerName;
  private String location; //maybe constance or an array or something add
  private Timestamp timeSpotted;

  public Sighting(String rangerName, String location, int animalId){
    this.rangerName = rangerName;
    this.location = location;
    this.animalId = animalId;
    this.timeSpotted = new Timestamp(new Date().getTime());
  }



  public String getTimeSpotted(){
    return DateFormat.getDateTimeInstance().format(timeSpotted);
  }
  //all equal find save delete
//shoudlnt have to throw a map failure here


  public static Sighting find(int id){
    try(Connection con = DB.sql2o.open()){
      String sql="SELECT * FROM sightings WHERE id = :id";
      return con.createQuery(sql).addParameter("id",id).executeAndFetchFirst(Sighting.class);
    }
  }



  @Override
  public void save(){
    try(Connection con = DB.sql2o.open()){
      String sql ="INSERT INTO sightings (rangername,location,timespotted,animalid) VALUES (:rangername,:location,:timespotted,:animalid)";
      this.id = (int) con.createQuery(sql,true).addParameter("rangername",this.rangerName).addParameter("location",this.location).addParameter("timespotted",this.timeSpotted).addParameter("animalid",this.animalId).executeUpdate().getKey();
    }
  }


  public static List<Sighting> all(){
    try(Connection con = DB.sql2o.open()){
      String sql = "SELECT * FROM sightings";
     return con.createQuery(sql).executeAndFetch(Sighting.class);
    }
  }

  @Override
  public void delete(){
    try(Connection con = DB.sql2o.open()){
      String sql="DELETE FROM sightings WHERE id= :id";
      con.createQuery(sql).addParameter("id",this.id).executeUpdate();
    }
  }

  public int getId(){
    return id;
  }

  public int getAnimalId(){
    return animalId;
  }

  public String getRangerName(){
    return rangerName;
  }

  public String getLocation(){
    return location;
  }

  @Override
  public boolean equals(Object otherSighting){
    if(!(otherSighting instanceof Sighting)){
      return false;
    }else{
      Sighting newSighting = (Sighting) otherSighting;
      return this.getRangerName().equals(newSighting.getRangerName()) && this.getTimeSpotted().equals(newSighting.getTimeSpotted()) && this.getLocation().equals(newSighting.getLocation()) && this.getAnimalId() == newSighting.getAnimalId();
    }
  }


}
