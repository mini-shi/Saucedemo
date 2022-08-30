package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class CheckoutTest extends BaseTest {
    @Test
    public void checkoutInfo() {
        loginPage.open();
        loginPage.login(login, password);
        productsPage.addToCart("Sauce Labs Backpack");
        productsPage.clickCart();
        cartPage.goToCheckout();
        checkoutPage.fillInCheckout("Test", "Test", "12345");
        assertTrue(driver.findElement(By.cssSelector(".summary_info")).isDisplayed());

    }

    @Test
    public void emptyFieldFirstName() {
        loginPage.open();
        loginPage.login(login, password);
        productsPage.addToCart("Sauce Labs Backpack");
        productsPage.clickCart();
        cartPage.goToCheckout();
        checkoutPage.fillInCheckout("", "Test", "12345");
        assertEquals(checkoutPage.getError(), "Error: First Name is required");
    }

    @Test
    public void emptyFieldLastName() {
        loginPage.open();
        loginPage.login(login, password);
        productsPage.addToCart("Sauce Labs Backpack");
        productsPage.clickCart();
        cartPage.goToCheckout();
        checkoutPage.fillInCheckout("Test", "", "12345");
        assertEquals(checkoutPage.getError(), "Error: Last Name is required");
    }

    @Test
    public void emptyFieldZipcode() {
        loginPage.open();
        loginPage.login(login, password);
        productsPage.addToCart("Sauce Labs Backpack");
        productsPage.clickCart();
        cartPage.goToCheckout();
        checkoutPage.fillInCheckout("Test", "Test", "");
        assertEquals(checkoutPage.getError(), "Error: Postal Code is required");
    }

    @Test
    public void cancelCheckout() {
        loginPage.open();
        loginPage.login(login, password);
        productsPage.addToCart("Sauce Labs Backpack");
        productsPage.clickCart();
        cartPage.goToCheckout();
        checkoutPage.clickCancel();
    }
}

