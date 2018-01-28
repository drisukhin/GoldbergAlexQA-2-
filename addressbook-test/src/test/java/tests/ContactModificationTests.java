package tests;

import model.ContactData;
import org.testng.annotations.Test;

public class ContactModificationTests extends TestBase {
    @Test
    public void testContactModify(){
        if (!app.contacts().isThereAContact()){
            app.contacts().createContact(new ContactData().wihtFirstname("Alex2")
                    .wihtLastname("Gold2")
                    .wihtNickname("GoldbergAlex2")
                    .wihtCompany("F2")
                    .wihtHome("BR2")
                    .wihtAddress("BR2"));
        }
        app.contacts().selectContact();
        app.contacts().fillContactForm(new ContactData().wihtFirstname("Alex2")
                .wihtLastname("Gold2")
                .wihtNickname("GoldbergAlex2")
                .wihtCompany("F2")
                .wihtHome("BR2")
                .wihtAddress("BR2"));
        app.contacts().confirmContactModification();
    }
}
