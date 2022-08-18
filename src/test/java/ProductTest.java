import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.net.URL;

import static org.testng.Assert.assertEquals;

public class ProductTest extends BaseTest {
    @Test
    public void buyProduct() {
        driver.get(URL);
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.name("password")).sendKeys("secret_sauce");
        driver.findElement(By.cssSelector("[value=Login]")).click();
        driver.findElement(By.xpath("//div[text() = 'Sauce Labs Backpack']//ancestor::div[@class='inventory_item']//button")).click();
        driver.findElement(By.id("shopping_cart_container")).click();
        String price = driver.findElement(By.xpath("//div[text() = 'Sauce Labs Backpack']//ancestor::div[@class='cart_item']//div[@class='inventory_item_price']")).getText();
        assertEquals(price, "$29.99");




    }
}
