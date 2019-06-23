import core.PocketsCoreAPI;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CNNHomePage extends PocketsCoreAPI {

    @FindBy (id = "menu")
    public WebElement mainMenu;
    @FindBy(id = "search-button")
    public WebElement searchButton;




    public void clickOnMenu(){
        mainMenu.click();
        waitFor(2);
    }

    public void searchButtonClickandSendkeys(String keys){
        searchButton.click();
        driver.findElement(By.id("search-input-field")).sendKeys(keys);
        waitFor(2);
        driver.findElement(By.id("search-input-field")).sendKeys(Keys.ENTER);
    }
}
