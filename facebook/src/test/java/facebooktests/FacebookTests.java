package facebooktests;

import core.PocketsCoreAPI;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class FacebookTests extends PocketsCoreAPI {

    public Properties loadProperties() throws IOException {
        Properties properties = new Properties();
        InputStream inputStream = new FileInputStream("C:\\Users\\wormi\\IdeaProjects\\PocketsBootcampWebAndMobile\\amazon\\src\\main\\resources\\properties\\pockets.properties");
        properties.load(inputStream);
        inputStream.close();
        return properties;
    }

    //@Test
    public void facebookTestCases() throws IOException {
        Properties prop = loadProperties();
        String login = prop.getProperty("facebook-login");
        String password = prop.getProperty("facebook-password");
        //--- Login to Facebook
        driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys(login);
        driver.findElement(By.xpath("//*[@id=\"pass\"]")).sendKeys(password);
        waitFor(1);
        driver.findElement(By.id("loginbutton")).click();
        waitFor(2);
        //--- Search for people (for example me)
        driver.findElement(By.className("_1frb")).sendKeys("Michail Gore");
        driver.findElement(By.className("_1frb")).sendKeys(Keys.ENTER);
        waitFor(2);
        driver.findElement(By.xpath("//*[@id=\"u_fetchstream_12_1\"]/div/div/div/ul/li[3]/a")).click();
        waitFor(1);
        driver.findElement(By.xpath("//*[@id=\"u_ps_fetchstream_12_3_6\"]/div/div[1]/a/img")).click();
        waitFor(1);

    }
}
