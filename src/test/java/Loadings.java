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

        WebElement AcheckBox = driver.findElement(By.cssSelector("#checkbox > input[type=checkbox]"));
        AcheckBox.isSelected();

        Assert.assertFalse(driver.findElement(By.cssSelector("#checkbox > input[type=checkbox]")).isSelected());

        WebElement AddButton=driver.findElement(By.cssSelector("#checkbox-example > button"));
        AddButton.click();

        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div#loading")));


        String actualText=AddButton.getText();
        Assert.assertEquals(actualText,"Add");

        }

             @Test
         public void LoadingEnable (){

                 WebElement TextEnable = driver.findElement(By.cssSelector("#input-example > input[type=text]"));
                 TextEnable.isDisplayed();

                  WebElement ButtonEnable = driver.findElement(By.cssSelector("#input-example > button"));
                  ButtonEnable.click();

                wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div#loading")));
                     String actualText=ButtonEnable.getText();
                     Assert.assertEquals(actualText,"Disable");


        }


}