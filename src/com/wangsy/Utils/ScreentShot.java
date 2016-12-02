package com.wangsy.Utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreentShot {
	private WebDriver driver;
	private final static String SCREEN_SHOT_PATH = "test-output/screen-shot";
	// Log log = new Log(this.getClass());

	public WebDriver getDriver() {
		return driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}

	/**
	 * stop webdriver
	 * 
	 * @param driver
	 */
	public void takeScreenShot() {
		SimpleDateFormat sf = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
		Calendar cal = Calendar.getInstance();
		Date date = cal.getTime();
		String dateStr = sf.format(date);
		String screenName = this.getClass().getSimpleName() + "_" + dateStr + ".png";
		File dir = new File(SCREEN_SHOT_PATH);
        if (!dir.exists())
            dir.mkdirs();
        String screenPath = dir.getAbsolutePath() + "/" + screenName;
		takeScreenShot((TakesScreenshot) this.getDriver(), screenPath);
		
	}

	/**
	 * @author Young
	 * @param drivername
	 * @param path
	 */
	public void takeScreenShot(TakesScreenshot drivername, String path) {
		File scrFile = drivername.getScreenshotAs(OutputType.FILE);
		
			try {
				FileUtils.copyFile(scrFile, new File(path));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}
}
