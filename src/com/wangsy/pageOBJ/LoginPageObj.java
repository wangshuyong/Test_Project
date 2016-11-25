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

	
//	@FindBy(id = "phone")
	public WebElement usernameBox = getElement("loginUsernameInputBox");
//	@FindBy(id = "password")
	public WebElement passwordBox = getElement("loginPasswordInputBox");
	// 提交按钮 
//	@FindBy(id = "login")
	public WebElement submitButton = getElement("loginButton");

//	@FindBy(id = "errorMsgId")
//	private WebElement ErroMSG;
//
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
//
//	public WebElement getErroMSG() {
//		return ErroMSG;
//	}
//
//	public void setErroMSG(WebElement erroMSG) {
//		ErroMSG = erroMSG;
//	}

}
