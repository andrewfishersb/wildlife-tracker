import org.sql2o.*;

public class Animal{
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


}
