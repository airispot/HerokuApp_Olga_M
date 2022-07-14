import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


public class NoMessage {
    WebDriver driver;
    SoftAssert softAssert;

    @BeforeClass
    public void setUp() {
        softAssert = new SoftAssert();
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @BeforeMethod
    public void navigate() {
        driver.get("http://the-internet.herokuapp.com/notification_message_rendered");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }


    @Test
     public void Message() {

        WebElement buttonClick = driver.findElement(By.xpath("//*[@id=\"content\"]/div/p/a"));
        buttonClick.click();



    WebElement MessageA = driver.findElement(By.id("flash"));
    softAssert.assertTrue(MessageA.isDisplayed(), "Message should be displayed");
    String EXPECTED_ERROR_MESSAGE_TEXT = "Action unsuccesful, please try again";
     softAssert.assertEquals(MessageA.getText(),EXPECTED_ERROR_MESSAGE_TEXT,
             "Message should be displayed");

        WebElement buttonClickB = driver.findElement(By.xpath("//*[@id=\"content\"]/div/p/a"));
        buttonClickB.click();

        WebElement MessageB = driver.findElement(By.cssSelector("div#flash.flash.notice"));
         String actualTextB = MessageB.getText();
        Assert.assertEquals(actualTextB, "Action succesful");

} }
