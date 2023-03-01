import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleFileUpload {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://ezgif.com/optimize");
        driver.findElement(By.xpath("//input[@id='new-image']")).sendKeys("/home/mystik/Pictures/mpv-shot0005.png");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//input[@value='Upload!']")).click();
    }
}
