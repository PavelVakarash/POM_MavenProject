package tests.alertFrameWindows;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.SidePanel;
import pages.alertsFrameWindows.AlertsPage;
import tests.TestBase;

public class AlertTests extends TestBase {

    @BeforeMethod
    public void precondition() {
        new HomePage(driver).getAlertFrameWindows();
        new SidePanel(driver).selectAlerts();
    }
@Test
        public void alertWaitTest() {
        new AlertsPage(driver).clickByAlertWithTimer();
    }
}
