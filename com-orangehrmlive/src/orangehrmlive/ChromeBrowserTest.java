package orangehrmlive;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * BaseUrl = https://opensource-demo.orangehrmlive.com/
 * 1. Setup chrome browser.
 * 2. Open URL.
 * 3. Print the title of the page.
 * 4. Print the current url.
 * 5. Print the page source.
 * 6. Click on ‘Forgot your password?’ link.
 * 7. Print the current url.
 * 8. Navigate back to the login page.
 * 9. Refresh the page.
 * 10. Enter the email to email field.
 * 11. Enter the password to password field.
 * 12. Click on Login Button.
 * 13. Close the browser.
 */
public class ChromeBrowserTest {

public static void main(String[] args) throws InterruptedException {

        String baseUrl = "https://opensource-demo.orangehrmlive.com/";

        WebDriver driver = new ChromeDriver();
        //1. Set up Chrome Browser

        //2. Open URL
        driver.get(baseUrl);
        //3. Print the title of the page
        System.out.println("3. The Title of the page : " + driver.getTitle());
        //4. Print the current Url
        System.out.println("4. The Current URL: " + driver.getCurrentUrl());
        //5. Print the page Source
        System.out.println("5. The Page Source: " + driver.getPageSource());
        //6. Click on 'Forgot your password? link
        WebElement forgotPass = driver.findElement(By.cssSelector("p[class^='oxd-text oxd-text--p orangehrm-login-forgot-header']"));
        forgotPass.click();
        Thread.sleep(5000);
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
        WebElement loginLink = driver.findElement(By.className("oxd-button oxd-button--medium oxd-button--main orangehrm-login-button"));
        loginLink.click();
        Thread.sleep(5000);
        //13. Close the Browser
        driver.quit();

    }
}