import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Navigations {
    public static void main(String[] args) throws InterruptedException{
        WebDriver driver = new FirefoxDriver();

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        driver.get("https://search.brave.com/");

        driver.navigate().to("https://www.christitus.com");

        // Back and Forward buttons simulation
        Thread.sleep(2000);
        driver.navigate().back();

        Thread.sleep(2000);
        driver.navigate().forward();

        Thread.sleep(2000);
        driver.navigate().back();

        // Refresh the page
        Thread.sleep(2000);
        driver.navigate().refresh();
    }
}
