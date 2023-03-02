import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DynamicWebTableHandle {
    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        driver.get("https://datatables.net/extensions/select/examples/initialisation/checkbox.html");

        // tbody tr:nth-child(1) td:nth-child(2)
        // tbody tr:nth-child(2) td:nth-child(2)
        // tbody tr:nth-child(3) td:nth-child(2)
        // tbody tr:nth-child(4) td:nth-child(2)

        // String elementName = driver.findElement(By.cssSelector("tbody tr:nth-child(2) td:nth-child(2)")).getText();
        // System.out.println(elementName);

        // String before_css = "tbody tr:nth-child(";
        // String after_css = ") td:nth-child(2)";

        // Method 1 :-
        // for(int i=1; i<=10; i++) {
        //     String name = driver.findElement(By.cssSelector(before_css + i + after_css)).getText();
        //     if(name.contains("Bruno Nash")) {
        //         driver.findElement(By.xpath("//tbody/tr[" + i + "]/td[1]")).click();
        //     }
        // }

        // Method 2 :- Using Dynamic Xpath
        driver.findElement(By.xpath("//td[contains(text(),'Bruno Nash')]//preceding-sibling::td[contains(@class,'  select-checkbox')]")).click();
    }
}
