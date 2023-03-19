import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class HandleBootStrapDropBoxes {
    public static void main(String[] args) throws InterruptedException{
        WebDriver driver = new FirefoxDriver();

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        driver.get("https://getbootstrap.com/docs/4.0/components/dropdowns");

        WebElement element = driver.findElement(By.xpath("//div[normalize-space()='Single button dropdowns']//a[@aria-label='Anchor']"));
        scrollIntoView(element, driver);

        Thread.sleep(2000);
        driver.findElement(By.id("dropdownMenuButton")).click();
        Thread.sleep(2000);

        List<WebElement> list = driver.findElements(By.xpath("//div[contains(@class, 'dropdown-menu') and (@aria-labelledby='dropdownMenuButton')]//a"));
        System.out.println(list.size());

        for(int i=0; i<list.size(); i++) {
            System.out.println(list.get(i).getText());

            if(list.get(i).getText().equals("Another action")) {
                list.get(i).click();
                break;
            }
        }

    }
    
    public static void scrollIntoView(WebElement element, WebDriver driver) {
        JavascriptExecutor js = ((JavascriptExecutor)driver);
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }
}