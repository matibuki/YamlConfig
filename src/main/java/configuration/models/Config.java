package configuration.models;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import configuration.factory.BrowserFactory;

import java.util.HashMap;

public class Config {
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

    private String activeEnvironment;
    private BrowserFactory browser;
    private HashMap<String, Environment> environments = new HashMap<>();

    @JsonAnySetter
    void setProperties(String key, Environment value) {
        environments.put(key, value);
    }

    @JsonAnyGetter
    public HashMap<String, Environment> getEnvironments() {
        return environments;
    }
}
