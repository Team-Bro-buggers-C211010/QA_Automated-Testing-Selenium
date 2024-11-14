package edge_class;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
public class secondClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		System.out.println("Hello World!");
		System.setProperty("webdriver.chrome.driver", "G:\\Chrome Driver\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.iiuc.ac.bd/index.php/login/");
		try {
			WebElement username = driver.findElement(By.id("user_id"));
			WebElement pass = driver.findElement(By.id("user_password"));
			WebElement login = driver.findElement(By.className("btn-success"));
			
			username.sendKeys("C211010");
			pass.sendKeys("dfgdfgdf");
			login.click();

		} catch(Exception e) {
			System.out.println("Error here");
		} finally {
			System.out.println("Test Ok !");
//			driver.quit();
		}
	}

}
