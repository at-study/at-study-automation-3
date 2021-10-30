package at.study.automation.tests.ui;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import at.study.automation.allure.AllureAssert;
import at.study.automation.model.user.User;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;


public class AdminLoginTest extends BaseUITest {
    private User admin;

    @BeforeMethod(description = "В системе заведен пользователь с правами Администратора. Открыт браузер на главной странице")
    public void prepareFixtures() {
        admin = new User() {{
            setIsAdmin(true);
        }}.create();

        openBrowser("/login");
    }


    @Test(description = "Вход администратором. Проверка элемента \"Моя учётная запись\"")
    @Severity(SeverityLevel.BLOCKER)
    @Owner("Левченко Георгий Александрович")
    public void positiveAdminLoginTest() {
        loginPage.login(admin);
        AllureAssert.assertEquals(
                headerPage.myAccount.getText(),
                "Моя учётная запись",
                "Текст элемента \"Моя учетная запись\""
        );
        AllureAssert.assertEquals(
                headerPage.administration.getText(),
                "Администрирование",
                "Текст элемента \"Администрирование\""
        );
    }

}
