package com.webdriver.contracts;

import com.webdriver.concrete.WebDriverType;
import com.webdriver.concrete.chrome.ChromeWebDriver;
import com.webdriver.concrete.firefox.FirefoxWebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public abstract class WebDriverFactory {

    /**
     * Returns driver of certain type with user defined capabilities
     * @param driverType
     * @param desiredCapabilities
     * @return
     */
    public static WebDriverWrapper getDriver(WebDriverType driverType, DesiredCapabilities desiredCapabilities){

        WebDriverWrapper wrapper = null;

        switch (driverType){
            case CHROME:
                wrapper = new ChromeWebDriver(desiredCapabilities);
                break;
            case FIREFOX:
                wrapper = new FirefoxWebDriver(desiredCapabilities);
                break;
        }

        return wrapper;
    }

    /**
     * Returns driver of certain type with user defined capabilities
     * @param driverType
     * @return
     */
    public static WebDriverWrapper getDriver(WebDriverType driverType){

        WebDriverWrapper wrapper = null;

        switch (driverType){
            case CHROME:
                wrapper = new ChromeWebDriver();
                break;
            case FIREFOX:
                wrapper = new FirefoxWebDriver();
                break;
        }

        return wrapper;
    }
}
