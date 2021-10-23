package at.study.automation.tests.ui;

import java.util.List;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import at.study.automation.model.user.User;

import static at.study.automation.ui.browser.BrowserUtils.getElementsText;
import static at.study.automation.utils.CompareUtils.assertListSortedByDateAsc;
import static at.study.automation.utils.CompareUtils.assertListSortedByDateDesc;

public class UserTableDateSortingTest extends BaseUITest {

    @BeforeMethod
    public void prepareFixtures() {
        User admin = new User() {{
            setIsAdmin(true);
        }}.create();

        openBrowser("/login");
        loginPage.login(admin);
        headerPage.administration.click();
        administrationPage.users.click();
    }

    @Test
    public void testUsersTableDateSorting() {
        userTablePage.button("Создано").click();
        List<String> creationDatesByDesc = getElementsText(userTablePage.creationDates);
        assertListSortedByDateDesc(creationDatesByDesc);

        userTablePage.button("Создано").click();
        List<String> creationDatesByAsc = getElementsText(userTablePage.creationDates);
        assertListSortedByDateAsc(creationDatesByAsc);
    }

}
