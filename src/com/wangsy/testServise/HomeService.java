package com.wangsy.testServise;

import org.openqa.selenium.WebDriver;

import com.wangsy.Utils.WebdriverLib;
import com.wangsy.pageOBJ.HomePageObj;
import com.wangsy.pageOBJ.LoginPageObj;

//import com.edu.cms.UIObject.HomePageObj;

public class HomeService {

	public CompanyManageService comp = new CompanyManageService();
	WebDriver driver;
	WebdriverLib eb;
	public HomePageObj hpo;

	public HomeService() {

	}

	public HomeService(WebDriver driver) {
		this.driver = driver;
		hpo = new HomePageObj(driver);
		eb = new WebdriverLib(driver);
	}

	public String getElementPresent() {

		return hpo.getLogout().getText();
		// return hpo.
	}

}
