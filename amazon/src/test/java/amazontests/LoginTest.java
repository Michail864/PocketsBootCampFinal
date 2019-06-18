package amazontests;

import core.PocketsCoreAPI;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;

import java.io.IOException;
import java.util.Properties;

public class LoginTest extends PocketsCoreAPI {
    public HomePage homePage;

    @BeforeMethod
    public void init(){
        homePage = PageFactory.initElements(driver,HomePage.class);
    }

    @Test
    public void testLogin() throws IOException {
        homePage.logInAmazon();
    }
}
