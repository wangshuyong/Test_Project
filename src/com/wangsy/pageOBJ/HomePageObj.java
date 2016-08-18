package com.wangsy.pageOBJ;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.wangsy.Utils.*;

public class HomePageObj extends PageBase{
	
	public HomePageObj() {
	}
	public HomePageObj(WebDriver driver) {
		super(driver);
	}

	@FindBy(how = How.XPATH, using = "//div[@id='user-nav']/ul/li[4]/a/span")
	private WebElement logout;
	
	public WebElement getLogout() {
		return logout;
	}
	
	public void setLogout(WebElement logout) {
		this.logout = logout;
	}
	
}
