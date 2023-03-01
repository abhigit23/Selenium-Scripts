import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ReadPropFile {
    static WebDriver driver;
    public static void main(String[] args) throws IOException { 
        Properties prop = new Properties();
        FileInputStream ip = new FileInputStream("/home/mystik/Documents/Selenium/src/config.properties");
        prop.load(ip);

        System.out.println(prop.getProperty("name"));
        System.out.println(prop.getProperty("age"));

        String url = prop.getProperty("URL");

        String browserName = prop.getProperty("browser");
        System.out.println(browserName);

        if(browserName.equals("firefox")) {
            driver = new FirefoxDriver();
        }

        else if(browserName.equals("chrome")) {
            driver = new ChromeDriver();
        }

        driver.get(url);
    }
}
