package screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class ContactListScreen extends BaseScreen{
    public ContactListScreen(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

//    @FindBy(xpath = "//*[@resource-id='com.sheygam.contactapp:id/action_bar']/android.widget.TextView")
//    //*[@resource-id='com.sheygam.contactapp:id/action_bar']/android.widget.TextView
//    MobileElement activityViewText;

    @FindBy(xpath = "//*[@resource-id='com.sheygam.contactapp:id/action_bar']/android.widget.TextView")
    MobileElement activityViewText;
    @FindBy(xpath = "//*[@content-desc='More options']")
    MobileElement moreOptions;

    @FindBy(xpath = "//*[@id='com.sheygam.contactapp:id/add_contact_btn']")
    MobileElement addButton;

    @FindBy(xpath = "//*[@resource-id='com.sheygam.contactapp:id/title']")
    MobileElement logoutButton;

    public boolean isContactListActivityPresent(){
        return shouldHave(activityViewText, "Contact list", 5);
    }



}
