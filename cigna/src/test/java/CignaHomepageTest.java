import core.PocketsCoreAPI;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;


public class CignaHomepageTest extends PocketsCoreAPI {

    public CignaHomePage cignaHomePage;
    @BeforeMethod
    public void init(){
        cignaHomePage = PageFactory.initElements(driver, CignaHomePage.class);
    }

    //--- Testing registering an accoinut in cigna

    public void testLoginButton(){
        cignaHomePage.loginPageClick();
        waitFor(2);
        for (String winHandle : driver.getWindowHandles()){
            driver.switchTo().window(winHandle);
        }
        driver.findElement(By.id("register")).click();
        driver.findElement(By.xpath("//*[@id=\"firstname\"]")).sendKeys("Mike");
        driver.findElement(By.xpath("//*[@id=\"lastname\"]")).sendKeys("Gore");
        driver.findElement(By.xpath("//*[@id=\"lastname\"]")).sendKeys(Keys.ENTER);
        Select select = new Select(driver.findElement(By.xpath("//*[@id=\"month\"]")));
        select.selectByIndex(10);
        driver.findElement(By.xpath("//*[@id=\"day\"]")).sendKeys("20");
        driver.findElement(By.xpath("//*[@id=\"year\"]")).sendKeys("1993");
        driver.findElement(By.xpath("//*[@id=\"year\"]")).sendKeys(Keys.ENTER);
        driver.findElement(By.xpath("//*[@id=\"zipcode\"]")).sendKeys("11374");
        driver.findElement(By.xpath("//*[@id=\"zipcode\"]")).sendKeys(Keys.ENTER);
        driver.findElement(By.xpath("/html/body/cg-app-root/cg-registration-layout/cg-register/div/ng-component/form/div/div[1]/div/ul/li[1]/label/input")).click();
        waitFor(2);
    }

    //--- Test click all navigation Tabs ------------------------------------------

    public void clickAllNavTabs(){
        List<WebElement> elements = new ArrayList<WebElement>();
        List<WebElement> elementsAux = new ArrayList<WebElement>();
        elements = driver.findElements(By.className("nav-link"));
        System.out.println(elements.size());
        for (int x=0; x<elements.size(); x++){
            elementsAux = driver.findElements(By.className("nav-link"));
            if(elementsAux.get(x).isDisplayed() == true) {
                elementsAux.get(x).click();
                waitFor(2);
                driver.get("https://www.cigna.com/");
                elementsAux.clear();
            }
        }
        System.out.println("Test passed");
    }

    //--- Search for medical tools and verify them----------------------------------------

    @Test
    public void testSearchFprMedicalTools(){
        cignaHomePage.searchBoxSendKeys("medical tools");
        List<WebElement> medicalTools = new ArrayList<WebElement>();
        medicalTools = driver.findElements(By.className("csng-result-title"));
        for (WebElement medicalTool : medicalTools){
            if (medicalTool.getText().contains("Tools")){
                System.out.println("Item was verified");
            }
            else{
                System.out.println("Item found is not a medical tool");
            }
        }
    }
}
