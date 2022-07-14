import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


public class FileUpload extends BaseTest {

    @BeforeMethod
    public void navigate() {
        driver.get("http://the-internet.herokuapp.com/notification_message_rendered");
    }


  @Test
public void fileUpTest () {
      WebElement fileInput = driver.findElement(By.id("file-upload"));
      fileInput.sendKeys(System.getProperty("user.dir") + "/src/test/resources/download.jpeg");
      WebElement UpButton = driver.findElement(By.id("file-submit"));
      UpButton.click();
  }

}
