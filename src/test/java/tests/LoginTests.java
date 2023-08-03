package tests;

import config.AppiumConfig;
import org.testng.Assert;
import org.testng.annotations.Test;
import screens.SplashScreen;

public class LoginTests extends AppiumConfig {

    @Test
    public void loginPositive(){
        Assert.assertTrue(
    new SplashScreen(driver)
            .gotoAuthenticationScreen()
            .fillEmail("lena.postrash@gmail.com")
            .fillPassword("Mynameislena1!")
            .submitLogin()
            .isContactListActivityPresent()
        );
    }
}
