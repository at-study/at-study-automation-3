package at.study.automation.tests.ui;

import org.testng.annotations.AfterMethod;

import at.study.automation.ui.browser.Browser;
import at.study.automation.ui.browser.BrowserManager;
import at.study.automation.ui.pages.AdministrationPage;
import at.study.automation.ui.pages.HeaderPage;
import at.study.automation.ui.pages.LoginPage;
import at.study.automation.ui.pages.Page;
import at.study.automation.ui.pages.UserTablePage;

public class BaseUITest {

    protected Browser browser;
    protected HeaderPage headerPage;
    protected LoginPage loginPage;
    protected AdministrationPage administrationPage;
    protected UserTablePage userTablePage;

    protected void openBrowser() {
        browser = BrowserManager.getBrowser();
        initPages();
    }

    protected void openBrowser(String uri) {
        browser = BrowserManager.getBrowser(uri);
        initPages();
    }

    private void initPages() {
        headerPage = Page.getPage(HeaderPage.class);
        loginPage = Page.getPage(LoginPage.class);
        administrationPage = Page.getPage(AdministrationPage.class);
        userTablePage = Page.getPage(UserTablePage.class);
    }

    @AfterMethod
    public void tearDown() {
        BrowserManager.closeBrowser();
    }
}
