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

	@Test
	public void testUserAdd() throws Exception {
		System.out.println("Test user add!!!");
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
