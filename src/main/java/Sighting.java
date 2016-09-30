import org.sql2o.*;
import java.sql.Timestamp;
import java.util.Date;
import java.text.DateFormat;

public class Sighting{
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

  public static List<Sighting> all(){
    try(Connection con = DB.sql2o.open()){
      String sql="SELECT * FROM sightings";
      return con.createQuery(sql).executeAndFetch(Sighting.class);
    }
  }

  public static Sighting find(int id){
    try(Connection con = DB.sql2o.open()){
      String sql="SELECT * FROM sightings WHERE id = :id";
      return con.createQuery(sql).addParameter("id",id).executeAndFetchFirst(Sighting.class);
    }
  }

  @Override
  public void save(){
    try(Connection con = DB.sql2o.open()){
      String sql="INSERT INTO sightings (rangername,location,animal_id) VALUES (:rangername, :location, :animal_id)";
      this.id = (int) con.createQuery(sql,true).addParameter("rangername",this.rangerName).addParameter("location",this.location).addParameter("animal_id",this.animalId).executeUpdate().getKey();
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
    if(!(otherSighting instanceof)){
      return false;
    }else{
      Sighting newSighting = (Sighting) otherSighting;
      return this.getRangerName().equals(newSighting.getRangerName()) && this.getTimeSpotted().equals(newSighting.getTimeSpotted()) && this.getLocation().equals(newSighting.getLocation()) && this.getAnimalId() == newSighting.getAnimalId();
    }
  }


}
