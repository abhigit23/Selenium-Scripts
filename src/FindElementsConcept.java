import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FindElementsConcept {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new FirefoxDriver();

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        driver.get("https://mozilla.com");

        // 1. Get the total counts of links on the page
        // find elements
        List <WebElement> linkList =  driver.findElements(By.tagName("a")); // all the links are represented by <a> tag

        // size of list
        System.out.println("Total no. of links = " + linkList.size());

        for(int i = 0; i<linkList.size(); i++) {
        String linkText = linkList.get(i).getText();
        System.out.println(linkText);
        
        }
    }
}