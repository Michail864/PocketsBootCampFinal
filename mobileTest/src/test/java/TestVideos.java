import core.PocketsCoreAPI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;

import java.util.List;

public class TestVideos extends PocketsCoreAPI {
    public Videos videos;

    @BeforeMethod
    public void init(){
        videos = PageFactory.initElements(driver, Videos.class);
    }


    public void testVideosLive(){
        videos.videosSetUP();
        videos.clickCricLive();
        List<WebElement> elements = driver.findElements(By.xpath("(//android.widget.ImageView[@content-desc=\"image\"])"));
        waitFor(2);
        for(WebElement element : elements){
            element.click();
            waitFor(2);
            driver.navigate().back();
        }
    }

    public void testVideosCricHindi(){
        videos.videosSetUP();
        videos.clickCricHindi();
        List<WebElement> elements = driver.findElements(By.xpath("(//android.widget.ImageView[@content-desc=\"image\"])"));
        waitFor(2);
        for(WebElement element : elements){
            element.click();
            waitFor(2);
            driver.navigate().back();
        }
    }

    public void testVideosPressConf(){
        videos.videosSetUP();
        videos.clickPressConf();
        List<WebElement> elements = driver.findElements(By.xpath("(//android.widget.ImageView[@content-desc=\"image\"])"));
        waitFor(2);
        for(WebElement element : elements){
            element.click();
            waitFor(2);
            driver.navigate().back();
        }
    }
}
