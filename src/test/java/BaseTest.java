import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    protected WebDriver driver;
    protected WebDriverWait wait;


    @BeforeClass
    public void setUp() {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
      //  options.addArguments("--headless");
        driver = new ChromeDriver(options);
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver,10);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

    }
    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
