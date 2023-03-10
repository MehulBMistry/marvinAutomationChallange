package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AmazonHomePage {
    private WebDriver driver;
    private By searchField= By.id("twotabsearchtextbox");
    private By searchButton = By.id("nav-search-submit-button");
    private By firstItemFromList = By.xpath("(//span[@data-component-type='s-search-results']/div/div[@data-component-type='s-search-result'])[2]");
    public AmazonHomePage(WebDriver driver){
        this.driver=driver;
    }
    public void searchItem(String searchText){
        driver.findElement(searchField).sendKeys(searchText);
        driver.findElement(searchButton).click();
    }
    public ProductDetailPage clickOnFirstItemFromSearchList(){
        driver.findElement(firstItemFromList).click();
        return new ProductDetailPage(driver);
    }
}
