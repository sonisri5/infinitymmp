package locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class locators {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demo.guru99.com/test/newtours/");
		driver.findElement(By.linkText("REGISTER")).click();
		driver.findElement(By.name("firstName" )).sendKeys("sonu");
		driver.findElement(By.name("lastName")).sendKeys("srivastava");
		driver.findElement(By.name("phone")).sendKeys("5103457654");
		driver.findElement(By.id("userName")).sendKeys("sudhirk5@hotmail.com");
		driver.findElement(By.name("address1")).sendKeys("4607 griffith ava");
		driver.findElement(By.name("city")).sendKeys("seatle");
		driver.findElement(By.name("state")).sendKeys("washigton");
		driver.findElement(By.name("postalCode")).sendKeys("94538");
		driver.findElement(By.id("email")).sendKeys("sonu");
		driver.findElement(By.name("password")).sendKeys("er456");
		driver.findElement(By.name("confirmPassword")).sendKeys("er456");
		driver.findElement(By.name("submit")).click();
		
		
		
		
		
		
	}

}
