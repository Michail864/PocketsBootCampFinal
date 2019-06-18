import core.PocketsCoreAPI;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Videos extends PocketsCoreAPI {
    @FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.view.ViewGroup/android.widget.FrameLayout/android.support.v7.widget.RecyclerView/android.view.ViewGroup[1]/android.support.v7.widget.RecyclerView/android.view.ViewGroup[1]/android.widget.ImageView")
    public WebElement cricLive;
    @FindBy (xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.view.ViewGroup/android.widget.FrameLayout/android.support.v7.widget.RecyclerView/android.view.ViewGroup[1]/android.support.v7.widget.RecyclerView/android.view.ViewGroup[4]/android.widget.ImageView")
    public WebElement pressConf;
    @FindBy (xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.view.ViewGroup/android.widget.FrameLayout/android.support.v7.widget.RecyclerView/android.view.ViewGroup[1]/android.support.v7.widget.RecyclerView/android.view.ViewGroup[3]/android.widget.ImageView")
    public WebElement cricHindi;

    public void clickCricLive(){
        cricLive.click();
        waitFor(2);
    }
    public void clickPressConf(){
        pressConf.click();
        waitFor(2);
    }
    public void clickCricHindi(){
        cricHindi.click();
        waitFor(2);
    }

    public void videosSetUP(){
        waitFor(10);
        clickByIdMob("com.cricbuzz.android:id/tab_home");
        waitFor(2);
        clickByIdMob("com.cricbuzz.android:id/tab_videos");
        waitFor(2);
    }
}
