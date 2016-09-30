import org.sql2o.*;

public class Animal implements DatabaseManagement{
  private int id;
  private String name;

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
  public boolean equal(Object otherAnimal){
    if(!(otherAnimal instanceof Animal)){
      return false;
    }else{
      Animal newAnimal = (Animal) otherAnimal;
      return this.getName().equals(newAnimal.getName()) && this.getId() == newAnimal.getId();
    }
  }

  @Override
  public void save(){
    try(Connection con = DB.sql2o.open()){
      String sql = "INSERT INTO animals (name, id) VALUES (:name,:id)";
      this.id = (int) con.createQuery(sql,true).addParameter("name",this.name).addParameter("id",this.id).executeUpdate().getKey();
    }
  }

  @Override
  public void delete(){
    try(Connection con = DB.sql2o.open()){
      String sql = "DELETE FROM animals WHERE id =:id";
      con.createQuery(sql).addParameter("id",this.id).executeUpdate();
    }
  }

  public Animal find(int id){
    try(Connection con = DB.sql2o.open()){
      String sql = "SELECT * FROM animals WHERE id=:id";
      return con.createQuery(sql).addParameter("id",id).executeAndFetchFirst(Animal.class);
    }
  }

  public List<Animal> all(){
    try(Connection con = DB.sql2o.open()){
      String sql = "SELECT * FROM animals";
     return con.createQuery(sql).executeAndFetch(Animal.class);
    }
  }
}
