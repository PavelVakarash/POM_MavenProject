package tests.bookStore;

import data.BookData;
import data.UserData;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.SidePanel;
import pages.bookStore.BookStorePage;
import pages.bookStore.LoginPage;
import pages.bookStore.ProfilePage;
import tests.TestBase;

public class AddBookTests extends TestBase {

    @BeforeMethod
    public void precondition() {
        new HomePage(driver).getBookStoreApplication();
        new BookStorePage(driver).clickLoginButton();
        new LoginPage(driver).login(UserData.USER_NAME,UserData.USER_PASSWORD);
    }

    @Test
    public void addBookTest() {
        new BookStorePage(driver)
                .clickTextInBook()
                            .AddToCollection();
               new SidePanel(driver)
             .selectProfile();
      new ProfilePage(driver)
             .clickDelete("ok");

    }

//    @Test
//    public void addBookToCollectionPositiveTest() {
//        new BookStorePage(driver).typeInSearchField(BookData.BOOK_NAME)
//                .clickByFirstBook()
//                .addToYourCollection();
//        new SidePanel(driver).selectProfile();
//        new BookStorePage(driver).assertNameOfBook("Git Pocket Guide");
//
//    }
//
//    @AfterMethod
//    public void postConditions() {
//        new ProfilePage(driver).clickOnTrashToDeleteBook();
//    }

}

// Создать тестовый класс AddBookTests и реализовать там
// сценарий по добавлению книги. Для этого следует зайти
// на главную страницу, перейти на BookStoreApplication,
// залогиниться, зайти в BookStore, добавить книгу,
// зайти в профиль и убедиться, что книга добавлена.
// В постусловии книгу следует удалить
