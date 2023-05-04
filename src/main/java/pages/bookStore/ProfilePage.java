package pages.bookStore;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pages.BasePage;

import java.time.Duration;

public class ProfilePage extends BasePage {
    public ProfilePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "userName-value")
    WebElement user;

    public ProfilePage assertAccount(String uName) {
        Assert.assertTrue(shouldHaveText(user,uName,15));
        return this;
    }

    @FindBy(id="delete-record-undefined")
    WebElement delete;

    @FindBy(id="closeSmallModal-ok")
    WebElement ok;

    public ProfilePage clickDelete(String text) {
        clickWithJSExecutor(delete,0,400);
        click(ok);
        if (text!=null && text.equals("Ok")) {
            driver.switchTo().alert().accept();
        } else if (text!=null && text.equals("Cancel")) {
            driver.switchTo().alert().dismiss();
        }
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            wait.until(ExpectedConditions.alertIsPresent());
            driver.switchTo().alert().accept();
        } catch (TimeoutException e) {

        }
        return this;
    }
}
