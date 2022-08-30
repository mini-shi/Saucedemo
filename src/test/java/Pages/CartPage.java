package Pages;

import Tests.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage {
    private final By CHECKOUT_BUTTON = By.id("checkout");
    private final By FINISH_BUTTON = By.id("finish");

    public CartPage(WebDriver driver) {
        super(driver);
    }
    public boolean isOpened() {
        return waitForVisibility(CHECKOUT_BUTTON);
    }
    public String getNameItem(String product) {
        String locator = String.format("//div[text() = '%s']//ancestor::div[@class='cart_item']//a[@href='#']", product);
        return driver.findElement(By.xpath(locator)).getText();
    }
    public String getItemPrice(String product) {
        String locator = String.format("//div[text() = '%s']//ancestor::div[@class='cart_item']//div[@class='inventory_item_price']", product);
        return driver.findElement(By.xpath(locator)).getText();
    }


    public void goToCheckout() {

        driver.findElement(CHECKOUT_BUTTON).click();
    }

    public void clickFinish() {
        driver.findElement(FINISH_BUTTON).click();
    }

}
