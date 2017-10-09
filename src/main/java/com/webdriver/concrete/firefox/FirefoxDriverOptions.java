package com.webdriver.concrete.firefox;

public enum FirefoxDriverOptions {
    LOG_LEVEL_WARN("X"),
    DISABLE_INFOBARS("--disable-infobars"),
    ALWAYS_AUTHORIZE_PLUGINS("--always-authorize-plugins"),
    ALLOW_OUTDATED_PLUGINS("--allow-outdated-plugins"),
    ALLOW_HIDDEN_MEDIA_PLAYBACK("--allow-hidden-media-playback");

    private final String option;

    private FirefoxDriverOptions(final String option){
        this.option = option;
    }

    public String value() {
        return option;
    }

    @Override
    public String toString() {
        return option;
    }
}
