package core;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.util.concurrent.TimeUnit;


public class PocketsCoreAPI {
    public static WebDriver driver = null;

    @Parameters({"website"})
    @BeforeMethod
    public WebDriver setUpPocketsDriver(String website){
    System.setProperty("webdriver.chrome.driver", "C:\\Users\\wormi\\IdeaProjects\\PocketsBootcampWebAndMobile\\generic\\src\\main\\resources\\chromedriver_win32\\chromedriver.exe");
    driver = new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
    driver.manage().window().maximize();
    driver.get(website);
    return driver;
    }

    public static void waitFor(int sec){
        try {
            Thread.sleep(sec * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void clickByXpath(String locator){
        driver.findElement(By.xpath(locator)).click();
    }

    public static void sendKeysByXpath(String locator, String keys){
        driver.findElement(By.xpath(locator)).sendKeys(keys);
    }

    @AfterMethod
    public void quitDriver(){
      driver.close();
      driver.quit();
    }
}
