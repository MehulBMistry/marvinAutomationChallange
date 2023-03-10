package amazon;

import base.BaseTests;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class AmazonTests extends BaseTests {

    @Test
    public void testSearchAndAddToCart(){
        amazonHomePage.searchItem("dress");
        var productDetailPage = amazonHomePage.clickOnFirstItemFromSearchList();

        getWindowManager().switchToNewTab();
        productDetailPage.SelectSize("XL");
        productDetailPage.clickAddToCart();
        var cartPage = productDetailPage.clickGoToCart();

        System.out.println("Quantity " +cartPage.getQuantity());
        System.out.println("Price " +cartPage.getUnitPrice());
        System.out.println("SubTotal Quantity " +cartPage.getSubTotalQuantity());
        System.out.println("subTotal Amount " +cartPage.getSubTotalAmount());

        assertEquals(cartPage.getQuantity(), cartPage.getSubTotalQuantity() );
        assertEquals((cartPage.getQuantity() * cartPage.getUnitPrice()), cartPage.getSubTotalAmount());

        cartPage.clickProceedToBuy();
    }

}
