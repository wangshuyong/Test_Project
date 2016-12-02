package com.wangsy.Utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.TestListenerAdapter;

import bsh.This;

public class ScreenShotListener extends TestListenerAdapter {
	private Log logger = LogFactory.getLog(this.getClass());
	// private Logger logger =Logger.getLogger(this .getClass());
	public static final String CONFIG = "config.properties";

	@Override
	public void onTestFailure(ITestResult tr) {
		super.onTestFailure(tr);
		logger.info(tr.getName() + " 失败");
		ScreentShot screen = new ScreentShot();
		screen.setDriver(ExplorerDriverManager.getDriver());
		screen.takeScreenShot();
	}

	@Override
	public void onTestSkipped(ITestResult tr) {
		super.onTestSkipped(tr);
		ScreentShot screen = new ScreentShot();
		screen.setDriver(ExplorerDriverManager.getDriver());
		screen.takeScreenShot();
	}

	@Override
	public void onTestSuccess(ITestResult tr) {
		super.onTestSuccess(tr);
		logger.info(tr.getName() + " Success");
	}

	@Override
	public void onTestStart(ITestResult tr) {
		super.onTestStart(tr);
		logger.info(tr.getName() + " Start");
	}

	@Override
	public void onFinish(ITestContext testContext) {
		super.onFinish(testContext);
		logger.info(testContext.getName() + " Finish");
	}

}
