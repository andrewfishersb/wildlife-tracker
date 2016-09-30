import org.sql2o.*;
import java.util.ArrayList;
import java.util.List;

public class Animal implements DatabaseManagement{
  protected int id;
  protected String name;

  public Animal(String name){
    this.name = name;
  }

  public String getName(){
    return name;
  }

  public int getId(){
    return id;
  }

//all equal find save delete

  @Override
  public boolean equals(Object otherAnimal){
    if(!(otherAnimal instanceof Animal)){
      return false;
    }else{
      Animal newAnimal = (Animal) otherAnimal;
      return this.getName().equals(newAnimal.getName());
    }
  }

  @Override
  public void save(){
    try(Connection con = DB.sql2o.open()){
      String sql = "INSERT INTO animals (name) VALUES (:name)";
      this.id = (int) con.createQuery(sql,true).addParameter("name",this.name).executeUpdate().getKey();
    }
  }

  @Override
  public void delete(){
    try(Connection con = DB.sql2o.open()){
      String sql = "DELETE FROM animals WHERE id =:id";
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
      String sql = "SELECT * FROM animals";
     return con.createQuery(sql).throwOnMappingFailure(false).executeAndFetch(Animal.class);
    }
  }
}
