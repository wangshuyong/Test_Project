package com.wangsy.Utils;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.wangsy.pageOBJ.HomePageObj;
import com.wangsy.pageOBJ.LoginPageObj;
import com.wangsy.testServise.HomeService;
import com.wangsy.testServise.LoginService;

public class DriverManager {

	private DriverManager() {
	};

	public static ThreadLocal<WebDriver> ThreadDriver = new ThreadLocal<WebDriver>();
	static WebDriver driver = ThreadDriver.get();

	public static WebDriver getDriver() {
		if (driver == null) {
			driver = new FirefoxDriver();
			DriverManager.getDriver().manage().timeouts()
					.implicitlyWait(3, TimeUnit.SECONDS);
			driver.get(ConfigurationSettings.getProperty("baseUrl"));
		}
		return driver;
	}

	public static void quit() {
		DriverManager.getDriver().manage().timeouts()
				.implicitlyWait(3, TimeUnit.SECONDS);
		driver.quit();
	}

	public static void openBrowser(String url) {
		driver.get(url);
	}
}