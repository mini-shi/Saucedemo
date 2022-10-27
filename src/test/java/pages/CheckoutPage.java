package Pages;

import Pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage extends BasePage {
    private final By FIRSTNAME_FIELD = By.id("first-name");
    private final By LASTNAME_FIELD = By.id("last-name");
    private final By ZIPCODE_FIELD = By.id("postal-code");
    private final By CONTINUE_BUTTON = By.id("continue");
    private final By CANCEL_BUTTON = By.id("cancel");
    private final By ERROR_MESSAGE = By.cssSelector("h3[data-test=error]");

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    public void fillInCheckout(String firstName, String lastName, String zipcode) {
        driver.findElement(FIRSTNAME_FIELD).sendKeys(firstName);
        driver.findElement(LASTNAME_FIELD).sendKeys(lastName);
        driver.findElement(ZIPCODE_FIELD).sendKeys(zipcode);
        driver.findElement(CONTINUE_BUTTON).click();
    }

    public void clickCancel() {
        driver.findElement(CANCEL_BUTTON).click();
    }

    public String getError() {
        return driver.findElement(ERROR_MESSAGE).getText();
    }

    public boolean isOpened() {
        return waitForVisibility(CONTINUE_BUTTON);
    }
}



