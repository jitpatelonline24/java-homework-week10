package browsertesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;

public class MultiBrowserTest {
    static String browser = "chrome";
    static String baseUrl = "https://demo.nopcommerce.com/";
    static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {
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
        //2. Open the URL into Browser
        driver.get(baseUrl);
        //3. Print the title of the Page
        String title = driver.getTitle();
        System.out.println("3. The Title of the Page: " + title);
        driver.manage().window().maximize();

        //4. Print tje current URL
        System.out.println("4. The Current URL: " + driver.getCurrentUrl());
        //5. Print the page source
        System.out.println("5. The Page Source: " + driver.getPageSource());
        Thread.sleep(5000);
        //6. Navigate to URL “https://demo.nopcommerce.com/login?returnUrl=%2F”
        String loginUrl = "https://demo.nopcommerce.com/login?returnUrl=%2F";
        driver.navigate().to(loginUrl);
        //7. Print the current URL
        System.out.println("7. Get Current URL: " + driver.getCurrentUrl());
        //8. Navigate back to the home page
        driver.navigate().back();
        System.out.println("8. Navigate back to home page: " + driver.getCurrentUrl());
        //9. Navigate to the login page
        WebElement loginLink = driver.findElement(By.linkText("Log in"));
        loginLink.click();
        //10. Print the current Url
        System.out.println("10. Print the Current URL: " + driver.getCurrentUrl());
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //11. Refresh the page
        driver.navigate().refresh();
        //12. Enter the email to email field
        WebElement emailField = driver.findElement(By.id("Email"));
        emailField.sendKeys("Prime123@gmail.com");
        //13. Enter the password to password field
        WebElement passField = driver.findElement(By.name("Password"));
        passField.sendKeys("Password");
        //14. Click on Login Button
        WebElement loginClick = driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/div[1]/div[2]/form/div[3]/button"));
        loginClick.click();
        Thread.sleep(5000);
        //15. Close the Browser
        driver.quit();


    }

}
