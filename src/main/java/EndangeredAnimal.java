import org.sql2o.*;

public class EndangeredAnimal extends Animal implements DatabaseManagement{


  public static final String GOOD_HEALTH_LEVEL ="Healthy";
  public static final String AVERAGE_HEALTH_LEVEL ="Okay";
  public static final String Poor_HEALTH_LEVEL ="Ill";
  public static final String NEW_ANIMAL ="New born";
  public static final String YOUNG_ANIMAL ="Young";
  public static final String OLDER_ANIMAL ="Adult";

  public EndangeredAnimal(String name){
    super(name);
  }

  public String getName(){
    return name;
  }

  public int getId(){
    return id;
  }

//all  find
}
