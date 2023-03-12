import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class SelectCalendarByJS {
    public static void main(String[] args) throws InterruptedException{
        FirefoxOptions profile = new FirefoxOptions();
        profile.addPreference("geo.prompt.testing", true);
        profile.addPreference("geo.prompt.testing.allow", true);
        WebDriver driver = new FirefoxDriver(profile);
        
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        driver.get("https://www.makemytrip.com/");
        WebElement date = driver.findElement(By.xpath("//label[@for='departure']"));
        date.click();
        Thread.sleep(3000);
        String dateVal = "Fri May 05 2023";
        selectDateByJS(driver, dateVal);


    }

    public static void selectDateByJS(WebDriver driver, String dateVal) {
        JavascriptExecutor js = ((JavascriptExecutor)driver);
        js.executeScript("arguments[0].click();", driver.findElement(By.xpath("//div[@class='DayPicker-Day' and @aria-label='"+dateVal+"']")));

    }
}
