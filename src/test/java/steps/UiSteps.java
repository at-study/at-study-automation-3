package steps;

import java.util.List;

import org.openqa.selenium.WebElement;

import at.study.automation.allure.AllureAssert;
import at.study.automation.context.Context;
import at.study.automation.cucumber.PageObjectHelper;
import at.study.automation.model.user.User;
import at.study.automation.ui.pages.HeaderPage;
import at.study.automation.ui.pages.LoginPage;
import cucumber.api.java.ru.Если;
import cucumber.api.java.ru.И;

import static at.study.automation.ui.browser.BrowserUtils.getElementsText;
import static at.study.automation.ui.pages.Page.getPage;
import static at.study.automation.utils.CompareUtils.assertListSortedByDateDesc;

public class UiSteps {

    @И("Авторизоваться как пользователь \"(.+)\"")
    public void authByUser(String userStashId) {
        User user = Context.getStash().get(userStashId, User.class);
        getPage(LoginPage.class).login(user);
    }

    @И("Авторизоваться по логину \"(.+)\" и паролю \"(.+)\"")
    public void authByLoginAndPassword(String login, String password) {
        getPage(LoginPage.class).login(login, password);
    }

    @И("Текст элемента Моя учётная запись - \"(.*)\"")
    public void assertMyAccountText(String expectedText) {
        AllureAssert.assertEquals(getPage(HeaderPage.class).myAccount.getText(), expectedText);
    }

    @Если("На странице {string} нажать на элемент {string}")
    public void clickOnElementOnPage(String pageName, String elementName) {
        PageObjectHelper.findElement(pageName, elementName).click();
    }

    @И("На странице {string} в поле {string} ввести текст {string}")
    public void sendKeysToElementOnPage(String pageName, String elementName, String charSequence) {
        PageObjectHelper.findElement(pageName, elementName).sendKeys(charSequence);
    }

    @И("На странице {string} тексты элементов {string} отсортированы по дате по убыванию")
    public void assertElementsTextsIsSortedByDateDesc(String pageName, String elementsName) {
        List<WebElement> elements = PageObjectHelper.findElements(pageName, elementsName);
        List<String> elementsTexts = getElementsText(elements);
        assertListSortedByDateDesc(elementsTexts);
    }
}
