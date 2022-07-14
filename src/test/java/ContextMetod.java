import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ContextMetod extends BaseTest {

    @BeforeMethod
    public void navigate() {
        driver.get("http://the-internet.herokuapp.com/context_menu");
    }

       @Test
    public void contextTest () throws  InterruptedException {
           WebElement hotSpot = driver.findElement(By.id("hot-spot"));
           Actions actions = new Actions(driver);
           actions.contextClick(hotSpot).build().perform();
           Alert alert = driver.switchTo().alert();
           String alertText = alert.getText();
           System.out.println(alertText);
           alert.accept();
           driver.switchTo().defaultContent();

       }

    @Test
    public void newWindow () throws  InterruptedException {
        driver.get("http://the-internet.herokuapp.com/windows");

        WebElement button = driver.findElement(By.xpath("//a[text()='Click Here']"));
        button.click();

        Set<String> allWindows = driver.getWindowHandles();
        List<String> allWindowsList = allWindows.stream().toList();
        driver.switchTo().window(allWindowsList.get(1));

        driver.switchTo().window(allWindowsList.get(0));



}}

