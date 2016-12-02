package com.wangsy.doTest;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.wangsy.Utils.ExplorerDriverManager;
import com.wangsy.Utils.LogInOut;
import com.wangsy.testServise.HomeService;

public class UserDeleteTest {
	LogInOut baseTest = new LogInOut();
	private HomeService homeService;
  @Test
  public void testUserDelete() {
	  System.out.println("Test user delete !!!");
  }
  
  @BeforeTest(alwaysRun = true)
	public void beforeLogin() {
		baseTest.login("13000000001", "123456");
		homeService = new HomeService(ExplorerDriverManager.getDriver());
	}

	@AfterTest(alwaysRun = true)
	public void quit() {
		baseTest.quit();
	}
}
