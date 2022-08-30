package Tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class CartTest extends BaseTest {
    @Test
    public void cartNotEmpty() {
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
