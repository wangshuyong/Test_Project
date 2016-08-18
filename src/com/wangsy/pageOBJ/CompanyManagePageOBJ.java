package com.wangsy.pageOBJ;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.wangsy.Utils.PageBase;
/**
 * ������Ҫ��ʼ����������Ա�� ��ӹ�˾��ҳ��Ԫ��
 * @author yangsy
 *
 */
public class CompanyManagePageOBJ extends PageBase{
	//��ҵ����������Ԫ��
	@FindBy(how = How.XPATH, using = "//div[@id='tree-area']/div[3]/span[2]")
	@CacheLookup
	private WebElement companyManageSpan;
	
	//��ӹ�˾��ť 
	@FindBy(how = How.CSS, using = "li")
	@CacheLookup
	private WebElement addButton;
	//�޸İ�ť
	@FindBy(how = How.XPATH, using = "//div[@id='searchDiv']/div[2]/div/ul/li[2]")
	@CacheLookup
	private WebElement modifyCompany;
	
	//��˾����
	@FindBy(how = How.CSS, using = "div.input-group > input[name=\"companyName\"]")
	@CacheLookup
	private WebElement companyName;
	
	//��ϵ�绰
	@FindBy(how = How.CSS, using = "div.input-group > input[name=\"phonenumber\"]")
	@CacheLookup
	private WebElement phone;
	
	//��ϵ��
	@FindBy(how = How.CSS, using = "div.input-group > input[name=\"contactPeople\"]")
	@CacheLookup
	private WebElement contactPeople;
	
	//�����Ĺ���Ա�˺�
	@FindBy(how = How.CSS, using = "div.input-group > input[name=\"contactPeople\"]")
	@CacheLookup
	private WebElement userName;
	
	//�����Ĺ���Ա�˺ŵ�����
	@FindBy(how = How.NAME, using = "userPassword")
	@CacheLookup
	private WebElement userPassword;
		
	//�����Ĺ���Ա�˺�-ȷ������
	@FindBy(how = How.NAME, using = "userPasswordConfirm")
	@CacheLookup
	private WebElement userPasswordConfirm;
	
	//Email
	@FindBy(how = How.CSS, using = "div.input-group > input[name=\"email\"]")
	@CacheLookup
	private WebElement email;
	
	//ȷ�ϰ�ť
	@FindBy(how = How.CSS, using = "#addWnd > div.add-btns > div.button")
	@CacheLookup
	private WebElement okButton;
	
	//ȡ����ť
	@FindBy(how = How.XPATH, using = "//div[@id='addWnd']/div[8]/div[2]")
	@CacheLookup
	private WebElement cancelButton;
	
	//��ҵ����-ϵͳ����Ա��iframe
	@FindBy(how = How.CLASS_NAME, using = "eb_iframe")
	@CacheLookup
	private WebElement iframe;
	
	public WebElement getCompanyManageSpan() {
		return companyManageSpan;
	}



	public void setCompanyManageSpan(WebElement companyManageSpan) {
		this.companyManageSpan = companyManageSpan;
	}



	public WebElement getAddButton() {
		return addButton;
	}



	public void setAddButton(WebElement addButton) {
		this.addButton = addButton;
	}



	public WebElement getModifyCompany() {
		return modifyCompany;
	}



	public void setModifyCompany(WebElement modifyCompany) {
		this.modifyCompany = modifyCompany;
	}



	public WebElement getCompanyName() {
		return companyName;
	}



	public void setCompanyName(WebElement companyName) {
		this.companyName = companyName;
	}



	public WebElement getPhone() {
		return phone;
	}



	public void setPhone(WebElement phone) {
		this.phone = phone;
	}



	public WebElement getContactPeople() {
		return contactPeople;
	}



	public void setContactPeople(WebElement contactPeople) {
		this.contactPeople = contactPeople;
	}



	public WebElement getUserName() {
		return userName;
	}



	public void setUserName(WebElement userName) {
		this.userName = userName;
	}



	public WebElement getUserPassword() {
		return userPassword;
	}



	public void setUserPassword(WebElement userPassword) {
		this.userPassword = userPassword;
	}



	public WebElement getUserPasswordConfirm() {
		return userPasswordConfirm;
	}



	public void setUserPasswordConfirm(WebElement userPasswordConfirm) {
		this.userPasswordConfirm = userPasswordConfirm;
	}



	public WebElement getEmail() {
		return email;
	}



	public void setEmail(WebElement email) {
		this.email = email;
	}



	public WebElement getOkButton() {
		return okButton;
	}



	public void setOkButton(WebElement okButton) {
		this.okButton = okButton;
	}



	public WebElement getCancelButton() {
		return cancelButton;
	}



	public void setCancelButton(WebElement cancelButton) {
		this.cancelButton = cancelButton;
	}



	public WebElement getIframe() {
		return iframe;
	}



	public void setIframe(WebElement iframe) {
		this.iframe = iframe;
	}

}
