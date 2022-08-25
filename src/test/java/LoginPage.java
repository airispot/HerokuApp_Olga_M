import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginPage extends BaseTest {
    @BeforeMethod
    public void navigate() {
        driver.get("https://www.saucedemo.com");}

    @Test
    public void Avtorizka () {

        WebElement login = driver.findElement(By.cssSelector("#user-name"));
        login.sendKeys("standard_user");

        WebElement Pass = driver.findElement(By.id("password"));
        Pass.sendKeys("secret_sauce");

        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();

        Assert.assertTrue(driver.findElement(By.id("shopping_cart_container")).isDisplayed(),
                "should be displayed");

}}
