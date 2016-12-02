package com.wangsy.testServise;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebDriver;

import com.wangsy.Utils.*;
import com.wangsy.pageOBJ.LoginPageObj;

public class LoginService {
	private WebDriver driver;
	private LoginPageObj lpo;
	private WebdriverLib eb;
	private  Log logger = LogFactory.getLog(this .getClass());

	public LoginService() {
	}

	public LoginService(WebDriver driver) {
		this.driver = driver;
		try {
			lpo = new LoginPageObj(driver);
			eb = new WebdriverLib(driver);
		} catch (Exception e) {
			e.printStackTrace();
//			logger.info(e.printStackTrace());
		}
		
	}

	public HomeService loginAsSuccess(String username, String password) {
		eb.clearAndTypeString(lpo.usernameBox, username);
		eb.clearAndTypeString(lpo.passwordBox, password);
		eb.clickByElement(lpo.submitButton);
		return new HomeService();
	}

	public LoginService loginAsFail(String username, String password) {
		eb.clearAndTypeString(lpo.getUsernameBox(), username);
		eb.clearAndTypeString(lpo.getPasswordBox(), password);
		eb.clickByElement(lpo.getSubmitButton());
		return this;
	}

	/*public String getElementPresent() {
		try {
			return lpo.getElement(lpo.getLoginUsernameInputBox()).getText();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// return hpo.
	}*/

}
