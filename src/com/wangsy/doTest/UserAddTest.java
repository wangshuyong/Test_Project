package com.wangsy.doTest;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.wangsy.Utils.LogInOut;
import com.wangsy.Utils.ConfigurationSettings;
import com.wangsy.Utils.ExplorerDriverManager;
import com.wangsy.Utils.ExcelUtils;
import com.wangsy.testServise.HomeService;
import com.wangsy.testServise.LoginService;
import com.wangsy.testServise.LogoutService;

public class UserAddTest {

	LogInOut baseTest = new LogInOut();
	private HomeService homeService;
	@Test
	public void testUserAdd() throws Exception {
		System.out.println("Test user add!!!");
		System.out.println(homeService.getElementPresent());
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
