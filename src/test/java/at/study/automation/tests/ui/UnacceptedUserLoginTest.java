package at.study.automation.tests.ui;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import at.study.automation.model.user.Status;
import at.study.automation.model.user.User;

import static org.testng.Assert.assertEquals;

public class UnacceptedUserLoginTest extends BaseUITest {

    private User unacceptedUser;

    @BeforeMethod
    public void prepareFixtures() {
        unacceptedUser = new User() {{
            setStatus(Status.UNACCEPTED);
        }}.create();

        openBrowser("/login");
    }

    @Test
    public void testUnacceptedUserLogin() {
        loginPage.login(unacceptedUser);
        assertEquals(loginPage.errorFlash.getText(), "Ваша учётная запись создана и ожидает подтверждения администратора.");
    }


}
