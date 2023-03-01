import java.time.Duration;
import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class JavaScriptExecuterConcept {
    public static void main(String[] args) throws IOException, InterruptedException{
        WebDriver driver = new FirefoxDriver();

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        driver.get("https://magento.softwaretestingboard.com/customer/account/login");
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("biwiweh580@wiroute.com");
        driver.findElement(By.name("login[password]")).sendKeys("Biwiweh580");

        // execute script --> to execute JavaScript code

        WebElement loginBtn = driver.findElement(By.xpath("//button[@class='action login primary']")); // login button

        flash(loginBtn, driver); // highlight the element

        drawBorder(loginBtn, driver); // draw a border

        // Take ScreenShot and store it as a file format
        File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        
        // now copy the screenshot to desired location using FileHandler.copy method
        FileHandler.copy(src, new File("/home/mystik/Pictures/Bug.png"));

        // generate alert
        // generateAlert(driver, "There is an issue with Login button on Login page");

        // click on any element by using JS executor
        clickElementByJS(loginBtn, driver);

        Thread.sleep(3000);

        // Refresh the page
        // 1. Using Selenium
        driver.navigate().refresh();

        // 2. Using JS executor
        refreshBrowserByJS(driver);

        // get the title of the page by JS
        System.out.println("Website Title: " + getTitleByJS(driver));

        // get the page text
        System.out.println(getInnerText(driver));

        // scroll page down
        // scrollPageDown(driver);

        WebElement subscribe = driver.findElement(By.xpath("//button[@title='Subscribe']")); // subscribe button

        // keep scrolling until the particular element is visible
        scrollIntoView(subscribe, driver);
    }

    public static void flash(WebElement element, WebDriver driver) {
        // JavascriptExecutor js = ((JavaScriptExecutor)driver);
        String bgcolor = element.getCssValue("backgroundColor");
        for(int i=0; i<10; i++) {
            changeColor("rgb(0,300,0)",element,driver);
            changeColor(bgcolor,element,driver);
        }
    }

    public static void changeColor(String color, WebElement element, WebDriver driver) {
        JavascriptExecutor js = ((JavascriptExecutor)driver);
        js.executeScript("arguments[0].style.backgroundColor = '" + color +"'", element);

        try {
            Thread.sleep(20);
        }

        catch(InterruptedException e) {

        }
    }

    public static void drawBorder(WebElement element, WebDriver driver) {
        JavascriptExecutor js = ((JavascriptExecutor)driver);
        js.executeScript("arguments[0].style.border='3px solid red'", element);
    }

    public static void generateAlert(WebDriver driver, String message) {
        JavascriptExecutor js = ((JavascriptExecutor)driver);
        js.executeScript("alert('"+message+"')"); 
    }

    public static void clickElementByJS(WebElement element, WebDriver driver) {
        JavascriptExecutor js = ((JavascriptExecutor)driver);
        js.executeScript("arguments[0].click();", element);
    }

    public static void refreshBrowserByJS(WebDriver driver) {
        JavascriptExecutor js =((JavascriptExecutor)driver);
        js.executeScript("history.go(0)");
    }

    public static String getTitleByJS(WebDriver driver) {
        JavascriptExecutor js = ((JavascriptExecutor)driver);
        String title = js.executeScript("return document.title;").toString();
        return title;
    }

    public static String getInnerText(WebDriver driver) {
        JavascriptExecutor js = ((JavascriptExecutor)driver);
        String innerText = js.executeScript("return document.documentElement.innerText;").toString();
        return innerText;
    }

    public static void scrollPageDown(WebDriver driver) {
        JavascriptExecutor js = ((JavascriptExecutor)driver);
        js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
    }

    public static void scrollIntoView(WebElement element, WebDriver driver) {
        JavascriptExecutor js = ((JavascriptExecutor)driver);
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }
}