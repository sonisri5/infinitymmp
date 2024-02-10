package handlingdropdown;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class birthday {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.facebook.com/");
		driver.findElement(By.linkText("Create new account")).click();
		WebElement daydropdown = driver.findElement(By.id("day"));
		Select sel = new Select(daydropdown);
		sel.selectByIndex(7);
		Thread.sleep(3000);
		//using visible text
		sel.selectByVisibleText("20");
		Thread.sleep(3000);
		//using option value
		sel.selectByValue("21");
		
		
		
	
		
		
		

	}

}
