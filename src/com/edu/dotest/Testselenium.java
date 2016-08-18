package com.edu.dotest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.wangsy.Utils.ConfigurationSettings;
import com.wangsy.Utils.ExcelUtils;

public class Testselenium {

  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();
  
  @DataProvider(name="userLogin")
  public Object[][] rangeData() {
  	return new ExcelUtils().getDataForTestNG(ConfigurationSettings.getProperty("logincasefile"),ConfigurationSettings.getProperty("test_login_data"));
  }

  @BeforeTest
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "http://localhost:8080/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test(dataProvider="userLogin")
  public void test1(String userName, String passWord,String flag,String expected) throws Exception {
    driver.get(baseUrl + "/CmsAdmin/admin/login.html");
    driver.findElement(By.id("phone")).clear();
    driver.findElement(By.id("phone")).sendKeys("13000000001");
    driver.findElement(By.id("password")).clear();
    driver.findElement(By.id("password")).sendKeys("123456");
    driver.findElement(By.id("login")).click();
    driver.findElement(By.xpath("//div[@id='user-nav']/ul/li[4]/a/span")).click();
  }

  @AfterTest
  public void tearDown() throws Exception {
    driver.quit();
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
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
}
