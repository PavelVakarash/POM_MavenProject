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

    @FindBy(xpath = "//a[text()='Git Pocket Guide']")
    WebElement textGit;

    public BookStorePage clickTextInBook(String text) {
        click(textGit);
        return this;
    }

    @FindBy(xpath = "//button[@id='addNewRecordButton']")
    WebElement buttonAddToCollection;

    public BookStorePage clickOnButton(String text) {
        clickWithJSExecutor(buttonAddToCollection,0,500);
        return this;
    }
}
