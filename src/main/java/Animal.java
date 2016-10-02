import org.sql2o.*;
import java.util.ArrayList;
import java.util.List;

public class Animal implements DatabaseManagement{
  protected int id;
  protected String name;
  protected String type;

  public static final String DATABASE_TYPE_SAFE = "Least Concern";


  public Animal(String name){
    this.name = name;
    this.type = DATABASE_TYPE_SAFE;
  }

  public String getName(){
    return name;
  }

  public int getId(){
    return id;
  }

  public String getType(){
    return type;
  }

  public List<Sighting> getSightings(){
    try(Connection con = DB.sql2o.open()){
      String sql = "SELECT * FROM sightings WHERE animalid=:id ORDER BY timespotted DESC";
      return con.createQuery(sql).addParameter("id",this.id).executeAndFetch(Sighting.class);
    }
  }


  @Override
  public void save(){
    try(Connection con = DB.sql2o.open()){
      String sql = "INSERT INTO animals (name,type) VALUES (:name,:type)";
      this.id = (int) con.createQuery(sql,true).addParameter("name",this.name).addParameter("type",type).executeUpdate().getKey();
    }
  }

  @Override
  public void delete(){
    try(Connection con = DB.sql2o.open()){
      String sql = "DELETE FROM animals WHERE id =:id";
      String sqlSightings = "DELETE FROM sightings WHERE animalid =:animalid";
      con.createQuery(sqlSightings).addParameter("animalid",this.id).executeUpdate();
      con.createQuery(sql).addParameter("id",this.id).executeUpdate();
    }
  }

  public static Animal find(int id){
    try(Connection con = DB.sql2o.open()){
      String sql = "SELECT * FROM animals WHERE id=:id";
      return con.createQuery(sql).addParameter("id",id).executeAndFetchFirst(Animal.class);
    }
  }

  public static List<Animal> all(){
    try(Connection con = DB.sql2o.open()){
      String sql = "SELECT * FROM animals WHERE type='Least Concern'";
     return con.createQuery(sql).throwOnMappingFailure(false).executeAndFetch(Animal.class);
    }
  }

  @Override
  public boolean equals(Object otherAnimal){
    if(!(otherAnimal instanceof Animal)){
      return false;
    }else{
      Animal newAnimal = (Animal) otherAnimal;
      return this.getName().equals(newAnimal.getName());
    }
  }

}
