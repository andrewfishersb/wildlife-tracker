import org.sql2o.*;

public class EndangeredAnimal extends Animal implements DatabaseManagement{
  private int id;
  private String name;


  public static final GOOD_HEALTH_LEVEL ="Healthy";
  public static final AVERAGE_HEALTH_LEVEL ="Okay";
  public static final Poor_HEALTH_LEVEL ="Ill";
  public static final NEW_ANIMAL ="New born";
  public static final YOUNG_ANIMAL ="Young";
  public static final OLDER_ANIMAL ="Adult";

  public EndangeredAnimal(String name, int sightingId){
    this.name = name;
    this.sightingId = sightingId;
  }

  public String getName(){
    return name;
  }

  public int getId(){
    return id;
  }

//all  find  
}
