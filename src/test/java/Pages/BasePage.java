package Pages;

import Tests.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {

    WebDriver driver;
    WebDriverWait driverWait;


    public static final String BASE_URL = "https://www.saucedemo.com/";
    private final By CART = By.id("shopping_cart_container");

    public BasePage(WebDriver driver) {

        this.driver = driver;
        driverWait = new WebDriverWait(driver,10);
    }
    public void clickCart() {
        driver.findElement(CART).click();
        clickJS(CART);
    }
    public boolean waitForVisibility(By locator) {
        try {
            driverWait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        } catch (TimeoutException ex) {
            return false;
        }
        return true;
    }

    public void clickJS(By locator) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", driver.findElement(locator));
    }


}
