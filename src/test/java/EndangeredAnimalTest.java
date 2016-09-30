//all equal find save delete
import org.junit.*;
import static org.junit.Assert.*;
import org.sql2o.*;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class EndangeredAnimalTest{
  @Rule
  public DatabaseRule database = new DatabaseRule();

//edit this
  @Test
  public void endangeredAnimal_instaniatesCorrectly_true(){
    EndangeredAnimal testEndangeredAnimal = new EndangeredAnimal("Rhinoceros");
    assertTrue(testEndangeredAnimal instanceof EndangeredAnimal);
  }

  // @Test
  // public void save_SavesTheEndangeredAnimal(){
  //   EndangeredAnimal firstEndangeredAnimal = new EndangeredAnimal("Red Panda");
  //   firstEndangeredAnimal.save();
  //   EndangeredAnimal secondEndangeredAnimal = new EndangeredAnimal("Panda Bear");
  //   secondEndangeredAnimal.save();
  //   assertTrue(EndangeredAnimal.all().get(1).equals(secondEndangeredAnimal));
  // }
  //
  // @Test
  // public void equals_ChecksIfTwoEndangeredAnimalsAreEqual_true(){
  //   EndangeredAnimal firstEndangeredAnimal = new EndangeredAnimal("Red Panda");
  //   firstEndangeredAnimal.save();
  //   EndangeredAnimal secondEndangeredAnimal = new EndangeredAnimal("Red Panda");
  //   secondEndangeredAnimal.save();
  //   assertTrue(firstEndangeredAnimal.equals(secondEndangeredAnimal));
  // }
  //
  // @Test
  // public void all_ReturnsAListOfAllEndangeredAnimals_2(){
  //   EndangeredAnimal firstEndangeredAnimal = new EndangeredAnimal("Red Panda");
  //   firstEndangeredAnimal.save();
  //   EndangeredAnimal secondEndangeredAnimal = new EndangeredAnimal("Panda Bear");
  //   secondEndangeredAnimal.save();
  //   assertEquals(2,EndangeredAnimal.all().size());
  // }
  //
  // @Test
  // public void find_FindsAnEndangeredAnimalById_true(){
  //   EndangeredAnimal testEndangeredAnimal = new EndangeredAnimal("Red Panda");
  //   testEndangeredAnimal.save();
  //   assertTrue(EndangeredAnimal.find(testEndangeredAnimal.getId()).equals(testEndangeredAnimal));
  // }
  //
  // @Test
  // public void delete_DeletesEndangeredAnimal_true(){
  //   EndangeredAnimal testEndangeredAnimal = new EndangeredAnimal("Red Panda");
  //   testEndangeredAnimal.save();
  //   testEndangeredAnimal.delete();
  //   assertEquals(0,EndangeredAnimal.all().size());
  // }
  //
  // @Test
  // public void getType_RetrievesDangerLevel_Endangered(){
  //   EndangeredAnimal testEndangeredAnimal = new EndangeredAnimal("Tiger");
  //   assertEquals("Endangered",testEndangeredAnimal.getType());
  // }
}
