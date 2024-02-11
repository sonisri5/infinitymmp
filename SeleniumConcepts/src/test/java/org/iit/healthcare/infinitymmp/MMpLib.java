package org.iit.healthcare.infinitymmp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MMpLib {
	
	WebDriver driver;
	
	public MMpLib(WebDriver driver) {
		this.driver = driver;
	}

	public String login()
	{
		    driver.get("http://96.84.175.78/MMP-Release2-Integrated-Build.6.8.000/portal/login.php");
			driver.findElement(By.id("username")).sendKeys("ria1");
			driver.findElement(By.id("password")).sendKeys("Ria12345");
			driver.findElement(By.name("submit")).click();
			String actual = driver.findElement(By.xpath("//h3[normalize-space()='ria1']")).getText().trim();
			return actual;
	}
}

