
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class CrearGroupDeletionTest extends TestBase {
    @Test
    public void groupDeletionTest (){
        goToGroupsPage();
        selectGroup ();


    }

    public void selectGroup() {
        wd.findElement(By.name("selected[]")).click();
    }


}