package org.iit.healthcare.infinitymmp;

import java.util.Random;

import org.junit.BeforeClass;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
  
import io.github.bonigarcia.wdm.WebDriverManager;
 
public class Editprofile {
	WebDriver driver;
	@BeforeClass
	public void instantiateDriver()
	{
	WebDriverManager.chromedriver().setup();
    driver = new ChromeDriver();
	}
@Test
	public void validateEditProfileTest()
	{

	   MMpLib mmpLib = new MMpLib(driver);
	    mmpLib.login();
		boolean result =editFirstName();
		Assert.assertTrue(result);
	}
	@Test
	public void validateFName_withInvalidData()
{
	
    MMPLib mmpLib = new MMPLib(driver);
    mmpLib.login();
	boolean result = editFirstName();
	Assert.assertTrue(result);
}
	public boolean editFirstName_withInvlidData()
	
	{
		
		
		driver.findElement(By.xpath("//span[normalize-space()='Profile']")).click();
		driver.findElement(By.id("Ebtn")).click();
		driver.findElement(By.id("fname")).clear();	
		driver.findElement(By.id("fname")).sendKeys(generateRandomNumber());
		driver.findElement(By.id("Sbtn")).click();
		String actual = driver.findElement(By.id("firsterr1")).getText().trim();
		String expected ="please enter only alphabets";
		return expected.equals(actual);
	}

	public boolean editFirstName() {
		
	driver.findElement(By.xpath("//span[normalize-space()='Profile']")).click();
	driver.findElement(By.id("Ebtn")).click();
	driver.findElement(By.id("fname")).clear();
	String expectedfnameValue="FNAMEAUT"+generateRandomString();
	driver.findElement(By.id("fname")).sendKeys(expectedfnameValue);
	driver.findElement(By.id("Sbtn")).click();
	Alert alrt=driver.switchTo().alert();
	alrt.accept();
	String actualfNameValue=driver.findElement(By.id("fname")).getAttribute("value");
	return expectedfnameValue.equals(actualfNameValue);
	
	
	
	}


	public String generateRandomString() {
		Random rand = new Random();
		int u = 65 +  rand.nextInt(26);
		char upperCase=(char) u;
				System.out.println("UpperCase::"+upperCase);
				
				int l = 97+rand.nextInt(122-97+1);
				char lowercase = (char)l;
				System.out.println("lowercase::+lowercase");
				String randomString = upperCase+""+lowercase+"";
				return randomString;
						
	
		
	}
	public String generateRandomNumber() 
	{
			Random rand = new Random();
		int u = 65 +  rand.nextInt(26);
		char upperCase=(char) u;
				System.out.println("UpperCase::"+upperCase);
				
				int l = 97+rand.nextInt(122-97+1);
				char lowercase = (char)l;
				System.out.println("lowercase::+lowercase");
					String randomString = upperCase+lowercase+"";
				return randomString;
}
}