import java.time.Duration;
import java.util.Calendar;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CalendarSelectDate {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new FirefoxDriver();

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        String dateTime ="12/07/2014 2:00 PM";


        driver.get("https://demos.telerik.com/kendo-ui/datetimepicker/index");
        WebElement selectDate = driver.findElement(By.xpath("//button[@aria-label='Open the date view']"));
        selectDate.click();

        WebElement prevLink = driver.findElement(By.xpath("//span[@class='k-icon k-i-calendar k-button-icon']"));
        WebElement midLink = driver.findElement(By.xpath("//a[@id='nav-up']"));
        WebElement nextLink = driver.findElement(By.xpath("//span[@class='k-icon k-i-arrow-60-right']"));

        String date_dd_MM_yyyy[] = (dateTime.split(" ")[0]).split("/");
        int yearDiff = Integer.parseInt(date_dd_MM_yyyy[2]) - Calendar.getInstance().get(Calendar.YEAR);

        midLink.click();

        if(yearDiff!=0){

            if(yearDiff>0){
                for(int i=0;i< yearDiff;i++){
                    System.out.println("Year Diff->"+i);
                    nextLink.click();
                }
           }

            else if(yearDiff<0){
                for(int i=0;i< (yearDiff*(-1)); i++){
                    System.out.println("Year Diff->"+i);
                    prevLink.click();
                }
            }
        }
        Thread.sleep(1000);

        List<WebElement> list_AllMonthToBook = driver.findElements(By.xpath("//div[@id='datetimepicker_dateview']//table//tbody//td[not(contains(@class,'k-other-month'))]"));
        list_AllMonthToBook.get(Integer.parseInt(date_dd_MM_yyyy[1])-1).click();
        Thread.sleep(1000);

        List<WebElement> list_AllDateToBook = driver.findElements(By.xpath("//div[@id='datetimepicker_dateview']//table//tbody//td[not(contains(@class,'k-other-month'))]"));
        list_AllDateToBook.get(Integer.parseInt(date_dd_MM_yyyy[0])-1).click();
        Thread.sleep(1000);
    }
}