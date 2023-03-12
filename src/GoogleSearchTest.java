import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class GoogleSearchTest {
    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        driver.get("https://google.co.in");
        driver.findElement(By.xpath("//input[@title='Search']")).sendKeys("testing");

        // Using Dynamic Custom Xpath
        List <WebElement> list = driver.findElements(By.xpath("//ul[@role='listbox']//li/descendant::div[@class='lnnVSe']"));
        System.out.println("Total no. of suggestions on search are: " + list.size());

        for(int i=0; i<list.size(); i++) {
            System.out.println(list.get(i).getText());
            if(list.get(i).getText().contains("testing of hypothesis")) {
                list.get(i).click();
                break;
            }
        }
    }
}
