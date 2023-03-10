package utils;

import org.openqa.selenium.WebDriver;

public class WindowManager {
    private WebDriver driver;
    public WindowManager(WebDriver driver){
        this.driver=driver;
    }
    public void switchToNewTab(){
        var windows = driver.getWindowHandles();
        windows.forEach(driver.switchTo()::window);
    }
}
