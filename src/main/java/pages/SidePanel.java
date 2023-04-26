package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.alertsFrameWindows.AlertsPage;
import pages.bookStore.BookStorePage;
import pages.bookStore.LoginPage;

public class SidePanel extends BasePage {
    public SidePanel(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//span[.='Login']")
    WebElement login;

    public LoginPage selectLogin() {
        clickWithJSExecutor(login,0,600);
        return new LoginPage(driver);
    }

    @FindBy(xpath = "//span[.='Alerts']")
    WebElement alerts;

    public AlertsPage selectAlerts() {
        clickWithJSExecutor(alerts,0,400);
        return new AlertsPage(driver);
    }

    @FindBy(xpath = "//span[.='Book Store']")
    WebElement bookstore;

    public BookStorePage selectBookStore() {
        clickWithJSExecutor(bookstore,0,600);
        return new BookStorePage(driver);
    }

    @FindBy(xpath = "//span[.='Profile']")
    WebElement profile;

    public BookStorePage selectProfile() {
        clickWithJSExecutor(profile,0,400);
        return new BookStorePage(driver);
    }
}
