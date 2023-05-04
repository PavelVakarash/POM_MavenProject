package pages.bookStore;

import org.openqa.selenium.Alert;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pages.BasePage;

import java.time.Duration;

public class BookStorePage extends BasePage {

    public BookStorePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "searchBox")
    WebElement searchBox;

    public BookStorePage typeInSearchField(String text) {
        type(searchBox,text);
        return this;
    }

    @FindBy(xpath = "//span[@class='mr-2']/a")
    WebElement nameOfBook;

    public BookStorePage assertNameOfBook(String text) {
        Assert.assertTrue(nameOfBook.getText().contains(text));
        return this;
    }

    @FindBy(id = "see-book-Git Pocket Guide")
    WebElement textGit;

    public BookStorePage clickTextInBook() {
        click(textGit);
        return this;
    }

    @FindBy(xpath = "//button[contains(text(),'Add To Your Collection')]")
    WebElement buttonAddToCollection;

    public BookStorePage AddToCollection() {
        clickWithJSExecutor(buttonAddToCollection,0,400);
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            wait.until(ExpectedConditions.alertIsPresent());
            driver.switchTo().alert().accept();
        } catch (TimeoutException e) {

        }
        return this;
    }


    @FindBy(id = "login")
    WebElement loginButton;

    public LoginPage clickLoginButton() {
        click(loginButton);
        return new LoginPage(driver);
    }

}
