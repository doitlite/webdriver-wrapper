package com.webdriver.concrete.chrome;

import com.webdriver.concrete.ProxyWrapper;
import com.webdriver.contracts.WebDriverWrapper;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class ChromeWebDriver extends WebDriverWrapper {

    public ChromeWebDriver() {
        ChromeDriverCapabilities chromeDriverCapabilities = new ChromeDriverCapabilities();
        chromeDriverCapabilities.defaultCapabilities();

        super.proxyWrapper = new ProxyWrapper();
        proxyWrapper.startProxy();
        chromeDriverCapabilities.setProxy(proxyWrapper.getSeleniumProxy());

        super.wd = new ChromeDriver(chromeDriverCapabilities.getCapabilities());
    }

    public ChromeWebDriver(DesiredCapabilities desiredCapabilities) {
        super.wd = new ChromeDriver(desiredCapabilities);
    }

}
