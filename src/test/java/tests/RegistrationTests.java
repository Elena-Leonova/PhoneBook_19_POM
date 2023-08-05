package tests;

import config.AppiumConfig;
import org.testng.Assert;
import org.testng.annotations.Test;
import screens.SplashScreen;

import java.util.Random;

public class RegistrationTests extends AppiumConfig {

    @Test
    public void registrationPositive(){
        int i = new Random().nextInt(1000) + 1000;
        Assert.assertTrue(
        new SplashScreen(driver)
                .gotoAuthenticationScreen()
                .fillEmail("auto" + i + "@gmail.com")
                .fillPassword("Mynameislena1!")
                .submitRegistration()
                .isContactListActivityPresent()
        );
    }

}
