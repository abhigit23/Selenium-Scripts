import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragAndDropConcept {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

        driver.get("https://jqueryui.com/droppable");

        driver.switchTo().frame(0); // switch to frame if it's present

        Actions action = new Actions(driver);
        action.clickAndHold(driver.findElement(By.xpath("//div[@id='draggable']")))
        .moveToElement(driver.findElement(By.xpath("//div[@id='droppable']")))
        .release()
        .build()
        .perform();

    }
}
