package at.study.automation.ui.pages;

import org.openqa.selenium.support.PageFactory;

import at.study.automation.ui.browser.BrowserManager;

public abstract class Page {

    Page() {
        PageFactory.initElements(BrowserManager.getBrowser().getDriver(), this);
    }

}
