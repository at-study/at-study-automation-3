package at.study.automation.ui.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import at.study.automation.model.user.User;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PACKAGE)
public class LoginPage extends Page {

    @FindBy(xpath = "//input[@id='username']")
    private WebElement loginInput;

    @FindBy(xpath = "//input[@id='password']")
    private WebElement passwordInput;

    @FindBy(xpath = "//input[@id='login-submit']")
    private WebElement signInButton;

    @FindBy(xpath = "//div[@id='flash_error']")
    public WebElement errorFlash;

    public void login(String login, String password) {
        loginInput.sendKeys(login);
        passwordInput.sendKeys(password);
        signInButton.click();
    }

    public void login(User user) {
        login(user.getLogin(), user.getPassword());
    }


}
