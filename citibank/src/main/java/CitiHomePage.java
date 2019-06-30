import core.PocketsCoreAPI;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CitiHomePage extends PocketsCoreAPI {

    @FindBy (id = "register_acc")
    public WebElement signInButton;
    @FindBy (xpath = "//*[@id=\"mm-container\"]/section[1]/div/h3/a")
    public WebElement chooseCreditLink;
    @FindBy (xpath = "//*[@id=\"mm-container\"]/section[2]/div/h3/a")
    public WebElement noLateFeesLink;
    @FindBy (xpath = "//*[@id=\"mm-container\"]/section[3]/div/h3/a")
    public WebElement bankYourWayLink;

    public void clickChooseCreditLink(){
        chooseCreditLink.click();
    }
    public void clickNoLateFeesLink(){
        noLateFeesLink.click();
    }
    public void clickBankYourWayLink(){
        bankYourWayLink.click();
    }

}
