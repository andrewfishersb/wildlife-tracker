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

  public Sighting(String rangerName, String location){
    this.rangerName = rangerName;
    this.location = location;
    this.timeSpotted = new Timestamp(new Date().getTime());
  }

  public String getTimeSpotted(){
    return DateFormat.getDateTimeInstance().format(timeSpotted);
  }
  //all equal find save delete

  public static List<Sighting> all(){
    try(Connection con = DB.sql2o.open()){
      String sql="";
    }
  }

  public static Sighting find(int id){
    try(Connection con = DB.sql2o.open()){
      String sql="";
    }
  }

  @Override
  public void save(){
    try(Connection con = DB.sql2o.open()){
      String sql="";
    }
  }

  @Override
  public void delete(){
    try(Connection con = DB.sql2o.open()){
      String sql="";
    }
  }

  @Override
  public boolean equals(Object otherSighting){
    if(!(otherSighting instanceof)){
      return false;
    }else{
      Sighting newSighting = (Sighting) otherSighting;
    }
  }


}
