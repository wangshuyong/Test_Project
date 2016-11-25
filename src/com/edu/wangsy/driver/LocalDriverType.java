package com.edu.wangsy.driver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.wangsy.Utils.ConfigurationSettings;

public enum LocalDriverType {

	InternetExplorer {

		@Override
		public WebDriver getDriver() {

			if (!StringUtils
					.isEmpty(ConfigurationSettings.WEBDRIVER_IE_DRIVER_PATH)) {
				System.setProperty(
						InternetExplorerDriverService.IE_DRIVER_EXE_PROPERTY,
						ConfigurationSettings.WEBDRIVER_IE_DRIVER_PATH);
			}

			DesiredCapabilities ieCapabilities = DesiredCapabilities
					.internetExplorer();
			ieCapabilities
					.setCapability(
							InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,
							true);
			return new InternetExplorerDriver(ieCapabilities);
		}
	},
	Firefox {
		@Override
		public WebDriver getDriver() {
			System.setProperty("webdriver.gecko.driver",ConfigurationSettings.WEBDRIVER_FIREFOX_DRIVER_PATH);
			WebDriver driver = new FirefoxDriver();
			return driver;
		}
	},
	Chrome {
		@Override
		public WebDriver getDriver() {
			if (!StringUtils
					.isEmpty(ConfigurationSettings.WEBDRIVER_CHROME_DRIVER_PATH)) {
				System.setProperty("webdriver.chrome.driver", ConfigurationSettings.WEBDRIVER_CHROME_DRIVER_PATH); 
				//设置Webdriver启动chrome为默认用户的配置信息（包括书签、扩展程序等）
				ChromeOptions options = new ChromeOptions();
				options.addArguments("user-data-dir=C:/Users/yangsy/AppData/Local/Google/Chrome/User Data/Default");
			}
			return new ChromeDriver();
		}
	};
	public abstract WebDriver getDriver();
}
