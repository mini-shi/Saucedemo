package Tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class CheckoutOverviewTest extends  BaseTest {
    @Test
    public void buyProduct() {
        loginPage.open();
        loginPage.login(login, password);
        assertTrue(productsPage.isOpened());
        productsPage.addToCart("Sauce Labs Backpack");
        productsPage.clickCart();
        cartPage.goToCheckout();
        checkoutPage.fillInCheckout("Test", "Test", "12345");
        cartPage.clickFinish();
        assertTrue(driver.findElement(By.id("checkout_complete_container")).isDisplayed(),
                "Сообщение об успешной покупке");
    }
}
