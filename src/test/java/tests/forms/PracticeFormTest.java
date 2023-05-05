package tests.forms;

import data.StudentData;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.SidePanel;
import pages.forms.PracticeFormPage;
import tests.TestBase;

public class PracticeFormTest extends TestBase {

    @BeforeMethod
    public void precondition() {
        new HomePage(driver).getForms();
        new SidePanel(driver).selectPracticeForm();
    }

    @Test
    public void enterPracticeForm() {
        new PracticeFormPage(driver).hideIframes();
        new PracticeFormPage(driver)
                .enterPersonalData(StudentData.FIRST_NAME,StudentData.LAST_NAME,
                StudentData.EMAIL,StudentData.PHONE)
               .selectGender(StudentData.GENDER).typeOfDate(StudentData.DATE)
//                //.chooseDate("May","2000","13")
                .addSubject(StudentData.SUBJECTS)
                .chooseHobby(StudentData.HOBBIES)
                .uploadFile(StudentData.PHOTO_PATH)
                .enterAddress(StudentData.ADDRESS)
                .inputState(StudentData.STATE)
                .inputCity(StudentData.CITY)
                .submitForm();
    }
}
