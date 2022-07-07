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

import java.util.List;


public class Checkbox {
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
        driver.get("http://the-internet.herokuapp.com/checkboxes");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
     @Test
        public void selectCheckBoxTest () throws InterruptedException {


         WebElement CheckBoxA = driver.findElement(By.cssSelector("[type=checkbox]:nth-child(1)"));

         System.out.println("Chekbox1"+CheckBoxA.isSelected());
         Assert.assertFalse(driver.findElement(By.cssSelector("[type=checkbox]:nth-child(1)")).isSelected());
         CheckBoxA.click();
         Assert.assertTrue(driver.findElement(By.cssSelector("[type=checkbox]:nth-child(1)")).isSelected());


         WebElement CheckBoxB = driver.findElement(By.cssSelector("[type=checkbox]:nth-child(3)"));
         System.out.println("Chekbox2"+CheckBoxB.isSelected());
         Assert.assertTrue(driver.findElement(By.cssSelector("[type=checkbox]:nth-child(3)")).isSelected());
         CheckBoxB.click();
         Assert.assertFalse(driver.findElement(By.cssSelector("[type=checkbox]:nth-child(3)")).isSelected());



        softAssert.assertAll();

     }}

