package com.wangsy.pageOBJ;

import java.io.IOException;
import java.util.HashMap;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.wangsy.Utils.ConfigurationSettings;
import com.wangsy.Utils.Locator;
import com.wangsy.Utils.XmlDocument;
import com.wangsy.Utils.XmlUtils;

public class BasePage {

	protected WebDriver driver;
	private HashMap<String, Locator> locatorMap;
	private XmlDocument xmlRead;
    protected BasePage(WebDriver driver) throws Exception {
        this.driver = driver;
        xmlRead = new XmlUtils();
        try {
        	locatorMap = xmlRead.readXMLDocument(ConfigurationSettings.getProperty("path"),
			        this.getClass().getCanonicalName());
		} catch (Exception e) {
			e.printStackTrace();
		}
//        System.out.println("########################################################$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$    "+locatorMap.get("loginUsernameInputBox"));
    }
    public Locator getLocator(String locatorName) throws IOException {
    	Locator locator = locatorMap.get(locatorName);
        if (locator == null) {
            locator = new Locator(locatorName);
        }
        return locator;
    }
    
    public WebElement getElement(String locatorName) throws IOException {
        return getElement(this.getDriver(), locatorName);
    }

    /**
     * get by parameter
     * String
     * @author Young
     * @param driver
     * @param locator
     * @return
     * @throws IOException
     */
    public WebElement getElement(WebDriver driver, String locatorName)
            throws IOException {
    	Locator locator = getLocator(locatorName);
        WebElement e;
        switch (locator.getBy()) {
        case xpath:
            e = driver.findElement(By.xpath(locator.getElement()));
            break;
        case id:
            e = driver.findElement(By.id(locator.getElement()));
            break;
        case name:
            e = driver.findElement(By.name(locator.getElement()));
            break;
        case cssSelector:
            e = driver.findElement(By.cssSelector(locator.getElement()));
            break;
        case className:
            e = driver.findElement(By.className(locator.getElement()));
            break;
        case tagName:
            e = driver.findElement(By.tagName(locator.getElement()));
            break;
        case linkText:
            e = driver.findElement(By.linkText(locator.getElement()));
            break;
        case partialLinkText:
            e = driver.findElement(By.partialLinkText(locator.getElement()));
            break;
        default:
            e = driver.findElement(By.id(locator.getElement()));
        }
        return e;
    }


    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }
    
}
