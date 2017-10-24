package com.webdriver.concrete.chrome;

import com.webdriver.concrete.ProxyWrapper;
import com.webdriver.contracts.WebDriverWrapper;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ChromeWebDriver extends WebDriverWrapper {

    private static final Logger logger = LoggerFactory.getLogger(WebDriverWrapper.class);

    public ChromeWebDriver() {
        ChromeDriverCapabilities chromeDriverCapabilities = new ChromeDriverCapabilities();
        chromeDriverCapabilities.defaultCapabilities();

        super.proxyWrapper = new ProxyWrapper();
        proxyWrapper.startProxy();
        chromeDriverCapabilities.setProxy(proxyWrapper.getSeleniumProxy());
        super.wd = new ChromeDriver(chromeDriverCapabilities.getCapabilities());
        super.setDefaultSize();
    }

    public ChromeWebDriver(DesiredCapabilities desiredCapabilities) {
        super.wd = new ChromeDriver(desiredCapabilities);
    }

}
