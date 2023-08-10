package tests;

import config.AppiumConfig;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import screens.ContactListScreen;
import screens.SplashScreen;

public class RemoveContactTests extends AppiumConfig {

    @BeforeClass
    public void preCondition(){
        new SplashScreen(driver)
                .gotoAuthenticationScreen()
                .fillEmail("lena.postrash@gmail.com")
                .fillPassword("Mynameislena1!")
                .submitLogin();
    }

    @BeforeMethod
    public void providerContacts(){
        new ContactListScreen(driver)
                .provideContacts();
    }

    @Test
    public void removeOneContactPositive(){
        new ContactListScreen(driver).removeOneContact().isContactRemoved();
    }

    @Test
    public void removeAllContactsPositive(){
        new ContactListScreen(driver)
                .removeAllContacts()
                .isNoContactsMessage();

    }
}
