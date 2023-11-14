package ultimateqa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

/**
 * BaseUrl = https://courses.ultimateqa.com/
 * 1. Setup chrome browser.
 * 2. Open URL.
 * 3. Print the title of the page.
 * 4. Print the current url.
 * 5. Print the page source.
 * 6. Click on ‘Sign In’ link
 * 7. Print the current url
 * 8. Enter the email to email field.
 * 9. Enter the password to password field.
 * 10. Click on Login Button.
 * 11. Navigate to baseUrl.
 * 12. Navigate forward to Homepage.
 * 13. Navigate back to baseUrl.
 * 14. Refresh the page.
 * 15. Close the browser.
 */
public class MultiBrowserTest {

    static String browser = "chrome";
    static String baseUrl = "https://courses.ultimateqa.com/";
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

        //1. Set up Chrome Browser
        //WebDriver driver = new ChromeDriver();
        //2. Open URL
        driver.get(baseUrl);

        //3. Print the Title of the page
        System.out.println("3. The Title of the Page: " + driver.getTitle());
        //4. Print the current URL
        System.out.println("4. The Current URL: " + driver.getCurrentUrl());
        //5. Print the page source
        System.out.println("5. The Page Source: " + driver.getPageSource());
        //6. Click on 'Sign In' link
        WebElement loginLink1 = driver.findElement(By.partialLinkText("Sign"));
        loginLink1.click();
        Thread.sleep(4000);
        //7. Print the current URL
        System.out.println("6. The Current URL: " + driver.getCurrentUrl());
        //8. Enter the email to email field
        WebElement emailField = driver.findElement(By.id("user[email]"));
        emailField.sendKeys("prime123@gmail.com");
        Thread.sleep(4000);
        //9. Enter the password to password field
        WebElement passField = driver.findElement(By.name("user[password]"));
        passField.sendKeys("prime123");
        Thread.sleep(4000);
        //10. Click on Login Button
        WebElement loginLink2 = driver.findElement(By.xpath("(//button[@type='submit'])"));
        loginLink2.click();
        Thread.sleep(4000);
        //11. Navigate to BaseURL
        driver.get(baseUrl);
        Thread.sleep(4000);
        //12. Navigate forward to Homepage
        driver.navigate().to("https://ultimateqa.com/");
        Thread.sleep(4000);
        //13. Navigate back to baseURL
        driver.navigate().back();
        Thread.sleep(4000);
        //14. Refresh the page
        driver.navigate().refresh();
        Thread.sleep(4000);
        //15. Close the browser
        driver.quit();
    }
}
