package screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import models.Contact;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ContactListScreen extends BaseScreen {
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

    @FindBy(id = "com.sheygam.contactapp:id/add_contact_btn")
    MobileElement addButton;

    @FindBy(xpath = "//*[@resource-id='com.sheygam.contactapp:id/title']")
    MobileElement logoutButton;

    @FindBy(xpath = "//*[@resource-id='com.sheygam.contactapp:id/rowName']")
    List<MobileElement> names;

    @FindBy(xpath = "//*[@resource-id='com.sheygam.contactapp:id/rowPhone']")
    List<MobileElement> phones;

    public boolean isContactListActivityPresent() {
        return shouldHave(activityViewText, "Contact list", 5);
    }

    public AuthenticationScreen logout() {
        moreOptions.click();
        logoutButton.click();
        return new AuthenticationScreen(driver);
    }

    public AddNewContactScreen openContactForm() {
        // waitElement(addButton, 10);
        if (isDisplayedWithException(addButton)) {
            addButton.click();
        }
        return new AddNewContactScreen(driver);
    }

    public boolean checkIsNameInList(Contact contact) {

        for (MobileElement element : names) {
            String[] array = element.getText().split(" ");
            if (array[0].equals(contact.getName())) {
                return true;
            }
        }
        return false;
    }

    public boolean checkIsPhoneInList(Contact contact) {

        for (MobileElement element : phones) {
            String[] array = element.getText().split(" ");
            if (array[0].equals(contact.getPhone())) {
                return true;
            }
        }
        return false;
    }

}
