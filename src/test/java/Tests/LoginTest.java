package Tests;

import Pages.LoginPage;
import Pages.ProductsPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
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

    @Test(dataProvider = "Data for negative login tests")
    public void negativeLogin(String userName, String password, String error) {
        loginPage.open();
        loginPage.login(userName, password );
        assertEquals(loginPage.getErrorMessage(),
                error);

    }


    @DataProvider (name = "Data for negative login tests")
    public Object[][] loginData() {
        return new Object[][]{
                {"standard_user", "wedwedw", "Epic sadface: Username and password do not match any user in this service" },
                {"", "secret_sauce", "Epic sadface: Username is required" }
        };
    }

}
