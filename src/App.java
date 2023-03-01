import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.google.com");
        String title = driver.getTitle();
        System.out.println("Website Title: "+ title);
        if(title.equals("Google")) {
            System.out.println("Correct title");
        }
        else {
            System.out.println("Incorrect Title");
        }

        System.out.println(driver.getCurrentUrl());
        driver.quit();
    }
}