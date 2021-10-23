package at.study.automation.ui.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PACKAGE)
public class HeaderPage extends Page {

    @FindBy(xpath = "//div[@id='top-menu']//a[@class='administration']")
    public WebElement administration;

    @FindBy(xpath = "//div[@id='account']//a[@class='login']")
    public WebElement loginButton;

    @FindBy(xpath = "//div[@id='account']//a[@class='my-account']")
    public WebElement myAccount;

}
