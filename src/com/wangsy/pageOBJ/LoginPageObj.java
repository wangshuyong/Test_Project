package com.wangsy.pageOBJ;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import com.wangsy.Utils.ToolsUtil;
import com.wangsy.Utils.PageBase;

/**
 * author�������� ��¼ҳ����� ҳ��Ԫ�ض�λ
 */
public class LoginPageObj extends PageBase {

	@FindBy(id = "phone")
	WebElement usernameBox;
	@FindBy(id = "password")
	private WebElement passwordBox;
	// 提交按钮
	@FindBy(id = "login")
	private WebElement submitButton;

	@FindBy(id = "errorMsgId")
	private WebElement ErroMSG;

	public LoginPageObj(WebDriver driver) {
		super(driver);
	}

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

	public WebElement getErroMSG() {
		return ErroMSG;
	}

	public void setErroMSG(WebElement erroMSG) {
		ErroMSG = erroMSG;
	}

}
