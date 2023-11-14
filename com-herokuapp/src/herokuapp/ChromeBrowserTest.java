package herokuapp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Project-3 - ProjectName : com-herokuapp
 * BaseUrl = http://the-internet.herokuapp.com/login
 * 1. Setup chrome browser.
 * 2. Open URL.
 * 3. Print the title of the page.
 * 4. Print the current url.
 * 5. Print the page source.
 * 6. Enter the email to email field.
 * 7. Enter the password to password field.
 * 8. Click on Login Button.
 * 9. Print the current url.
 * 10. Refresh the page.
 * 11. Close the browser.
 */
public class ChromeBrowserTest {

    public static void main(String[] args) throws InterruptedException {
        String baseUrl = "http://the-internet.herokuapp.com/login";

        //1. Setup Chrome Browser
        WebDriver driver = new ChromeDriver();

        //2. Open URL
        driver.get(baseUrl);
        //3. Print the title of the page
        System.out.println("The Title of the page: "+driver.getTitle());

        //4. Print the Current URL
        System.out.println("The Current URL: "+driver.getCurrentUrl());

        //5. Print the Page Source
        System.out.println("The Page Source: "+driver.getPageSource());

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
        System.out.println("The Current URL: "+driver.getCurrentUrl());
        //10. Refresh the page
        driver.navigate().refresh();
        Thread.sleep(5000);
        //11. close the Browser
        driver.quit();
    }
}
