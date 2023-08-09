package tests;

import config.AppiumConfig;
import models.Auth;
import models.Contact;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import screens.AuthenticationScreen;
import screens.ContactListScreen;


import java.util.Random;

public class AddNewContactTests extends AppiumConfig {
    int i = new Random().nextInt(1000) + 1000;

    @BeforeMethod
    public void preCondition() {

        new AuthenticationScreen(driver)
                .registration(Auth.builder()
                        .email("qa_" + i + "@gmail.com")
                        .password("Mynameislena1!")
                        .build());

    }

    @Test
    public void addNewContactPositive() {
        int b = 1;
        while (b < 7) {
            int i = new Random().nextInt(1000) + 1000;

            Contact contact = Contact.builder()
                    .name("Add_" + i)
                    .lastName("Positive")
                    .email("add_" + i + "@gmail.com")
                    .phone("123456" + i)
                    .address("Haifa")
                    .description("Add_" + i + "_NewPositive")
                    .build();


            new ContactListScreen(driver)
                    .openContactForm()
                    .fillContactForm(contact)
                    .submitContact();

            Assert.assertTrue(

                    new ContactListScreen(driver).checkIsNameInList(contact) &&
                            new ContactListScreen(driver).checkIsPhoneInList(contact)
            );

            b++;
        }

    }
}