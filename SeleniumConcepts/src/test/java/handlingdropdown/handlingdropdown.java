package handlingdropdown;



import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class handlingdropdown {

	public static void main(String[] args) throws InterruptedException  {
		
		WebDriver driver =new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://www.facebook.com/");
		driver.findElement(By.linkText("Create new account")).click();
		
		driver.manage().timeouts().implicitlyWait(Duration .ofSeconds(10));
		
		driver.findElement(By.name("firstname")).sendKeys("Soni");
		driver.findElement(By.name("lastname")).sendKeys("Kumar");
		
		driver.manage().timeouts().implicitlyWait(Duration .ofSeconds(10));
		
		driver.findElement(By.name("reg_email__")).sendKeys("5104683579");
		driver.findElement(By.name("reg_passwd__")).sendKeys("soni468");
		
		
		
		
		
		
		
		
		
	}

}
