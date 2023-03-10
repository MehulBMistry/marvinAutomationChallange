package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class ProductDetailPage {
    private WebDriver driver;
    private By getUnitPrice = By.cssSelector(".sc-product-price");
    private By addToCartButton = By.id("add-to-cart-button");
    private By selectSize = By.id("native_dropdown_selected_size_name");
    private By goToCartButton = By.id("sw-gtc");

    public ProductDetailPage(WebDriver driver) {
        this.driver = driver;
    }

    public Select findSize() {
        return new Select(driver.findElement(selectSize));
    }

    public void SelectSize(String size) {
        findSize().selectByVisibleText(size);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void clickAddToCart() {
        driver.findElement(addToCartButton).click();
    }

    public CartPage clickGoToCart() {
        driver.findElement(goToCartButton).click();
        return new CartPage(driver);
    }
}
