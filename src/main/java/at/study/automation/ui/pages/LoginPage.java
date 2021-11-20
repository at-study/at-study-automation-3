package at.study.automation.ui.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import at.study.automation.cucumber.ElementName;
import at.study.automation.cucumber.PageName;
import at.study.automation.model.user.User;
import io.qameta.allure.Step;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PACKAGE)
@PageName("Страница авторизации")
public class LoginPage extends Page {

    @ElementName("Логин")
    @FindBy(xpath = "//input[@id='username']")
    private WebElement loginInput;

    @ElementName("Пароль")
    @FindBy(xpath = "//input[@id='password']")
    private WebElement passwordInput;

    @ElementName("Вход")
    @FindBy(xpath = "//input[@id='login-submit']")
    private WebElement signInButton;

    @ElementName("Сообщение")
    @FindBy(xpath = "//div[@id='flash_error']")
    public WebElement errorFlash;

    @Step("Авторизация пользователем с логином {0} и паролем {1}")
    public void login(String login, String password) {
        loginInput.sendKeys(login);
        passwordInput.sendKeys(password);
        signInButton.click();
    }

    public void login(User user) {
        login(user.getLogin(), user.getPassword());
    }


}
