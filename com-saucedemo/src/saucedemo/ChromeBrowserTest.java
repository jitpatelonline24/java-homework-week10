package saucedemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

/**
 * BaseUrl = https://www.saucedemo.com/
 * 1. Setup chrome browser.
 * 2. Open URL.
 * 3. Print the title of the page.
 * 4. Print the current url.
 * 5. Print the page source.
 * 6. Enter the email to email field.
 * 7. Enter the password to password field.
 * 8. Click on Login Button.
 * 9. Print the current url.
 * 10. Navigate to baseUrl
 * 11. Refresh the page.
 * 12. Close the browser.
 */
public class ChromeBrowserTest {
    static String browser = "Chrome";
    static String baseUrl = "https://www.saucedemo.com/";
    static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {
        //1. set up Chrome Browser
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

        //2. open URL
        driver.get(baseUrl);
        driver.manage().window().maximize();
        //3. Print the Title of the page
        System.out.println("The Title of the page: " + driver.getTitle());
        //4. Print the Current URL
        System.out.println("The Current URL: " + driver.getCurrentUrl());
        //5. Print the page Source
        System.out.println("The Page Source: " + driver.getPageSource());
        //6. Enter the email to email field
        WebElement emailField = driver.findElement(By.id("user-name"));
        emailField.sendKeys("Prime123@gmail.com");
        //7. Enter the password to password field
        WebElement passField = driver.findElement(By.name("password"));
        passField.sendKeys("Password");
        Thread.sleep(4000);
        //8. Click on Login Button
        driver.findElement(By.id("login-button")).click();
        //9. Print the current URL
        System.out.println("The Current URL: " + driver.getCurrentUrl());
        //10. Navigate to baseUrl
        Thread.sleep(5000);
        driver.get(baseUrl);
        Thread.sleep(5000);
        //11. Refresh the page
        driver.navigate().refresh();
        //12. Close the Browser
        driver.quit();


    }
}
