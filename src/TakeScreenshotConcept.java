import java.io.File;
import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;

public class TakeScreenshotConcept {
    public static void main(String[] args) throws IOException {
        WebDriver driver = new FirefoxDriver();

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        driver.get("https://search.brave.com");

        // Take screenshot and save as file format
        File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileHandler.copy(src, new File("/home/mystik/Pictures/brave.png"));
    }
}
