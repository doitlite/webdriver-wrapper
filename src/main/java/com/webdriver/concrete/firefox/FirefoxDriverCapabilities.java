package com.webdriver.concrete.firefox;

import com.webdriver.concrete.CommonDriverCapabilities;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Collection;
import java.util.logging.Level;

public class FirefoxDriverCapabilities extends CommonDriverCapabilities {

    private FirefoxOptions options = new FirefoxOptions();

    public FirefoxDriverCapabilities() {
        super(DesiredCapabilities.firefox());
        super.capabilities.setCapability(FirefoxOptions.FIREFOX_OPTIONS, options);
    }

    public DesiredCapabilities defaultCapabilities(){
        FirefoxDriverCapabilities firefoxDriverCapabilities = new FirefoxDriverCapabilities();

        firefoxDriverCapabilities.setDriverLogger(LogType.BROWSER, Level.INFO);
        return firefoxDriverCapabilities.getCapabilities();
    }



    public void setOption(FirefoxDriverOptions option){
        options.addArguments(option.value());
    }

    public void setOptions(Collection<FirefoxDriverOptions> options){
        for (FirefoxDriverOptions opt : options){
            setOption(opt);
        }
    }

    public void setCapability(String capability, String value){
        super.capabilities.setCapability(capability, value);
    }
}