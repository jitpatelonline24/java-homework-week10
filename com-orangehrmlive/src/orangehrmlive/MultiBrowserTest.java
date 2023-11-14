package orangehrmlive;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;

public class MultiBrowserTest {
    static String browser = "Chrome";
    static String baseUrl = "https://opensource-demo.orangehrmlive.com/";
    static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {
        //1. Setup Browser
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
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4000));
        //3. Print the title of the page
        System.out.println("3. The Title of the page : " + driver.getTitle());
        //4. Print the current Url
        System.out.println("4. The Current URL: " + driver.getCurrentUrl());
        //5. Print the page Source
        System.out.println("5. The Page Source: " + driver.getPageSource());
        //6. Click on 'Forgot your password? link
        WebElement forgotPass = driver.findElement(By.cssSelector("p[class^='oxd-text oxd-text--p orangehrm-login-forgot-header']"));
        forgotPass.click();
        //7. Print the current Url
        System.out.println("7. The Current URL: " + driver.getCurrentUrl());
        //8. Navigate back to the login page
        driver.navigate().back();
        Thread.sleep(5000);
        //9. Refresh the page
        driver.navigate().refresh();
        //10. Enter the email to email field
        WebElement emailField = driver.findElement(By.name("username"));
        emailField.sendKeys("Admin");
        //11. Enter the password to password field
        WebElement passField = driver.findElement(By.name("password"));
        passField.sendKeys("admin123");
        //12. Click on Login Button
        WebElement loginLink = driver.findElement(By.xpath("//button[@type ='submit']"));
        loginLink.click();
        Thread.sleep(5000);
        //13. Close the Browser
        driver.quit();

    }

}
