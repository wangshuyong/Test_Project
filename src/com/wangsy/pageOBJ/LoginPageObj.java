package com.wangsy.pageOBJ;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import com.wangsy.Utils.Locator;
import com.wangsy.Utils.WebdriverLib;

/**
 * auth:rwangsy
 */
public class LoginPageObj extends BasePage{
	
	public LoginPageObj(WebDriver driver) {
		super(driver);
	}
	
	public WebElement usernameBox = getElement("loginUsername");
	public WebElement passwordBox = getElement("loginPassword");
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
