import core.PocketsCoreAPI;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CignaHomePage extends PocketsCoreAPI {

    @FindBy (xpath = "//*[@id=\"includes-content\"]/div[1]/nav[2]/div/ul/li[2]/a")
    public WebElement loginButton;

    @FindBy (xpath = "//*[@id=\"csng-search-header\"]/search-header-bar/form/div/cigna-typeahead/input")
    public WebElement searchBox;



    public void loginPageClick(){
        loginButton.click();
    }

    public void searchBoxSendKeys(String keys){
        searchBox.sendKeys(keys);
        searchBox.sendKeys(Keys.ENTER);
    }

}
