package at.study.automation.tests.ui;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static at.study.automation.ui.browser.BrowserUtils.isElementDisplayed;

public class NoAdministrationWhenNotAuthorized extends BaseUITest {

    @BeforeMethod
    public void prepareFixtures() {
        openBrowser();
    }

    @Test
    public void noAdministrationDisplayedTest() {
        Assert.assertFalse(isElementDisplayed(headerPage.administration));
    }
}
