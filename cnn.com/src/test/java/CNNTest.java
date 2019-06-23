import core.PocketsCoreAPI;
import io.appium.java_client.functions.ExpectedCondition;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class CNNTest extends PocketsCoreAPI {

    public CNNHomePage cnnHomePage;

    @BeforeMethod
    public void init(){
        cnnHomePage = PageFactory.initElements(driver, CNNHomePage.class);
    }


    //--Click on all navigation Tabs

    public void testMenu(){
        List<WebElement> elements = new ArrayList<WebElement>();
        elements = driver.findElements(By.className("nav-menu-links__link"));
        System.out.println(elements.size());
        for (int x=0; x <=elements.size(); x++){
            elements = driver.findElements(By.className("nav-menu-links__link"));
            elements.get(x).click();
            driver.get("https://www.cnn.com/");
        }
        }

    //--Read and verify all Trending news on Homepage

    public void readAllTrendingNews(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 250)", "");
        List<WebElement> elementsAux = new ArrayList<WebElement>();
        List<WebElement> elements = new ArrayList<WebElement>();
        elements = driver.findElements(By.className("cd__headline-text"));
        System.out.println(elements.size());
        for (int x=0; x <=elements.size(); x++) {
            elementsAux = driver.findElements(By.className("cd__headline-text"));
            String expectedText = elementsAux.get(x).getText();
            wait.until(ExpectedConditions.elementToBeClickable(elementsAux.get(x)));
            elementsAux.get(x).click();
            js.executeScript("window.scrollBy(0, 1000)", "");
            if(driver.getPageSource().contains(expectedText)){
                System.out.println("News confirmed");
            }
            else{
                System.out.println("News were not confirmed");
            }
            elementsAux.clear();
            driver.get("https://www.cnn.com/");
            waitFor(3);

        }
    }

    //---Search for news

    @Test
    public void serachForNewsTest(){
        cnnHomePage.searchButtonClickandSendkeys("Trump");
        String expectedText = "Trump";
        waitFor(2);
        if (driver.getPageSource().contains(expectedText)) {
            System.out.println("Search news were confirmed");
        }
        else {
            System.out.println("News were not confirmed");
        }
    }

    }


