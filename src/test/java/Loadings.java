import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Loadings extends BaseTest {



        @BeforeMethod public void navigate() {
            driver.get("https://the-internet.herokuapp.com/dynamic_controls");}

        @Test
          public void SecondLoadingTest (){


        WebElement AcheckBox = driver.findElement(By.id("checkbox"));
        AcheckBox.isSelected();
        Assert.assertTrue(driver.findElement(By.id("checkbox")).isSelected());

        WebElement AddButton=driver.findElement(By.cssSelector("[type=button]"));
        AddButton.click();

        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div#loading")));

        // wait.until(ExpectedConditions.stalenessOf(final WebElement AcheckBox);
        String actualText=AddButton.getText();
        Assert.assertEquals(actualText,"It's gone!");

        }
};
         //    @Test
   //          public void LoadingEnable (){};