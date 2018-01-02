
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import org.junit.Test;
import java.util.*;
import market.*;

public class FruitTest {
  @Test
  public void testTrue() {
    Fruit myFruit = new Fruit();
	myFruit = myFruit.make("alma",500);
	Fruit mySndFruit = new Fruit();
	mySndFruit = mySndFruit.make("banan",300);
	assertTrue(Fruit.getCheapestFruit().getName() == "banan");
  }
  
  @Test
  public void testNullNameAtMake() {
    Fruit myFruit = new Fruit();
	//myFruit = myFruit.make("alma",-1);
	assertTrue(myFruit.getName() == null);
  }
/*
  @Test
  public void manualSuccess() {
    return;
  }

  @Test
  public void manualFail() {
    fail("Always fails");
    assertTrue(1 == 1);
  }

  @Test
  public void testUnexpectedException() {
    throw new RuntimeException("Varatlan hiba tortent");
  }

  @Test(expected = RuntimeException.class)
  public void testExpectedException() {
    throw new RuntimeException("Varakozasnak megfelelo hiba tortent");
  }

  @Test
  public void testExpectedException2() {
    try{
      int x = 3/0;
      fail("Nem tortent kivitel");
    } catch(ArithmeticException e){}
  }


  @Test(timeout=2000)
  public void abortWhenInfiniteLoop(){
    while(true){}
  }*/
}
