package base;

import com.google.common.io.Files;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.AmazonHomePage;
import utils.WindowManager;

import java.io.File;
import java.io.IOException;

public class BaseTests {
    private WebDriver driver;
    protected AmazonHomePage amazonHomePage;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
    }

    @BeforeMethod
    public void goHome() {
        driver.manage().window().maximize();
        driver.get("https://www.amazon.in");
        amazonHomePage = new AmazonHomePage(driver);
    }

    public WindowManager getWindowManager() {
        return new WindowManager(driver);
    }

    @AfterMethod
    public void getScreenshot(ITestResult result) {
        var camera = (TakesScreenshot) driver;
        File screenshot = camera.getScreenshotAs(OutputType.FILE);
        try {
            Files.move(screenshot, new File("resources/screenshots/" + result.getName() + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

}
