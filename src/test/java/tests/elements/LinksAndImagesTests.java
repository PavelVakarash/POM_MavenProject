package tests.elements;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.SidePanel;

import pages.elements.BrokenLinksImagesPage;
import pages.elements.LinksPage;
import tests.TestBase;

public class LinksAndImagesTests extends TestBase {

    @BeforeMethod
    public void precondition() {
        new HomePage(driver).getElements();
    }

    @Test
    public void getAllLinksTest() {
        new SidePanel(driver).selectLinks();
        new LinksPage(driver).checkAllUrl();
    }

    @Test
    public void checkBrokenLinksTest() {
        new SidePanel(driver).selectBrokenLinks();
        new BrokenLinksImagesPage(driver).checkBrokenLinks();
    }

    @Test
    public void checkBrokenImagesTest() {
        new SidePanel(driver).selectBrokenLinks();
        new BrokenLinksImagesPage(driver).checkBrokenImages();
    }
}
