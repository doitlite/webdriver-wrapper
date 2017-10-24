package com.webdriver.concrete.firefox;

import com.webdriver.concrete.ProxyWrapper;
import com.webdriver.contracts.WebDriverWrapper;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class FirefoxWebDriver extends WebDriverWrapper {

    public FirefoxWebDriver() {
        FirefoxDriverCapabilities capabilities = new FirefoxDriverCapabilities();
        capabilities.defaultCapabilities();

        super.proxyWrapper = new ProxyWrapper();
        proxyWrapper.startProxy();
        capabilities.setProxy(proxyWrapper.getSeleniumProxy());
        super.wd = new FirefoxDriver(capabilities.getCapabilities());
    }

    public FirefoxWebDriver(DesiredCapabilities desiredCapabilities) {
        super.desiredCapabilities = desiredCapabilities;
        super.wd = new FirefoxDriver(desiredCapabilities);
    }

}
