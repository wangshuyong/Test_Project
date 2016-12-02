package com.wangsy.pageOBJ;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import com.wangsy.Utils.Locator;
import com.wangsy.Utils.WebdriverLib;

/**
 * autho:rwangsy
 */
public class LoginPageObj extends BasePage{
	
	public LoginPageObj(WebDriver driver) throws Exception {
		super(driver);
	}
	
	public WebElement usernameBox = getElement("loginUsernameInputBox");
	public WebElement passwordBox = getElement("loginPasswordInputBox");
	public WebElement submitButton = getElement("loginButton");

	public WebElement getUsernameBox() {
		return usernameBox;
	}

	public void setUsernameBox(WebElement usernameBox) {
		this.usernameBox = usernameBox;
	}

	public WebElement getPasswordBox() {
		return passwordBox;
	}

	public void setPasswordBox(WebElement passwordBox) {
		this.passwordBox = passwordBox;
	}

	public WebElement getSubmitButton() {
		return submitButton;
	}

	public void setSubmitButton(WebElement submitButton) {
		this.submitButton = submitButton;
	}

}
