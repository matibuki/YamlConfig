package configuration.models;

public class Browser {
    public void setBrowserName(String browserName) {
        this.browserName = browserName;
    }

    public void setAppUrl(String appUrl) {
        this.appUrl = appUrl;
    }

    private String browserName;
    private String appUrl;


    public String getBrowserName() {
        return browserName;
    }

    public String getAppUrl() {
        return appUrl;
    }
}
