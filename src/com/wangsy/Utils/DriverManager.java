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

	/**
	 * 濡傛灉褰撳墠杩涚▼娌℃湁缁戝畾driver锛屽垱寤轰竴涓劧鍚庣粦瀹氫笂锛屽鏋滃凡缁忔湁浜嗗氨鐩存帴杩斿�? create a driver
	 * for this thread if not exist. or return it
	 */
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

	/**
	 * 鎵撳紑�?�瑰簲url鐨勯〉闈�?
	 * 
	 * @param url
	 */
	public static void openBrowser(String url) {
		driver.get(url);
	}
}
