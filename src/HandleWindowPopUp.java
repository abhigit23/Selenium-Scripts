import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class HandleWindowPopUp {
    public static void main(String[] args) throws InterruptedException {

        // 1. Alerts - JavaScript PopUp/Alerts -- Alert API --> access, dismiss(method)
        // 2. File Upload PopUp - Browser Button -- (if type -> file, sendKeys(path of the file))
        // 3. Browser Window PopUp - Advertisement PopUp -- Window Handler API --> getWIndowHandles();

        WebDriver driver = new FirefoxDriver();

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        driver.get("https://www.rrc.texas.gov/resource-center/research/gis-viewer/gis-popup-blocker-test");

        driver.findElement(By.xpath("//a[normalize-space()='RUN POPUP TEST']")).click();
        Thread.sleep(2000);

        Set<String> handler = driver.getWindowHandles();
        Iterator<String> it = handler.iterator();
        String parentWindowId = it.next();
        System.out.println("parent window id: " + parentWindowId);

        String childWindowId = it.next();
        System.out.println("child window id: " + childWindowId);

        driver.switchTo().window(childWindowId);
        Thread.sleep(2000);

        System.out.println("Child window title: " + driver.getTitle());
        driver.close();

        driver.switchTo().window(parentWindowId);
        System.out.println("parent window title: " + driver.getTitle());
    }
}
