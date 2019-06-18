package amazontests;

import core.PocketsCoreAPI;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;

import java.io.IOException;

public class SearchForProductsandCheckout extends PocketsCoreAPI {
    public HomePage homePage;

    @BeforeMethod
    public void init(){
        homePage = PageFactory.initElements(driver,HomePage.class);
    }

    @Test
    public void testLogin() throws IOException {
        homePage.logInAmazon();
        waitFor(2);
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Iphone 7");
        driver.findElement(By.xpath("//*[@id=\"nav-search\"]/form/div[2]/div/input")).click();
        waitFor(2);
    }
}
