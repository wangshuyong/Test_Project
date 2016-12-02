package com.wangsy.Utils;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.edu.wangsy.driver.DriverFactory;
import com.edu.wangsy.driver.LocalDriverType;
import com.edu.wangsy.driver.RemoteDriverType;
import com.wangsy.pageOBJ.HomePageObj;
import com.wangsy.pageOBJ.LoginPageObj;
import com.wangsy.testServise.HomeService;
import com.wangsy.testServise.LoginService;

public class ExplorerDriverManager {
	
	private ExplorerDriverManager() {
	};

	private static ThreadLocal<WebDriver> ThreadDriver = new ThreadLocal<WebDriver>();
	private static  RemoteDriverType DEFAULT_REMOTE_DRIVER_TYPE = RemoteDriverType.Firefox;//init
	private static  LocalDriverType DEFAULT_LOCAL_DRIVER_TYPE = LocalDriverType.Firefox;//init

	public static WebDriver getDriver() {
		WebDriver driver = ThreadDriver.get();
		if (driver == null) {
			//driver type is remote
			if("remote".equals(ConfigurationSettings.getProperty("DRIVERLOCATION"))){
				RemoteDriverType type = DEFAULT_REMOTE_DRIVER_TYPE;
				type = Enum.valueOf(RemoteDriverType.class,ConfigurationSettings.WEBDRIVER_TYPE);
				driver = type.getDriver();
				ThreadDriver.set(driver);
				//driver type is local
			}else if("local".equals(ConfigurationSettings.getProperty("DRIVERLOCATION"))) {
				LocalDriverType localType = DEFAULT_LOCAL_DRIVER_TYPE;
				try {
					localType = Enum.valueOf(LocalDriverType.class,ConfigurationSettings.WEBDRIVER_TYPE);
				} catch (Exception ex) {
				}
				driver = localType.getDriver();
				ThreadDriver.set(driver);
			}
			driver.get(ConfigurationSettings.getProperty("baseUrl"));
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			
		}
		return driver;
	}
	
}