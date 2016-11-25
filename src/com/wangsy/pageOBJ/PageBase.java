package com.wangsy.pageOBJ;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class PageBase {
	private final int TIMEOUT = 10;

	public PageBase() {
	}

	public PageBase(WebDriver driver) {
		PageFactory.initElements(
				new AjaxElementLocatorFactory(driver, TIMEOUT), this);
	}

}