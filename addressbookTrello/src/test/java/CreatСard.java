import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

import java.util.concurrent.TimeUnit;
import java.util.Date;
import java.io.File;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.*;
import static org.openqa.selenium.OutputType.*;

public class CreatСard {
    FirefoxDriver wd;
    
    @BeforeMethod
    public void setUp() throws Exception {
        wd = new FirefoxDriver(new FirefoxOptions().setLegacy(true));
        wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    
    @Test
    public void CreatСard() {
        openaddress();
        openloginpage();
        login();
        goToProject();
        CreatСardNew();
        returnToProject();
    }

    public void returnToProject() {
        wd.findElement(By.cssSelector("span.header-logo-default")).click();
        wd.findElement(By.xpath("//ul[@class='boards-page-board-section-list']//span[.='Проект 1']")).click();
    }

    public void CreatСardNew() {
        wd.findElement(By.xpath("//div[@id='board']/div[3]/div/div[1]/div[2]/a/span")).click();
        wd.findElement(By.cssSelector("a.js-add-card")).click();
        wd.findElement(By.cssSelector("textarea.list-card-composer-textarea.js-card-title")).clear();
        wd.findElement(By.cssSelector("textarea.list-card-composer-textarea.js-card-title")).sendKeys("Tema");
        wd.findElement(By.xpath("//div[@class='card-composer']/div[2]/div[1]/input")).click();
    }

    public void goToProject() {
        wd.findElement(By.xpath("//ul[@class='boards-page-board-section-list']//span[.='Проект 1']")).click();
    }

    public void login() {
        wd.findElement(By.id("user")).click();
        wd.findElement(By.id("user")).clear();
        wd.findElement(By.id("user")).sendKeys("goldbergalex1981@gmail.com");
        wd.findElement(By.id("password")).click();
        wd.findElement(By.id("password")).clear();
        wd.findElement(By.id("password")).sendKeys("171981zx");
        wd.findElement(By.id("login")).click();
    }

    public void openloginpage() {
        wd.findElement(By.linkText("Log In")).click();
    }

    public void openaddress() {
        wd.get("https://trello.com/");
    }

    @AfterMethod
    public void tearDown() {
        wd.quit();
    }
    
    public static boolean isAlertPresent(FirefoxDriver wd) {
        try {
            wd.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }
}
