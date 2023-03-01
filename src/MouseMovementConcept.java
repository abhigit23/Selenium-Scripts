import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseMovementConcept {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

        driver.get("https://magento.softwaretestingboard.com/customer/account/login");
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("biwiweh580@wiroute.com");
        driver.findElement(By.name("login[password]")).sendKeys("Biwiweh580");
        driver.findElement(By.xpath("//button[@class='action login primary']")).click();

        Actions action = new Actions(driver);
        
        Thread.sleep(1000);
        action.moveToElement(driver.findElement(By.linkText("Men"))).build().perform();

        Thread.sleep(1000);
        action.moveToElement(driver.findElement(By.linkText("Tops"))).build().perform();

        Thread.sleep(1000);
        driver.findElement(By.linkText("Hoodies & Sweatshirts")).click();
        
    }
}
