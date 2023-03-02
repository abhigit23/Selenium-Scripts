import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ElementVisibilityTest {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new FirefoxDriver();

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

        // dynamic wait
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        driver.get("https://app.termsfeed.com/profile/register");

        // 1. isDisplayed() method --> applicable for all elements
        boolean b1 = driver.findElement(By.xpath("//button[@class='btn btn-success btn-lg btn-block']")).isDisplayed();
        System.out.println("Is SignUp button available?: " + b1);

        // 2. isEnabled() method
        boolean b2 = driver.findElement(By.xpath("//button[@class='btn btn-success btn-lg btn-block']")).isEnabled();
        System.out.println("SignUp button before filling details: " + b2);

        // Enabling SignUp button by filling the details
        driver.findElement(By.xpath("//input[@placeholder='Email address']")).sendKeys("random@mail.com");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("randomPassword@123");
        driver.findElement(By.id("password2")).sendKeys("randomPassword@123");

        // again check if signup button is enabled or not
        boolean b3 = driver.findElement(By.xpath("//button[@class='btn btn-success btn-lg btn-block']")).isEnabled();
        System.out.println("SignUp buttom after filling details: "+b3);

        driver.navigate().to("https://spiceclub.spicejet.com/signup");

        WebElement submit = driver.findElement(By.xpath("//button[normalize-space()='Submit']"));
        scrollIntoView(submit, driver);

        Thread.sleep(4000);
        
        driver.findElement(By.id("defaultCheck1")).click(); // check the checkbox

        // 3. isSelected() method: only applicable for checkbox, dropdown, radio button
        boolean b4 = driver.findElement(By.id("defaultCheck1")).isSelected();
        System.out.println("Is Checkbox selected?: " + b4);

        // uncheck the checkbox
        driver.findElement(By.id("defaultCheck1")).click(); // uncheck the checkbox

        boolean b5 = driver.findElement(By.id("defaultCheck1")).isSelected();
        System.out.println("Is Checkbox selected?: " + b5);
    }

    // method to scroll to the element using JS Executor
    public static void scrollIntoView(WebElement element, WebDriver driver) {
        JavascriptExecutor js = ((JavascriptExecutor)driver);
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }
}
