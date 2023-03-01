import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class HandleDropBox {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.mozilla.org/en-US/firefox/all/#product-desktop-release");

        // handle dropdown menu
        Select select = new Select(driver.findElement(By.id("select-product")));
        select.selectByVisibleText("Firefox Nightly");
    }
}
