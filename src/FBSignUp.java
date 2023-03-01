import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class FBSignUp {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.facebook.com/signup");

        driver.findElement(By.name("firstname")).sendKeys("Gajraj");
        driver.findElement(By.name("lastname")).sendKeys("Singh");
        driver.findElement(By.name("reg_email__")).sendKeys("gutkahaari@gmail.com");
        driver.findElement(By.cssSelector("#password_step_input")).sendKeys("gutkahaariGajraj");
        Select day = new Select(driver.findElement(By.id("day")));
        day.selectByValue("1");
        Select month = new Select(driver.findElement(By.id("month")));
        month.selectByVisibleText("Dec");
        Select year = new Select(driver.findElement(By.cssSelector("#year")));
        year.selectByValue("2000");
        driver.findElement(By.className("_5k_3")).click();
        driver.findElement(By.name("reg_email_confirmation__")).sendKeys("gutkahaari@gmail.com");
        driver.findElement(By.name("websubmit")).click();
    }
}