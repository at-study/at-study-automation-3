package at.study.automation.ui.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import at.study.automation.cucumber.ElementName;
import at.study.automation.cucumber.PageName;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PACKAGE)
@PageName("Заголовок страницы")
public class HeaderPage extends Page {

    @ElementName("Администрирование")
    @FindBy(xpath = "//div[@id='top-menu']//a[@class='administration']")
    public WebElement administration;

    @ElementName("Войти")
    @FindBy(xpath = "//div[@id='account']//a[@class='login']")
    public WebElement loginButton;

    @ElementName("Моя учётная запись")
    @FindBy(xpath = "//div[@id='account']//a[@class='my-account']")
    public WebElement myAccount;

}
