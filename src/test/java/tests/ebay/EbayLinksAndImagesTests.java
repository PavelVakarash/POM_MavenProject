package tests.ebay;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.ebay.EbayLinksPage;
import pages.ebay.EbayBrokenLinksImagesPage;
import java.time.Duration;

public class EbayLinksAndImagesTests {

    public WebDriver driver;

    @BeforeMethod
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("remote-allow-origins=*");
        driver = new ChromeDriver(options);

        driver.get("https://ebay.de");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void getEbayAllLinksTest() {
        new EbayLinksPage(driver).checkAllUrl();

    }

    @Test
    public void EbayCheckBrokenLinksTest() {
        new EbayBrokenLinksImagesPage(driver).checkBrokenLinks();

    }

    @Test
    public void EbayCheckBrokenImagesTest() {
        new EbayBrokenLinksImagesPage(driver).checkBrokenImages();
    }
}

