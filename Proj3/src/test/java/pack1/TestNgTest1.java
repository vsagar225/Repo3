package pack1;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class TestNgTest1 {
  @Test
  public void f() {
	  System.out.println("New Test");
  }
  @BeforeTest
  public void beforeTest() {
  }

  @AfterTest
  public void afterTest() {
	 // Changes for afterTest
  }

}
