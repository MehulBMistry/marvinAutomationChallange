package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {
    private WebDriver driver;
    private By itemQuantity = By.id("a-autoid-0-announce");
    private By itemPrice = By.xpath("//form[@id='activeCartViewForm']/div[@data-name='Active Items']//div[@class='sc-item-price-block']/p/span");
    private By subTotalQuantity = By.id("sc-subtotal-label-buybox");
    private By subTotalAmount = By.id("sc-subtotal-amount-buybox");
    private By proceedToBuyButton = By.name("proceedToRetailCheckout");

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public int getQuantity() {
        String s = driver.findElement(itemQuantity).getText();
        return Integer.parseInt(s.replaceAll("[\\D]", ""));
    }

    public double getUnitPrice() {
        String s = driver.findElement(itemPrice).getText();
        return Double.parseDouble(s);
    }

    public int getSubTotalQuantity() {
        String s = driver.findElement(subTotalQuantity).getText();
        return Integer.parseInt(s.replaceAll("[\\D]", ""));
    }

    public double getSubTotalAmount() {
        String s = driver.findElement(subTotalAmount).getText();
        return Double.parseDouble(s);
    }

    public void clickProceedToBuy() {
        driver.findElement(proceedToBuyButton).click();
    }
}
