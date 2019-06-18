package pages;

import core.PocketsCoreAPI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class HomePage extends PocketsCoreAPI {

    @FindBy (id = "nav-link-accountList")
    public WebElement signInButton;
    @FindBy (xpath = "//*[@id=nav-cart]")
    public WebElement checkOutCart;
    @FindBy (xpath = "//*[@id=\"twotabsearchtextbox\"]")
    public WebElement searchBox;

    public void clickSignIn(){
        waitFor(2);
        signInButton.click();
        waitFor(2);
    }

    public void clickCheckOutCart(){
        checkOutCart.click();
        waitFor(2);
    }

    public void searchBoxSendKeys(String keys){
        searchBox.sendKeys(keys);
    }

    public Properties loadProperties() throws IOException {
        Properties properties = new Properties();
        InputStream inputStream = new FileInputStream("C:\\Users\\wormi\\IdeaProjects\\PocketsBootcampWebAndMobile\\amazon\\src\\main\\resources\\properties\\pockets.properties");
        properties.load(inputStream);
        inputStream.close();
        return properties;

    }

    public void logInAmazon() throws IOException {
        clickSignIn();
        Properties prop = loadProperties();
        String mail = prop.getProperty("email");
        String password = prop.getProperty("password");
        driver.findElement(By.xpath("//*[@id=\"ap_email\"]")).sendKeys(mail);
        driver.findElement(By.xpath("//*[@id=\"ap_password\"]")).sendKeys(password);
        driver.findElement(By.xpath("//*[@id=\"signInSubmit\"]")).click();
        waitFor(2);
    }

}
