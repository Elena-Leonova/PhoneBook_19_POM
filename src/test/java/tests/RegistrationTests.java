package tests;

import config.AppiumConfig;
import models.Auth;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import screens.AuthenticationScreen;
import screens.ContactListScreen;
import screens.SplashScreen;

import java.util.Random;

public class RegistrationTests extends AppiumConfig {
    int i = new Random().nextInt(1000) + 1500;

    @Test
    public void registrationPositive() {
        Assert.assertTrue(
                new AuthenticationScreen(driver)
                        .fillEmail("auto" + i + "@gmail.com")
                        .fillPassword("Mynameislena1!")
                        .submitRegistration()
                        .isContactListActivityPresent()
        );
        new ContactListScreen(driver).logout();
    }

    @Test
    public void registrationPositiveModel() {
        int i = new Random().nextInt(1000) + 1500;
        Assert.assertTrue(
                new AuthenticationScreen(driver)
                        .registration(Auth.builder()
                                .email("auto" + i + "@gmail.com")
                                .password("Mynameislena1!")
                                .build())
                        .isContactListActivityPresent()
        );
        new ContactListScreen(driver).logout();
    }

    @Test
    public void registrationNegativeWrongEmail() {

        new AuthenticationScreen(driver)
                .fillEmail("auto" +  i + "gmail.com")
                .fillPassword("Mynameislena1!")
                .submitRegistrationNegative()
                .isErrorMessageHasText("{username=must be a well-formed email address}");

    }

    @Test
    public void registrationNegativeWrongPassword() {

        new AuthenticationScreen(driver)
                .fillEmail("auto" + i + "@gmail.com")
                .fillPassword("Mynameislena1")
                .submitRegistrationNegative()
                .isErrorMessageHasText("{password= At least 8 characters; Must contain at least 1 uppercase letter, 1 lowercase letter, and 1 number; Can contain special characters [@$#^&*!]}");


    }

    @AfterMethod
    public void postCondition() {

         new SplashScreen(driver);
    }
}
