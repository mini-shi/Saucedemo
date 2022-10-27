package Tests;

import Pages.BasePage;
import Pages.CartPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class ProductTest extends BaseTest {


    @Test
    public void buyProduct() {
        loginPage.open();
        loginPage.login(login, password);
        assertTrue(productsPage.isOpened());
        productsPage.addToCart("Sauce Labs Backpack");
        productsPage.clickCart();
        assertTrue(cartPage.isOpened());
        assertEquals(cartPage.getItemPrice("Sauce Labs Backpack"), "$29.99", "Product price is not correct");
        assertEquals(cartPage.getNameItem("Sauce Labs Backpack"), "Sauce Labs Backpack");
    }

}
