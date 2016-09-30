//all equal find save delete
import org.junit.*;
import static org.junit.Assert.*;
import org.sql2o.*;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;


public class AnimalTest{

  @Rule
  public DatabaseRule database = new DatabaseRule();

  @Test
  public void animal_instaniatesCorrectly_true(){
    Animal testAnimal = new Animal("Red Panda");
    assertTrue(testAnimal instanceof Animal);
  }

  @Test
  public void save_SavesTheAnimal(){
    Animal firstAnimal = new Animal("Red Panda");
    firstAnimal.save();
    Animal secondAnimal = new Animal("Panda Bear");
    secondAnimal.save();
    assertTrue(Animal.all().get(1).equals(secondAnimal));
  }


}
