package facebooktests;

import core.PocketsCoreAPI;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class FacebookTests extends PocketsCoreAPI {

    public Properties loadProperties() throws IOException {
        Properties properties = new Properties();
        InputStream inputStream = new FileInputStream("C:\\Users\\wormi\\IdeaProjects\\PocketsBootcampWebAndMobile\\amazon\\src\\main\\resources\\properties\\pockets.properties");
        properties.load(inputStream);
        inputStream.close();
        return properties;
    }

    @Test
    public void facebookTestCases() throws IOException {
        Properties prop = loadProperties();
        String login = prop.getProperty("facebook-login");
        String password = prop.getProperty("facebook-password");

        //--- Login to Facebook--------------------------------------------------------------

        driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys(login);
        driver.findElement(By.xpath("//*[@id=\"pass\"]")).sendKeys(password);
        waitFor(1);
        driver.findElement(By.id("loginbutton")).click();
        waitFor(2);

        //--- Search for people (for example me)-----------------------------------------------

        driver.findElement(By.className("_1frb")).sendKeys("Michail Gore");
        driver.findElement(By.className("_1frb")).sendKeys(Keys.ENTER);
        waitFor(4);

        //--- Click on my profile --------------------------------------------------------------

        driver.findElement(By.cssSelector("#xt_uniq_3 > div > a")).click();
        waitFor(3);
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("window.scrollBy(0,350)", "");
        waitFor(1);

        //--- Like all the pictures on the timeline ---------------------------------------------

        List<WebElement> elements = new ArrayList<WebElement>();
        List<WebElement> elementsAux = new ArrayList<WebElement>();
        elements = driver.findElements(By.className("_2_qm"));
        System.out.println("elements = "+ elements.size());
        int scrollBy = 350;
        for (int x =0; x<elements.size(); x++){

                js.executeScript("window.scrollBy(0," + scrollBy + ")", "");
                try {
                    elementsAux = driver.findElements(By.className("_2_qm"));
                    System.out.println("elementsAux =" + elementsAux.size());
                    elementsAux.get(x).click();
                } catch (IndexOutOfBoundsException e) {
                    System.out.println("Index out of bound right here");
                }
                waitFor(2);
                Actions actions = new Actions(driver);
                actions.moveToElement(driver.findElement(By.xpath("//*[@id=\"photos_snowlift\"]/div[2]/div/div[1]/div[1]/div[1]/div[1]/div[3]/img"))).build().perform();
                WebElement like = driver.findElement(By.xpath("//*[@id=\"fbPhotoSnowliftFeedbackActions\"]/div/div/span[1]/div/div/a"));
                WebElement comment = driver.findElement(By.xpath("//*[@id=\"fbPhotoSnowliftFeedbackActions\"]/div/div/span[2]/a"));
                wait.until(ExpectedConditions.visibilityOf(like));
                like.click();
                waitFor(1);
                comment.click();
                waitFor(2);
                driver.get("https://www.facebook.com/profile.php?id=100008713658965");
                scrollBy = scrollBy + 350;
                elementsAux.clear();
                waitFor(2);

        }

        //--- Send a friend request----------------------------------------------------------------
        driver.findElement(By.className("addButton")).click();
        //#u_ps_fetchstream_7_0_3 > span.addFriendText > a
        waitFor(2);

        //--- send a message -----------------------------------------------------------------------

        driver.findElement(By.id("u_ps_fetchstream_7_1_5")).click();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@id=\"u_0_2n\"]/div/div/div/div"))));
        driver.findElement(By.xpath("//*[@id=\"js_71k\"]/div[4]/div/div")).sendKeys("Hey Mike. The bset pic!");
        driver.findElement(By.xpath("//*[@id=\"js_71k\"]/div[4]/div/div")).sendKeys(Keys.ENTER);
        waitFor(2);
    }
}
