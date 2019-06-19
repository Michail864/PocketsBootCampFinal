import core.PocketsCoreAPI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
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

    @Test
    public void testMenu(){
        cnnHomePage.clickOnMenu();
        List<WebElement> elements = new ArrayList<WebElement>();
        elements = driver.findElements(By.className("nav-flyout__section-title"));
        WebElement US = driver.findElement(By.className("nav-flyout__section-title"));
        Actions actions = new Actions(driver);
        actions.moveToElement(US).perform();
        waitFor(2);
        actions.click(US).perform();
        waitFor(2);

    }

}
