package configuration.models;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import configuration.factory.EnvironmentFactory;

import java.util.HashMap;

public class Environment extends EnvironmentFactory {
    public Browser getBrowser() {
        return browser;
    }

    private Browser browser;

    private HashMap<String, Object> user = new HashMap<>();

    @JsonAnySetter
    void setUser(String key, Object value) {
        user.put(key, value);
    }

    @JsonAnyGetter
    public HashMap<String, Object> getUser() {
        return user;
    }
}
