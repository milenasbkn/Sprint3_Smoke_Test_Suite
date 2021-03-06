package Sprint3.tests;

import Sprint3.util.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Tasks_Tab {

    WebDriver driver;
    String browserType = "chrome";
    //Truck driver Credentials
    String URL = "https://login2.nextbasecrm.com/";
    String userName = "helpdesk28@cybertekschool.com";
    String password = "UserUser";

    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver(browserType);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get(URL);
        driver.findElement(By.xpath("//input[@name='USER_LOGIN']")).sendKeys(userName);
        driver.findElement(By.xpath("//input[@name='USER_PASSWORD']")).sendKeys(password);
        driver.findElement(By.xpath("//input[@type='submit']")).click();
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void click_More_forTaskdetails() throws InterruptedException {

        // navigates to Task tab and click
        WebElement testButton = driver.findElement(By.xpath("//span[.='Task']/span[1]"));
        testButton.click();

        // user clicks on More to reveal more options
        WebElement moreButton = driver.findElement(By.xpath("//div[@class='task-additional-alt-more']"));
        Thread.sleep(2000);
        moreButton.click();

    }


}
