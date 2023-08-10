package tests;

import config.AppiumConfig;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import screens.ContactListScreen;
import screens.SplashScreen;

import java.util.Random;


public class EditContactTests extends AppiumConfig {
    int i = new Random().nextInt(1000) + 1000;
    @BeforeClass
    public void preCondition(){
        new SplashScreen(driver)
                .gotoAuthenticationScreen()
                .fillEmail("lena.postrash@gmail.com")
                .fillPassword("Mynameislena1!")
                .submitLogin();
    }

    @Test
    public void editOneContact(){
        String text = "Update_" + i;
        new ContactListScreen(driver)
                .updateOneContact()
                .updateName(text)
                .submitEditContactForm()
                .isContactContains(text);
    }
}
