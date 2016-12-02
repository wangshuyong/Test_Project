package com.wangsy.Utils;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebdriverLib {

	public WebdriverLib() {
		super();
	}

	private WebDriver driver;

	// private WebElement element;
	public WebdriverLib(WebDriver driver) {
		this.driver = driver;
	}

	private boolean acceptNextAlert = true;

	/**
	 * 绐楀彛鍒囨崲
	 * 
	 * @param windowTitile
	 */
	public void switchTowindow(String windowTitile) {
		Set<String> windowHandles = driver.getWindowHandles();
		for (String handler : windowHandles) {
			driver.switchTo().window(handler);
			String title = driver.getTitle();
			if (windowTitile.equals(title)) {
				break;
			}
		}
	}

	public void switchToFrame(WebElement e) {
		driver.switchTo().frame(e);
	}


	private String closeAlertAndGetItsText() {
		try {
			Alert alert = driver.switchTo().alert();
			String alertText = alert.getText();
			if (acceptNextAlert) {
				alert.accept();
			} else {
				alert.dismiss();
			}
			return alertText;
		} finally {
			acceptNextAlert = true;
		}
	}

	public void clickByElement(WebElement element) {
		element.click();
	}

	public void clearAndTypeString(WebElement element, String text) {
		element.clear();
		element.sendKeys(text);
	}
	
}
