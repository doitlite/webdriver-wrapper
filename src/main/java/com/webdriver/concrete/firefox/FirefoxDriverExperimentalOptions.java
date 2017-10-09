package com.webdriver.concrete.firefox;

public enum FirefoxDriverExperimentalOptions {
    DISABLE_CREDENTIALS_SERVICE("credentials_enable_service", false),
    DISABLE_PASSWORD_MANAGER("profile.password_manager_enabled", false),
    ENABLE_FLASH("profile.default_content_settings.state.flash", 2);

    private final String option;
    private final Object state;

    FirefoxDriverExperimentalOptions(final String option, final Object state){
        this.option = option;
        this.state = state;
    }

    public String option() {
        return option;
    }

    public Object state() {
        return state ;
    }

    @Override
    public String toString() {
        return option + ":" + String.valueOf(state);
    }
}
