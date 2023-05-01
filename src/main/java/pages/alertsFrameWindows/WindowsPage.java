package pages.alertsFrameWindows;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import pages.BasePage;

import java.util.ArrayList;
import java.util.List;

public class WindowsPage extends BasePage {
    public WindowsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "tabButton")
    WebElement tabButton;

    public WindowsPage switchToNewTab(int index) {
        click(tabButton);
        List<String> tabs = new ArrayList<>(driver.getWindowHandles());

        driver.switchTo().window(tabs.get(index));
        return this;
    }

    @FindBy(id = "sampleHeading")
    WebElement sampleHeading;

    public WindowsPage assertNewTabByMessage(String text) {
        Assert.assertTrue(shouldHaveText(sampleHeading,text,15));
        return this;
    }

    @FindBy(id="windowButton")
    WebElement windowButton;

    public WindowsPage switchToNewWindow(int index) {
        click(windowButton);
        List<String> windows = new ArrayList<>(driver.getWindowHandles());

        driver.switchTo().window(windows.get(index));
        return this;
    }
}
