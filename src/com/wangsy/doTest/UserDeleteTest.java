package com.wangsy.doTest;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.wangsy.Utils.LogInOut;

public class UserDeleteTest {
	LogInOut baseTest = new LogInOut();
  @Test
  public void testUserDelete() {
	  System.out.println("Test user delete !!!");
  }
  
  @BeforeTest(alwaysRun = true)
	public void beforeLogin() {
		baseTest.login("13000000001", "123456");
	}

	@AfterTest(alwaysRun = true)
	public void quit() {
		baseTest.quit();
	}
}
