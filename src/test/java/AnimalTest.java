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

  @Test
  public void equals_ChecksIfTwoAnimalsAreEqual_true(){
    Animal firstAnimal = new Animal("Red Panda");
    firstAnimal.save();
    Animal secondAnimal = new Animal("Red Panda");
    secondAnimal.save();
    assertTrue(firstAnimal.equals(secondAnimal));
  }

  @Test
  public void all_ReturnsAListOfAllAnimals_2(){
    Animal firstAnimal = new Animal("Red Panda");
    firstAnimal.save();
    Animal secondAnimal = new Animal("Panda Bear");
    secondAnimal.save();
    assertEquals(2,Animal.all().size());
  }

  @Test
  public void find_FindsAnAnimalById_true(){
    Animal testAnimal = new Animal("Red Panda");
    testAnimal.save();
    assertTrue(Animal.find(testAnimal.getId()).equals(testAnimal));
  }

  @Test
  public void delete_DeletesAnimal_true(){
    Animal testAnimal = new Animal("Red Panda");
    testAnimal.save();
    testAnimal.delete();
    assertEquals(0,Animal.all().size());
  }

}
