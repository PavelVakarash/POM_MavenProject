package pages.bookStore;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import pages.BasePage;

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

    public BookStorePage AddToCollection(String text) {
        clickWithJSExecutor(buttonAddToCollection,0,500);
        driver.switchTo().alert().accept();
        pause(4000);
        Assert.assertTrue(buttonAddToCollection.getText().contains(text));
        return new BookStorePage(driver);
    }

    @FindBy(id = "login")
    WebElement loginButton;

    public LoginPage clickLoginButton() {
        click(loginButton);
        return new LoginPage(driver);
    }
}
