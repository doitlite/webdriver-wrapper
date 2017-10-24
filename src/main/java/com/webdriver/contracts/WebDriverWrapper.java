package com.webdriver.contracts;

import com.webdriver.concrete.ProxyWrapper;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class WebDriverWrapper {

    private static final Logger logger = LoggerFactory.getLogger(WebDriverWrapper.class);

    protected WebDriver wd;
    protected DesiredCapabilities desiredCapabilities;
    protected ProxyWrapper proxyWrapper;

    public WebDriver getDriver() {
        return wd;
    }

    public void setDefaultSize() {
        int width = 1280;
        int height = 1024;
        setSize(width, height);
    }

    public void setSize(int width, int height) {
        logger.info("Set window size to " + width + " x " + height);
        wd.manage().window().setSize(new Dimension(width, height));
    }

    public void closeDriver(){
        proxyWrapper.stopProxy();
        wd.quit();
    }
}
