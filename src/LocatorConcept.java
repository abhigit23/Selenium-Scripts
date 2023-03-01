import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatorConcept {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://signup.ebay.com/pa/crte?co_partnerId=0&UsingSSL=1&rv4=1&ru=https%3A%2F%2Fwww.ebay.com%2Fmys%2Fhome%3Fsource%3DGBH&signInUrl=https%3A%2F%2Fwww.ebay.com%2Fsignin%3Fsgn%3Dreg%26siteid%3D0%26co_partnerId%3D0%26UsingSSL%3D1%26rv4%3D1%26ru%3Dhttps%253A%252F%252Fwww.ebay.com%252Fmys%252Fhome%253Fsource%253DGBH");

        // // 1. xpath - absolute xpath shouldn't be used, relative xpath should be used always
        // driver.findElement(By.xpath("//input[@id='businessName']")).sendKeys("Tom");
        // driver.findElement(By.xpath("//input[@id='businessEmail']")).sendKeys("abc@gmail.com");
        // driver.findElement(By.xpath("//input[@id='bizPassword']")).sendKeys("xyz@abc");

        // // 2. id
        // driver.findElement(By.id("businessName")).sendKeys("Thomas");
        // driver.findElement(By.id("businessEmail")).sendKeys("xyz@gmail.com");
        // driver.findElement(By.id("bizPassword")).sendKeys("abc@xyz");

        // 3. name
        driver.findElement(By.name("businessName")).sendKeys("Jerry");
        driver.findElement(By.name("businessEmail")).sendKeys("ijk@gmail.com");
        // driver.findElement(By.name("bizPassword")).sendKeys("trash@gmail.com");

        // // 4. linkText - only for links
        // driver.findElement(By.linkText("Sign in")).click();

        // // 5. partialLinkTest - only for links, not useful
        // driver.findElement(By.partialLinkText("Payments")).click();

        // 6. CSS Selector
        driver.findElement(By.cssSelector("#bizPassword")).sendKeys("ebaywebsite@gmail.com");

        // 7. Class Name - not recommended
        driver.findElement(By.className("form-action")).click();
    }
}
