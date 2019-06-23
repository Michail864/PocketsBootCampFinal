package core;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;


public class PocketsCoreAPI {
    public static WebDriver driver = null;
    public static WebDriverWait wait = null;

    @Parameters({"website" , "isMobile"})
    @BeforeMethod
    public void setUpPocketsDriver(String website, boolean isMobile) throws MalformedURLException {
        if(isMobile == true){
            setupAppium();
        }
        else {
            localDriverSetUp(website);
        }
    }

    public WebDriver localDriverSetUp(String website){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\wormi\\IdeaProjects\\PocketsBootcampWebAndMobile\\generic\\src\\main\\resources\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(website);
        wait = new WebDriverWait(driver, 30);
        return driver;
    }
    public WebDriver setupAppium() throws MalformedURLException {
    DesiredCapabilities caps = new DesiredCapabilities();
    caps.setCapability("deviceName", "PIXEL 2 API 28");
    caps.setCapability("id", "emulator-5554");
    caps.setCapability("platformName", "android");
    caps.setCapability("platformVersion", "9");
    caps.setCapability("app", "C:\\\\Users\\\\wormi\\\\Downloads\\\\Cricbuzz Live Cricket Scores News_v4.5.002_apkpure.com(3).apk");
    caps.setCapability("noReset","false");
    driver = new AppiumDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps);
    wait = new WebDriverWait(driver, 10);
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

    public void clickByIdMob(String locator) {
        driver.findElement(By.id(locator)).click();
    }
}
