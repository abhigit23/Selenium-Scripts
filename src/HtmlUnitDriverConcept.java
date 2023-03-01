import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class HtmlUnitDriverConcept {
    public static void main(String[] args) {
        WebDriver driver = new HtmlUnitDriver();

        // advantages of HtmlUnitDriver
        // 1. Testing is happening behind the scenes --> no browser is launched
        // 2. Execution of test cases are very fast --> improves performance of the script

        // HtmlUnitDriver is also called
        // --> Ghost Driver
        // --> Headless Browser

        // disadvantages
        // not suitable for Action class --> User actions like mouse movements, double click, drag and drop

        driver.get("https://magento.softwaretestingboard.com/customer/account/login");
        System.out.println("Title of website before login: " + driver.getTitle());

        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("biwiweh580@wiroute.com");
        driver.findElement(By.name("login[password]")).sendKeys("Biwiweh580");
        driver.findElement(By.xpath("//button[@class='action login primary']")).click();

        System.out.println("Title of website after login: " + driver.getTitle());        

    }
}
