import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BootStrapDropBoxHandle {
    public static void main(String[] args) throws InterruptedException{
        WebDriver driver = new FirefoxDriver();

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        driver.get("https://www.jquery-az.com/jquery/demo.php?ex=152.0_1");
        Thread.sleep(3000);

        driver.findElement(By.xpath("//button[@id='btndropdown']")).click();
        Thread.sleep(3000);
        List<WebElement> list = driver.findElements(By.xpath("//ul[contains(@class, 'dropdown-menu')]//li//label"));
        System.out.println(list.size());
        
        // For selecting all the checkboxes/options
        for(int i=0; i<list.size(); i++) {
            list.get(i).click();
        }
    }
        // Selecting HTML option/checkbox
        // for(int i=0; i<list.size(); i++) {
        //     System.out.println(list.get(i).getText());
        //     if(list.get(i).getText().contains("HTML")) {
        //         list.get(i).click();
        //         break;
        //     }
        // }
}
