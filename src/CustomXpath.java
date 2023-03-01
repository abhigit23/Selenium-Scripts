import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CustomXpath {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

        driver.get("https://amazon.in");

        // 1. Basic Xpath
        // driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("Java Tutorial");
        // driver.findElement(By.xpath("//input[@name='field-keywords']")).sendKeys("Java Tutorial");

        // For Dynamic ids
        // 2. Using contains
        // driver.findElement(By.xpath("//input[contains(@class, 'nav-input nav-progressive-attribute')]")).sendKeys("C++ Tutorial");
        // driver.findElement(By.xpath("//input[contains(@class, 'nav-input nav-')]")).sendKeys("C++ Tutorial");

        // 3. Using starts with 
        // driver.findElement(By.xpath("//input[starts-with(@placeholder, 'Search')]")).sendKeys("Python Tutorial");

        // 4. Ends with
        driver.findElement(By.xpath("//input[ends-with(@class, '-attribute')]")).sendKeys("Selenium Tutorial");

        // For Links only
        // 5. Custom Xpath using contains
        driver.findElement(By.xpath("//a[contains(text(), 'My Account')]")).click();
    }
}
