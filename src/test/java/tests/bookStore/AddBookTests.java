package tests.bookStore;

import data.UserData;
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
        new SidePanel(driver).selectLogin();
        new LoginPage(driver)
                .login(UserData.USER_NAME,UserData.USER_PASSWORD)
                .assertAccount(UserData.USER_NAME);
        new SidePanel(driver).selectBookStore();

    }

    @Test
    public void addBookTest() {
        new BookStorePage(driver)
                .clickTextInBook()
                .AddToCollection("Add To Your Collection");
        new SidePanel(driver)
               .selectProfile();
       new ProfilePage(driver)
              .clickDelete();

    }

}

// Создать тестовый класс AddBookTests и реализовать там
// сценарий по добавлению книги. Для этого следует зайти
// на главную страницу, перейти на BookStoreApplication,
// залогиниться, зайти в BookStore, добавить книгу,
// зайти в профиль и убедиться, что книга добавлена.
// В постусловии книгу следует удалить
