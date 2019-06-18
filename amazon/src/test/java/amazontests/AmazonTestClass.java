package amazontests;

import core.PocketsCoreAPI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AmazonTestClass extends PocketsCoreAPI {

    public HomePage homePage;

    @BeforeMethod
    public void init(){
        homePage = PageFactory.initElements(driver,HomePage.class);
    }

  //  @Test (priority = 1)
    public void testLogin() throws IOException {
        homePage.logInAmazon();
    }

 //   @Test (priority = 2)
    public void testShoppingCart() throws IOException {
        waitFor(2);
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Iphone 7");
        driver.findElement(By.xpath("//*[@id=\"nav-search\"]/form/div[2]/div/input")).click();
        waitFor(2);
        driver.findElement(By.xpath("//*[@id=\"search\"]/div[1]/div[2]/div/span[3]/div[1]/div[1]/div/div/div/div/div/div[2]/div[1]/div/div/span/a/div/img")).click();
        waitFor(2);
        driver.findElement(By.xpath("//*[@id=\"add-to-cart-button\"]")).click();
        waitFor(2);
        driver.findElement(By.xpath("//*[@id=\"hlb-ptc-btn-native\"]")).click();
        waitFor(1);
    }

 //   @Test (priority = 3)
    public void searchItemsAndVerifyThem(){
        waitFor(2);
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Iphone 7");
        driver.findElement(By.xpath("//*[@id=\"nav-search\"]/form/div[2]/div/input")).click();
        waitFor(2);
        List<WebElement> elements = new ArrayList<WebElement>();
        elements = driver.findElements(By.className("sg-col-inner"));
        for(WebElement element : elements){
            if(element.getText().contains("IPhone 7")){
                System.out.println("Item verified");
            }
            else {
                System.out.println("Item was not verified");
            }
        }
    }
}
