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

public class ToolsUtil {

	public ToolsUtil() {
		super();
	}

	private WebDriver driver;

	// private WebElement element;
	public ToolsUtil(WebDriver driver) {
		this.driver = driver;
	}

	public WebDriver getDriver() {
		return driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}

	private boolean acceptNextAlert = true;

	public boolean isElementExist(By by) {
		try {
			driver.findElement(by);
			return true;

		} catch (NoSuchElementException e) {
			// TODO: handle exception
			return false;
		}

	}

	public WebElement findByID(String id) {
		WebElement element = null;
		if (this.isElementExist(By.id(id))) {
			element = driver.findElement(By.id(id));
		}
		return element;
	}

	public WebElement findByName(String name) {
		WebElement element = null;
		if (this.isElementExist(By.name(name))) {
			element = driver.findElement(By.name(name));
		}
		return element;
	}

	public WebElement findByClass(String ClassName) {
		WebElement element = null;
		if (this.isElementExist(By.name(ClassName))) {
			element = driver.findElement(By.name(ClassName));
		}
		return element;
	}

	public WebElement findByLinkText(String LinkText) {
		WebElement element = null;
		if (this.isElementExist(By.name(LinkText))) {
			element = driver.findElement(By.name(LinkText));
		}
		return element;
	}

	/**
	 * 鏍规嵁鍏冪礌index鑾峰彇鍏蜂綋鍏冪礌浣嶇疆
	 * 
	 * @param by
	 * @param index
	 * @return element
	 */
	public WebElement FindByElements(By by, int index) {
		WebElement element = null;
		if (this.isElementExist(by)) {
			element = driver.findElements(by).get(index);
		}
		return element;
	}

	public boolean elementsExists(By by) {
		return (driver.findElements(by).size()) > 0 ? true : false;
	}

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
		driver.switchTo().frame(driver.findElement(By.className("e")));
	}

	public WebElement findSelectById(String Text) {
		WebElement element = null;
		List<WebElement> options = driver.findElements(By.name(Text));
		for (int i = 0; i < options.size(); i++) {
			if (options.get(i).getText().equals(Text)) {
				options.get(i).click();
			}
		}
		return element;
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
