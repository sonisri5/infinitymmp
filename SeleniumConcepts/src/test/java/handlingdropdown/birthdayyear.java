package handlingdropdown;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class birthdayyear {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.facebook.com/");
		driver.findElement(By.linkText("Create new account")).click();
		WebElement year = driver.findElement(By.name("birthday_year"));
		Select sel = new Select(year);
		sel.selectByValue("2015");
		Thread.sleep(2000);
		sel.selectByVisibleText("2022");
		Thread.sleep(4000);
		//using index
		sel.selectByIndex(4);
		
	}

}
