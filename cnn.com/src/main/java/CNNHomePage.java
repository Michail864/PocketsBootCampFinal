import core.PocketsCoreAPI;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CNNHomePage extends PocketsCoreAPI {

    @FindBy (id = "menu")
    public WebElement mainMenu;
    @FindBy(id = "search-input-field")
    public WebElement inputMenu;


    public void clickOnMenu(){
        mainMenu.click();
        waitFor(2);
    }

    public void inputMenuSendKeys(String keys){
        inputMenu.sendKeys(keys);
    }
}
