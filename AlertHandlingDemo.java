package others;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.NoAlertPresentException; 
import org.openqa.selenium.Alert;

public class AlertHandlingDemo {
public static void main(String[] args) throws NoAlertPresentException,InterruptedException { 
	System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\CoreFiles\\chromedriver.exe");
WebDriver driver = new ChromeDriver(); driver.get("https://www.browserstack.com/users/sign_up");

driver.findElement(By.id("user_full_name")).sendKeys("username");
driver.findElement(By.id("user_email_login")).sendKeys("anu@gmail.com");
driver.findElement(By.id("user_password")).sendKeys("anu@2555");
driver.findElement(By.name("terms_and_conditions")).click();
driver.findElement(By.id("user_submit")).click();

Thread.sleep(5000);

Alert alert = driver.switchTo().alert(); // switch to alert

String alertMessage= driver.switchTo().alert().getText(); // capture alert message

System.out.println(alertMessage); // Print Alert Message
Thread.sleep(5000);
alert.accept(); 
}
}

