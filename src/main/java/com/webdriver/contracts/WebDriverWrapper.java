package com.webdriver.contracts;

import com.webdriver.concrete.ProxyWrapper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public abstract class WebDriverWrapper {

    protected WebDriver wd;
    protected DesiredCapabilities desiredCapabilities;
    protected ProxyWrapper proxyWrapper;

    public WebDriver getDriver() {
        return wd;
    }

    public void closeDriver(){
        proxyWrapper.stopProxy();
        wd.quit();
    }
}
