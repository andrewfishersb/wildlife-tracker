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
    Sighting secondSighting = new Sighting("Smokey","Smokey Mountains",1);
    secondSighting.save();
    assertTrue(Sighting.all().get(1).equals(secondSighting));
  }

  @Test
  public void all_ReturnsAListOfAllSighting_2(){
    Sighting firtSighting = new Sighting("McFriendly","South Park",1);
    firtSighting.save();
    Sighting secondSighting = new Sighting("Smokey","Smokey Mountains",1);
    secondSighting.save();
    assertEquals(2,Sighting.all().size());
  }
}
