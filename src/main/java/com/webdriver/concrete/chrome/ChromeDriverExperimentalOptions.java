package com.webdriver.concrete.chrome;

public enum ChromeDriverExperimentalOptions {
    DISABLE_CREDENTIALS_SERVICE("credentials_enable_service", false),
    DISABLE_PASSWORD_MANAGER("profile.password_manager_enabled", false),
    ENABLE_FLASH("profile.default_content_settings.state.flash", 2);

    private final String option;
    private final Object state;

    ChromeDriverExperimentalOptions(final String option, final Object state){
        this.option = option;
        this.state = String.valueOf(state);
    }

    public String option() {
        return option;
    }

    public Object state() {
        return state ;
    }

    @Override
    public String toString() {
        return option + ":" + state;
    }
}
