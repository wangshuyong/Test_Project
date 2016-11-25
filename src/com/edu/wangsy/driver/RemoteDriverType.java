package com.edu.wangsy.driver;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.*;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.wangsy.Utils.ConfigurationSettings;

public enum RemoteDriverType {

	InternetExplorer {

		@Override
		public WebDriver getDriver() {
			WebDriver driver = null;
			DesiredCapabilities ieCapabilities = DesiredCapabilities.internetExplorer();
			ieCapabilities
					.setCapability(
							InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,
							true);
			ieCapabilities.setBrowserName(ConfigurationSettings.WEBDRIVER_TYPE ); 
			ieCapabilities.setVersion("11.0");
			ieCapabilities.setPlatform(Platform.ANY);
			ieCapabilities.setCapability("ignoreProtectedModeSettings", true);
			try {
				driver = new RemoteWebDriver(new URL(ConfigurationSettings.getProperty("HUB_URL")), ieCapabilities);
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
			return driver;
		}
	},
	Firefox {
		@Override
		public WebDriver getDriver() {
			WebDriver driver = null;
			DesiredCapabilities ffDesiredcap = DesiredCapabilities.firefox();
			System.setProperty("webdriver.gecko.driver",ConfigurationSettings.WEBDRIVER_FIREFOX_DRIVER_PATH);
			ffDesiredcap.setBrowserName("firefox");
			try {
				driver = new RemoteWebDriver(new URL(ConfigurationSettings.getProperty("HUB_URL")), ffDesiredcap);
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
			driver.manage().window().maximize();
			
			return driver;
		}
	},
	Chrome {
		@Override
		public WebDriver getDriver() {
			WebDriver driver = null;
			DesiredCapabilities chromeDesiredcap = DesiredCapabilities.chrome();
			chromeDesiredcap.setBrowserName("chrome");
			try {
				driver = new RemoteWebDriver(new URL(ConfigurationSettings.getProperty("HUB_URL")), chromeDesiredcap);
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
			return driver;
		}
	};
	public abstract WebDriver getDriver();
}
