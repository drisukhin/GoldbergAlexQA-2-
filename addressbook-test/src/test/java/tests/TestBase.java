package tests;

import model.ContactData;
import model.GroupData;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

public abstract class TestBase {
    FirefoxDriver wd;

    public static boolean isAlertPresent(FirefoxDriver wd) {
        try {
            wd.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    @BeforeClass
    public void setUp(String password, String userName) throws Exception {
        wd = new FirefoxDriver(new FirefoxOptions().setLegacy(true));
        wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        openaddress();
        login("admin", "secret");
    }


    public void openaddress() {
        wd.get("http://localhost/addressbook/");
    }

    public void login(String userName, String password) {
        type(By.name("user"), userName);//для того что бы создать type метод нужно выфделить метод и нажать ctrl+alt+M и назвать его
        type(By.name("pass"), password);
        click(By.xpath("//form[@id='LoginForm']/input[3]"));
    }

    public void type(By locator,String text) {
        click(locator);//ctrl+alt+P и везде в скобках прописать locator
        wd.findElement(locator).clear();
        wd.findElement(locator).sendKeys(text);
    }

    public void goToGroupsPage() {
        click(By.xpath("//*[@href='group.php']"));//кнопка groups
    }

    public void click(By locator) {//чтобы создать этот метод нужно выделить любую строчку с click на конце и нажать Refactor->Extract->Parameter Object
        wd.findElement(locator).click();
    }

    public void fillGreoupForm(GroupData groupData, String userName) {
        type(By.name("group_name"), userName);
        type(By.name("group_header"), userName);
        type(By.name("group_footer"), userName);
    }

    public void iniGroupCreation() {
        click(By.name("new"));
    }

    public void fillGreoupForm(String userName) {
        fillGreoupForm(new GroupData("name", "header", "footer"), userName);
    }

    public void submitGroupCreation() {
        click(By.name("submit"));
    }

    public void returnToGropsPage() {
        click(By.xpath("//*[@href='group.php']"));
    }


   /* public void returnGroup() {
        wd.findElement(By.linkText("group page")).click();
    }*/

    public void clickButtonDeleteGroup() {//удаление группы
        click(By.name("delete"));
    }

    public void selectGroup() {
        click(By.name("selected[]"));
    }


    public void initContactCreation() {
        click(By.xpath("//*[@href='edit.php']"));
    }

    public void fillContactForm(String userName) {
        fillContactForm(new ContactData("Alex", "Goldber", "Goldberalex", "F", "BearSheva", "BearSheba"), userName);
    }

    public void submitContactCreation() {
        click(By.name("submit"));
    }

    @AfterClass
    public void tearDown() {
        wd.quit();
    }

    public void fillContactForm(ContactData contactData, String userName) {
        type(By.name("firstname"), userName);
        type(By.name("lastname"), userName);
        type(By.name("nickname"), userName);
        type(By.name("company"), userName);
        type(By.name("address"), userName);
        type(By.name("home"), userName);
    }

    public void confirmAlert() {
        wd.switchTo().alert().accept();
    }

    public void clickButtonDelete() {
        click(By.xpath("//*[@value='Delete']"));
    }

    public void selectContact() {
        click(By.name("selected[]"));
    }
}