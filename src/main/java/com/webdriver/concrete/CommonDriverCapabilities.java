package com.webdriver.concrete;

import org.openqa.selenium.Proxy;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.logging.Level;

public class CommonDriverCapabilities {

    protected DesiredCapabilities capabilities;

    public CommonDriverCapabilities(DesiredCapabilities capabilities) {
        this.capabilities = capabilities;
    }

    public DesiredCapabilities getCapabilities() {
        return capabilities;
    }

//    public void setProxy(){
//        ProxyWrapper proxyWrapper = new ProxyWrapper();
//        capabilities.setCapability(CapabilityType.PROXY, proxyWrapper.getSeleniumProxy());
//        proxyWrapper.startProxy();
//    }

    public void setProxy(Proxy proxy){
        capabilities.setCapability(CapabilityType.PROXY, proxy);
    }

    public void setDriverLogger(String logType, Level level){
        LoggingPreferences logPrefs = new LoggingPreferences();
        logPrefs.enable(logType, level);
        capabilities.setCapability(CapabilityType.LOGGING_PREFS, logPrefs);
    }

}
