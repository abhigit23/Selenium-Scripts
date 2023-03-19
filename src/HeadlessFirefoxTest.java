import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class HeadlessFirefoxTest {
    public static void main(String[] args) throws InterruptedException {
        FirefoxOptions options = new FirefoxOptions();
        options.addArguments("--headless");
        WebDriver driver = new FirefoxDriver(options);

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        driver.get("https://magento.softwaretestingboard.com/customer/account/login");
        System.out.println("Title before login --> " +driver.getTitle());
        
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("biwiweh580@wiroute.com");
        driver.findElement(By.name("login[password]")).sendKeys("Biwiweh580");

        Thread.sleep(2000);

        driver.findElement(By.xpath("//button[@class='action login primary']")).click();
        System.out.println("Title after login --> " +driver.getTitle());

    }
}
