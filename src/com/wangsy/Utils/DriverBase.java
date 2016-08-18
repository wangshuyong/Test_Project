package com.wangsy.Utils;

import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.edu.cms.driver.DriverFactory;
import com.wangsy.pageOBJ.LoginPageObj;



public abstract class DriverBase {
//    protected Logger logger = LoggerFactory.getLogger(getClass());
    protected WebDriver driver;
    public  WebDriver get(String url){
	    driver = new FirefoxDriver();
	    driver.get(url);    
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    return driver;
	   }
	
	public void quit(){
		driver.quit();
	}


    /**
     * 用于硬�?�的等待
     * @param seconds
     */
//    public void sleep(int seconds) {
//        try {
//            TimeUnit.SECONDS.sleep(seconds);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//    }
//
//
//    @Before
//    public void setUpTestBase(ITestContext testContext) {
//        try{
//            driver = DriverFactory.getInstance().getDriver();
//         } catch(Exception e ) {
//             quitDriver();
//             Assert.fail("SetUp failed.", e);
//         }
//    }
//
//
//    @AfterClass
//    public void quitDriver() {
//        try{
//            if(driver != null)
//                driver.quit();
//        }   finally {
//            driver = null;
//        }
//    }
    

}