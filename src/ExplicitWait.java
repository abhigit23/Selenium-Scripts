import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWait {
    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        driver.get("https://magento.softwaretestingboard.com/customer/account/login");
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("biwiweh580@wiroute.com");
        driver.findElement(By.name("login[password]")).sendKeys("Biwiweh580");
        
        clickOn(driver, driver.findElement(By.xpath("//button[@class='action login primary']")), Duration.ofSeconds(20));

    }

    public static void clickOn(WebDriver driver, WebElement locator, Duration timeout) {
        new WebDriverWait(driver, timeout)
        .ignoring(StaleElementReferenceException.class)
        .until(ExpectedConditions.elementToBeClickable(locator));
        locator.click(); 
    }
}


