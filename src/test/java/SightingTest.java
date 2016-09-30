//all equal find save delete
import org.junit.*;
import static org.junit.Assert.*;
import org.sql2o.*;
import java.util.List;
import java.sql.Timestamp;
import java.util.Date;
import java.text.DateFormat;

public class SightingTest{

  @Rule
  public DatabaseRule database = new DatabaseRule();


  @Test
  public void sighting_InsantiatesCorrectly(){
    Sighting testSighting = new Sighting("McFriendly","South Park",1);
    assertTrue(testSighting instanceof Sighting);
  }

  @Test
  public void timeSpotted_ChecksTimeStampOfSighting(){
    Sighting testSighting = new Sighting("McFriendly","South Park",1);
    Timestamp now = new Timestamp(new Date().getTime());
    String stringTime = DateFormat.getDateTimeInstance().format(now);
    assertEquals(stringTime,testSighting.getTimeSpotted());
  }

  @Test
  public void save_SavesTheSighting(){
    Sighting firtSighting = new Sighting("McFriendly","South Park",1);
    firtSighting.save();
    assertTrue(Sighting.all().get(0).equals(firtSighting));
  }

  @Test
  public void all_ReturnsAListOfAllSighting_2(){
    Sighting firtSighting = new Sighting("McFriendly","South Park",1);
    firtSighting.save();
    Sighting secondSighting = new Sighting("Smokey","Smokey Mountains",1);
    secondSighting.save();
    assertEquals(2,Sighting.all().size());
  }

  @Test
  public void equals_ChecksIfTwoSighingsAreIdentical(){
    Sighting firtSighting = new Sighting("McFriendly","South Park",1);
    firtSighting.save();
    Sighting secondSighting = new Sighting("McFriendly","South Park",1);
    secondSighting.save();
  }

  @Test
  public void find_ChecksIfSightingCanBeFound(){
    Sighting testSighting = new Sighting("McFriendly","South Park",1);
    testSighting.save();
    Sighting savedSighting = Sighting.find(testSighting.getId());
    assertTrue(testSighting.equals(savedSighting));
  }


  @Test
  public void save_SavesAnimalIdIntoDatabase_true(){
    Animal anAnimal = new Animal("Bat");
    anAnimal.save();
    Sighting testSighting = new Sighting("McFriendly","South Park",anAnimal.getId());
    testSighting.save();
    Sighting databaseSighting = Sighting.find(testSighting.getId());
    assertEquals(databaseSighting.getAnimalId(),anAnimal.getId());
  }

  @Test
  public void delete_DeleteSightingFromDB(){
    Sighting testSighting = new Sighting("McFriendly","South Park",1);
    testSighting.save();
    assertEquals(1,Sighting.all().size());
    testSighting.delete();
    assertEquals(0,Sighting.all().size());
  }

  @Test
  public void all_OrdersByMostRecentlySpotted(){
    Sighting firtSighting = new Sighting("McFriendly","South Park",1);
    firtSighting.save();
    Sighting secondSighting = new Sighting("Smokey","Smokey Mountains",1);
    secondSighting.save();
    Sighting thirdSighting = new Sighting("FC","Highlands",1);
    thirdSighting.save();
    assertTrue(Sighting.all().get(0).equals(thirdSighting));
  }
}
