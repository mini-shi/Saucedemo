package Tests;

import Pages.LoginPage;
import Pages.ProductsPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class LoginTest extends BaseTest {

    @Test
    public void login() {
        loginPage.open();
        loginPage.login(login, password);
        assertTrue(productsPage.isOpened(), "PRODUCTS");
    }

    @Test
    public void wrongPassword() {
        loginPage.open();
        loginPage.login("standard_user", "wedwedw");
        assertEquals(loginPage.getErrorMessage(),
                "Epic sadface: Username and password do not match any user in this service");

    }

    @Test
    public void emptyUserName() {
        loginPage.open();
        loginPage.login("", password);
        assertEquals(loginPage.getErrorMessage(),
                "Epic sadface: Username is required");
    }
}
