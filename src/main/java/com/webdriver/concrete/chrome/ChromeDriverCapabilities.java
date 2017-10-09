package com.webdriver.concrete.chrome;

import com.webdriver.concrete.CommonDriverCapabilities;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;

public class ChromeDriverCapabilities extends CommonDriverCapabilities{

    private ChromeOptions options = new ChromeOptions();
    private Map<String, Object> experimentalOptions = new HashMap<>();

    public ChromeDriverCapabilities() {
        super(DesiredCapabilities.chrome());
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
        capabilities.setCapability("prefs", experimentalOptions);
    }

    public void defaultCapabilities() {
//        ChromeDriverCapabilities chromeDriverCapabilities = new ChromeDriverCapabilities();

        setExperimentalOptions(Arrays.asList(
                ChromeDriverExperimentalOptions.DISABLE_CREDENTIALS_SERVICE,
                ChromeDriverExperimentalOptions.DISABLE_PASSWORD_MANAGER,
                ChromeDriverExperimentalOptions.ENABLE_FLASH
        ));

        setOptions(Arrays.asList(
                ChromeDriverOptions.ALLOW_HIDDEN_MEDIA_PLAYBACK,
                ChromeDriverOptions.ALLOW_OUTDATED_PLUGINS,
                ChromeDriverOptions.ALWAYS_AUTHORIZE_PLUGINS,
                ChromeDriverOptions.DISABLE_INFOBARS,
                ChromeDriverOptions.NO_SANDBOX
        ));

        setDriverLogger(LogType.BROWSER, Level.ALL);
    }


    public void setOption(ChromeDriverOptions option){
        options.addArguments(option.value());
    }

    public void setOptions(Collection<ChromeDriverOptions> options){
        for (ChromeDriverOptions opt : options){
            setOption(opt);
        }
    }

    public void setExperimentalOption(ChromeDriverExperimentalOptions option) {
        experimentalOptions.put(option.option(), option.state());
    }
    public void setExperimentalOptions(Collection<ChromeDriverExperimentalOptions> options){
        for (ChromeDriverExperimentalOptions option : options) {
            setExperimentalOption(option);
        }
    }
}