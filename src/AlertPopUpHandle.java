import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class AlertPopUpHandle {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver  = new FirefoxDriver();
        driver.get("https://nxtgenaiacademy.com/alertandpopup");
        driver.findElement(By.name("alertbox")).click();
        Thread.sleep(5000);
        Alert alert = driver.switchTo().alert();
        System.out.println(alert.getText());
        String text = alert.getText();
        if(text.equals("I am an alert box!")) {
            System.out.println("Correct alert message");
        }
        else {
            System.out.println("Incorrect alert message");
        }
        alert.accept();
    }
}