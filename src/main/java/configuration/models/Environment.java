package configuration.models;

import java.util.HashMap;

public class Environment {
    private Browser browser;
    private HashMap<String, Object> data = new HashMap<>();

    public void setBrowser(Browser browser) {
        this.browser = browser;
    }
    public void setData(HashMap<String, Object> data) {
        this.data = data;
    }
    public void setData(String key, Object value) {
        data.put(key,value);
    }

    public Browser getBrowser() {
        return browser;
    }
    public HashMap<String, Object> getData() {
        return data;
    }
}
