package edgeClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class private_chat_automation {

    public static void main(String[] args) {
        // Setup ChromeDriver
        System.setProperty("webdriver.chrome.driver", "G:\\Chrome Driver\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        
        // Maximize the browser window to full screen
        driver.manage().window().maximize();
        
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        try {
            // Navigate to Login Page
            driver.get("https://hachnat.stage-carelogix.de/sing-in");

            // Wait for Username, Password and Login button to be visible and enter credentials
            WebElement username = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("credential")));
            WebElement password = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("password")));
            WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.className("ant-btn")));

            username.sendKeys("userName");
            password.sendKeys("Carelogix24!!");
            loginButton.click();

            // Wait for 5 seconds after login
            Thread.sleep(5000);  // 5-second delay after sign-in

            // Wait until logged in (ensure URL contains /chat and that chat page loads)
            wait.until(ExpectedConditions.urlContains("/chat"));

            System.out.println("Logged in successfully!");
            
            Thread.sleep(2000);
            
            
            // Navigate to Chat Page
            driver.get("https://hachnat.stage-carelogix.de/chat");
            
            
            
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div[2]/div/div/main/div/div/div/div[1]/div[2]/div/div/div[11]"))); // Wait for the user element on the chat page

            // Wait for the user element by the provided XPath
            WebElement userElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div[2]/div/div/main/div/div/div/div[1]/div[2]/div/div/div[11]")));
            
            // Click on the user
            userElement.click();
            
            // Wait for 5 seconds after clicking the user
            Thread.sleep(5000);  // 5-second delay after clicking on the user
            
            // Wait for the message input box to be visible
            WebElement messageInput = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div[2]/div/div/main/div/div/div/div[2]/div[3]/section/div[2]/form/div/div/div/div/div/div/input")));
            WebElement sendButton = driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div/main/div/div/div/div[2]/div[3]/section/div[2]/form/button"));
            
            String message = "Hello, this is an automated message!";
            messageInput.sendKeys(message); // Type the message
            Thread.sleep(5000);
            sendButton.click(); // Send the message

            System.out.println("Message sent: " + message);

        } catch (Exception e) {
            System.err.println("An error occurred: " + e.getMessage());
            e.printStackTrace();
        } finally {
            System.out.println("Test completed!");
//            driver.quit(); // Properly close the browser
        }
    }
}
