import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FrameHandling {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

        // dynamic wait
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        
        driver.get("https://demo.guru99.com/test/guru99home/");
        Thread.sleep(3000);
        // we can't use xpath so tried to find element using css selector
        // driver.findElement(By.cssSelector("img[src='Jmeter720.png']")).click(); // we'll get no such element exception
        
        driver.switchTo().frame("a077aa5e");
        driver.findElement(By.xpath("//body//a//img")).click();
    }
}
