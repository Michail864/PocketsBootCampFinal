import core.PocketsCoreAPI;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Matches extends PocketsCoreAPI {
    @FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout[1]/android.widget.HorizontalScrollView/android.widget.LinearLayout/android.support.v7.app.ActionBar.Tab[1]/android.widget.TextView\n")
    public WebElement Live;
    @FindBy (xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout[1]/android.widget.HorizontalScrollView/android.widget.LinearLayout/android.support.v7.app.ActionBar.Tab[2]/android.widget.TextView")
    public WebElement Upcoming;
    @FindBy (xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout[1]/android.widget.HorizontalScrollView/android.widget.LinearLayout/android.support.v7.app.ActionBar.Tab[3]/android.widget.TextView")
    public WebElement Recent;

    public void clickLiveButton(){
        Live.click();
        waitFor(2);
    }
    public void clickUpcoming(){
        Upcoming.click();
        waitFor(2);
    }
    public void clickRecent(){
        Recent.click();
        waitFor(2);
    }
    public void setMatchesUp(){
        waitFor(10);
        clickByIdMob("com.cricbuzz.android:id/tab_home");
        waitFor(2);
        clickByIdMob("com.cricbuzz.android:id/tab_matches");
        waitFor(2);
    }
}
