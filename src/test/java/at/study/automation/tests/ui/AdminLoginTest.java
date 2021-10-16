package at.study.automation.tests.ui;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import at.study.automation.model.user.User;


public class AdminLoginTest extends BaseUITest {
    private User admin;

    @BeforeMethod
    public void prepareFixtures() {
        admin = new User() {{
            setIsAdmin(true);
        }}.create();

        openBrowser("/login");
    }

    @Test
    public void positiveAdminLoginTest() {
        loginPage.login(admin);
        Assert.assertEquals(headerPage.myAccount.getText(), "Моя учётная запись");
    }

}
