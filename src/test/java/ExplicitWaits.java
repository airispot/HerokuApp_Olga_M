import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ExplicitWaits extends BaseTest  {
    @BeforeMethod
    public void navigate() {
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
    }
    @Test
    public void LoadingTest () {

        WebElement startButton = driver.findElement(By.cssSelector("div#start button"));
        WebElement textBox = driver.findElement(By.cssSelector("div#finish h4"));


        wait.until(ExpectedConditions.visibilityOf(textBox));
        String actualText = textBox.getText();
        Assert.assertEquals(actualText, "Hello World!");
    }
@Test
    public void LoadingTestSecond () {

        WebElement startButtonSecond = driver.findElement(By.cssSelector("div#start button"));
        WebElement textBoxSecond = driver.findElement(By.cssSelector("div#finish h4"));
        startButtonSecond.click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div#floading")));
        String actualText = textBoxSecond.getText();
        Assert.assertEquals(actualText, "Hello World!");
    }



}


