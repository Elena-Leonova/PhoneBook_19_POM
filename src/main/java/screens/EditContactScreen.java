package screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class EditContactScreen extends BaseScreen {
    public EditContactScreen(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    @FindBy(id = "com.sheygam.contactapp:id/inputName")
    MobileElement inputName;
    @FindBy(id = "com.sheygam.contactapp:id/inputLastName")
    MobileElement inputLastName;
    @FindBy(id = "com.sheygam.contactapp:id/inputEmail")
    MobileElement inputEmail;
    @FindBy(id = "com.sheygam.contactapp:id/inputPhone")
    MobileElement inputPhone;
    @FindBy(id = "com.sheygam.contactapp:id/inputAddress")
    MobileElement inputAddress;
    @FindBy(id = "com.sheygam.contactapp:id/inputDesc")
    MobileElement inputDesc;
    @FindBy(id = "com.sheygam.contactapp:id/createBtn")
    MobileElement createBtn;

    @FindBy(xpath = "//*[@resource-id='com.sheygam.contactapp:id/updateBtn']")
    MobileElement updateBtn;


    public ContactListScreen submitEditContactForm() {
        updateBtn.click();
        return new ContactListScreen(driver);
    }


    public EditContactScreen updateName(String text) {
        waitElement(inputName, 5);
        type(inputName, text);
        return this;
    }


}
