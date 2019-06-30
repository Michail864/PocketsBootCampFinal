import core.PocketsCoreAPI;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CitiTests extends PocketsCoreAPI {

    public CitiHomePage homePage;
    @BeforeClass
    public void init(){
    homePage = PageFactory.initElements(driver, CitiHomePage.class);
    }

    //----Click all navigation tabs---------------------------------
    //----Read all the banking offers-------------------------------
    @Test

    public void testAllNavTabsAndReadAllOffers(){
        String exp = null;
        List<WebElement>navTabs = new ArrayList<WebElement>();
        List<WebElement>navTabsAux = new ArrayList<WebElement>();
        List<WebElement>subNav = new ArrayList<WebElement>();
        List<WebElement>subNavRefresh = new ArrayList<WebElement>();
        JavascriptExecutor js = (JavascriptExecutor)driver;
        Actions actions = new Actions(driver);
        navTabs = driver.findElements(By.className("dropbtn"));
        System.out.println(navTabs.size());

        for (int x =0; x<navTabs.size(); x++){
            navTabsAux = driver.findElements(By.className("dropbtn"));
            subNav = driver.findElements(By.className("mm_subnav"));
            actions.moveToElement(navTabsAux.get(x)).build().perform();
            for(int i=0; i<subNav.size(); i++){
                if(subNav.get(i).isDisplayed()){
                    subNavRefresh.add(subNav.get(i));
                }
            }
            System.out.println("size of subNavRefresh = "+subNavRefresh.size());
            for(int y =0; y<subNavRefresh.size(); y++){
               navTabsAux = driver.findElements(By.className("dropbtn"));
                actions.moveToElement(navTabsAux.get(x)).build().perform();
                subNav = driver.findElements(By.className("mm_subnav"));
                for(int i=0; i<subNav.size(); i++){
                    if(subNav.get(i).isDisplayed()==true){
                        subNavRefresh.add(subNav.get(i));
                    }
                }
                exp = subNavRefresh.get(y).getText();
                subNavRefresh.get(y).click();
                waitFor(2);
                js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
                if (driver.getPageSource().contains(exp)) {
                    System.out.println(exp+ " link was verified");
                }
                else{
                    System.out.println(exp+ " link was not verified");
                }
                driver.navigate().back();
                subNav.clear();
                subNavRefresh.clear();
                waitFor(2);
                navTabsAux.clear();
            }
                navTabsAux.clear();
                waitFor(2);
        }

        }
    }


