package herokuapp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class MultiBrowserTest {
    static String browser = "chrome";
    static String baseUrl = "http://the-internet.herokuapp.com/login";
    static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {
        //1. set up Browser
        if (browser.equalsIgnoreCase("Chrome")) {
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("Firefox")) {
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("Edge")) {
            driver = new EdgeDriver();
        } else if (browser.equalsIgnoreCase("Safari")) {
            driver = new SafariDriver();
        } else {
            System.out.println("Wrong Browser Name");
        }
        
        //2. Open URL
        driver.get(baseUrl);
        //3. Print the title of the page
        System.out.println("The Title of the page: " + driver.getTitle());

        //4. Print the Current URL
        System.out.println("The Current URL: " + driver.getCurrentUrl());

        //5. Print the Page Source
        System.out.println("The Page Source: " + driver.getPageSource());

        //6/ Enter the Email id to the field
        WebElement emailField = driver.findElement(By.id("username"));
        emailField.sendKeys("Prime123@gmail.com");
        //7. Enter the password to password field
        WebElement passField = driver.findElement(By.name("password"));
        passField.sendKeys("Password");
        Thread.sleep(5000);
        //8. Click on Login Button
        driver.findElement(By.id("login")).click();
        Thread.sleep(5000);
        //9. Print the Current URL
        System.out.println("The Current URL: " + driver.getCurrentUrl());
        //10. Refresh the page
        driver.navigate().refresh();
        Thread.sleep(5000);
        //11. close the Browser
        driver.quit();
    }
}

