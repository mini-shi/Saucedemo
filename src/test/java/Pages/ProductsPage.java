package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProductsPage extends BasePage {
    private By PAGE_TITLE = By.cssSelector(".title");

    public ProductsPage(WebDriver driver) {
        super(driver);
    }
    public void open() {
        driver.get("https://www.saucedemo.com/inventory.html");
    }

    public boolean isOpened() {
      return waitForVisibility(PAGE_TITLE);
    }
    public void addToCart(String product) {
        String locator = String.format("//div[text() = '%s']//ancestor::div[@class='inventory_item']//button",
                product);
        driver.findElement(By.xpath(locator)).click();

    }
}
