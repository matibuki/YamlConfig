package configuration.models;

import configuration.factory.BrowserFactory;

import java.util.HashMap;

public class Config {
    private String activeEnvironment;
    private BrowserFactory browser;
    private HashMap<String, Environment> environments = new HashMap<>();

    private Config() {
    }

    public String getActiveEnvironment() {
        return activeEnvironment;
    }

    public void setActiveEnvironment(String activeEnvironment) {
        this.activeEnvironment = activeEnvironment;
    }

    public BrowserFactory getBrowser() {
        return browser;
    }

    public void setBrowser(BrowserFactory browser) {
        this.browser = browser;
    }
    public HashMap<String, Environment> getEnvironments() {
        return environments;
    }

    public void setEnvironments(HashMap<String, Environment> environments) {
        this.environments = environments;
    }

}
