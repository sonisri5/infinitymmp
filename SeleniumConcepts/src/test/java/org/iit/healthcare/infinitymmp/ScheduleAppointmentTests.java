package org.iit.healthcare.infinitymmp;

import java.util.HashMap;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ScheduleAppointmentTests {
	WebDriver driver;
	@Test
	public void bookAppointment() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("http://96.84.175.78/MMP-Release2-Integrated-Build.6.8.000/portal/login.php");
		driver.findElement(By.id("username")).sendKeys("ria1");
		driver.findElement(By.id("password")).sendKeys("Ria12345");
		driver.findElement(By.name("submit")).click();
		String actual = driver.findElement(By.xpath("//h3[normalize-space()='ria1']")).getText().trim();
		String expected="ria1";
		Assert.assertEquals(actual,expected);
		
		driver.findElement(By.xpath("//span[normalize-space()='Schedule Appointment']")).click();
		driver.findElement(By.xpath("//input[@value='Create new appointment']")).click();
		
		driver.findElement(By.xpath("//h4[text()='Dr.Smith']/parent::li/div/p[text()='Description:Orthopedic']/ancestor::ul/following-sibling::button")).click();
		
		driver.switchTo().frame("myframe");
		driver.findElement(By.id("datepicker")).click();
		driver.findElement(By.xpath("//span[text()='Next']")).click();
		Random rand = new Random();
		int randomDate = rand.nextInt(28);
		System.out.println(randomDate);
		driver.findElement(By.linkText(randomDate+"")).click();
		
		
		
	}		
}




