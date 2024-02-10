package handlingdropdown;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class dropdown {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.facebook.com/");
		driver.findElement(By.linkText("Create new account")).click();
		WebElement birthdaydropdown = driver.findElement(By.name("birthday_month"));
		Select sel = new Select(birthdaydropdown);
		sel.selectByIndex(5);
		Thread.sleep(3000);
		//using visible text
		sel.selectByVisibleText("Aug");
		Thread.sleep(3000);
		//using option value
		sel.selectByValue("9");
		
		
		
		
		
		
	}

}
