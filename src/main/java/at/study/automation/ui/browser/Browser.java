package at.study.automation.ui.browser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import at.study.automation.property.Property;
import lombok.Getter;

import static java.util.concurrent.TimeUnit.SECONDS;

@Getter
public class Browser {

    private WebDriver driver;
    private WebDriverWait wait;

    Browser() {
        this("");
    }

    Browser(String uri) {
        driver = DriverFactory.getDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, SECONDS);
        wait = new WebDriverWait(driver, 10);
        get(uri);
    }

    public void get(String uri) {
        getDriver().get(Property.getStringProperty("url") + uri);
    }

    public void refresh() {
        getDriver().navigate().refresh();
    }

}
