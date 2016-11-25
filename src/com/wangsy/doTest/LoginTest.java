package com.wangsy.doTest;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.wangsy.Utils.Assertion;
import com.wangsy.Utils.ConfigurationSettings;
import com.wangsy.Utils.ExplorerDriverManager;
import com.wangsy.Utils.ExcelUtils;
import com.wangsy.testServise.HomeService;
import com.wangsy.testServise.LoginService;
import com.wangsy.testServise.LogoutService;

public class LoginTest {
	private LoginService loginService;
	private LogoutService logOutService;
	private HomeService homeService;

	@DataProvider(name = "userLogin")
	public Object[][] rangeData() {
		return new ExcelUtils().getDataForTestNG(
				ConfigurationSettings.getProperty("logincasefile"),
				ConfigurationSettings.getProperty("test_login_data"));
	}
  
	@Test(dataProvider = "userLogin")
	public void testLogin(String userName, String passWord, String flag,   
			String expected) throws Exception {
		if ("f".equals(flag)) {
			loginService.loginAsFail(userName, passWord);
//			Assert.assertEquals(expected, loginService.getElementPresent());
//			Assertion.verifyEquals(expected, loginService.getElementPresent());
		} else if ("t".equals(flag)) {
			loginService.loginAsSuccess(userName, passWord);
//			Assert.assertEquals(expected, homeService.getElementPresent());
			Assertion.verifyEquals(expected, homeService.getElementPresent());
			logOutService.logOut();
		}
	}

	@BeforeTest(alwaysRun = true)  
	public void beforeLogin() {
		loginService = new LoginService(ExplorerDriverManager.getDriver());
		logOutService = new LogoutService(ExplorerDriverManager.getDriver());
		homeService = new HomeService(ExplorerDriverManager.getDriver());
	}

	@AfterTest(alwaysRun = true)
	public void quit() {
		ExplorerDriverManager.getDriver().quit();
	}

}
