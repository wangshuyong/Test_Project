package com.edu.wangsy.driver;


import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.wangsy.Utils.ConfigurationSettings;



public class DriverFactory {
    private static RemoteDriverType DEFAULT_DRIVER_TYPE = RemoteDriverType.Firefox;


    private static DriverFactory instance = null;

    static {
        instance = new DriverFactory();
    }

    public static DriverFactory getInstance() {
        return instance;
    }

    public WebDriver getDriver() {
        RemoteDriverType type = DEFAULT_DRIVER_TYPE;
        try {
            type = Enum.valueOf(RemoteDriverType.class, ConfigurationSettings.WEBDRIVER_TYPE);
        }
        catch (Exception ex) {
        }
        return type.getDriver();
    }
}