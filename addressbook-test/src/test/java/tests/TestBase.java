package tests;

import applicationManager.ApplicationManager;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public abstract class TestBase {// это мы делаем Refactor+Extract+Replace Inheritance with Delegation

    protected ApplicationManager app = new ApplicationManager(BrowserType.CHROME);

    @BeforeClass
    public void setUp() throws Exception {
        app.start();
    }

    @AfterClass
    public void tearDown() {
        app.stop();
    }

}
