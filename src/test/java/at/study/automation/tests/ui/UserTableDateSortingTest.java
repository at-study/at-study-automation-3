package at.study.automation.tests.ui;

import java.util.List;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import at.study.automation.model.user.User;

import static at.study.automation.ui.browser.BrowserUtils.click;
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
        click(headerPage.administration, "Администрирование");
        click(administrationPage.users, "Пользователи");
    }

    @Test(description = "Администрирование. Пользователи. Проверка сортировки списка дат в таблице пользователей")
    public void testUsersTableDateSorting() {
        click(userTablePage.button("Создано"), "Создано");
        List<String> creationDatesByDesc = getElementsText(userTablePage.creationDates);
        assertListSortedByDateDesc(creationDatesByDesc);

        click(userTablePage.button("Создано"), "Создано");
        List<String> creationDatesByAsc = getElementsText(userTablePage.creationDates);
        assertListSortedByDateAsc(creationDatesByAsc);
    }

}
