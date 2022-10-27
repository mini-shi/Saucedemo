package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutOverviewPage extends BasePage {
    private final By FINISH_BUTTON = By.id("finish");
    private final By ITEM_TOTAL = By.cssSelector(".summary_subtotal_label");
    private final By TAX = By.cssSelector(".summary_tax_label");
    private final By TOTAL_COST = By.cssSelector(".summary_total_label");


    public CheckoutOverviewPage(WebDriver driver) {
        super(driver);
    }

    public String getItemTotal() {
        return driver.findElement(ITEM_TOTAL).getText();
    }

    public String getTax() {
        return driver.findElement(TAX).getText();
    }

    public String getTotalCost() {
        return driver.findElement(TOTAL_COST).getText();
    }

}
