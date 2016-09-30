import org.sql2o.*;
import java.util.List;

public class EndangeredAnimal extends Animal implements DatabaseManagement{
  private String health;
  private String age;

  public static final String GOOD_HEALTH_LEVEL ="Healthy";
  public static final String AVERAGE_HEALTH_LEVEL ="Okay";
  public static final String POOR_HEALTH_LEVEL ="Ill";
  public static final String NEW_ANIMAL ="New born";
  public static final String YOUNG_ANIMAL ="Young";
  public static final String OLDER_ANIMAL ="Adult";
  public static final String DATABASE_TYPE_ENDANGERED = "Endangered";

  public EndangeredAnimal(String name, String health, String age){
    super(name);
    this.health = health;
    this.age = age;
    type = DATABASE_TYPE_ENDANGERED;
  }



  public String getHealth(){
    return this.health;
  }

  public String getAge(){
    return this.age;
  }

  @Override
  public void save(){
    try(Connection con = DB.sql2o.open()){
      String sql = "INSERT INTO animals (name,health,age,type) VALUES (:name,:health,:age,:type)";
      this.id = (int) con.createQuery(sql,true).addParameter("name",this.name).addParameter("health",this.health).addParameter("age",this.age).addParameter("type",this.type).executeUpdate().getKey();
    }
  }

  public static List<EndangeredAnimal> allEndangeredAnimals(){
    try(Connection con = DB.sql2o.open()){
      String sql = "SELECT * FROM animals WHERE type = 'Endangered'";
      return con.createQuery(sql).throwOnMappingFailure(false).executeAndFetch(EndangeredAnimal.class);
    }
  }

  public static EndangeredAnimal findEndangeredAnimal(int id){
    try(Connection con = DB.sql2o.open()){
      String sql = "SELECT * FROM animals WHERE id = :id";
      return con.createQuery(sql).addParameter("id",id).throwOnMappingFailure(false).executeAndFetchFirst(EndangeredAnimal.class);
    }
  }

}
