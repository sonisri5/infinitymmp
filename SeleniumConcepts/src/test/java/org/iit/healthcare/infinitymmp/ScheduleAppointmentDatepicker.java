package org.iit.healthcare.infinitymmp;
import java.time.Duration;
import java.util.Date;
import java.text.SimpleDateFormat;

import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import java.util.HashMap;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ScheduleAppointmentDatepicker {
	
	public static String getFutureDate(int noofDays)
	{
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DAY_OF_MONTH, noofDays);
		Date d =calendar.getTime();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MMMM/YYYY");
		String date = sdf.format(d);
		String dateArr[] = date.split("/");
		System.out.println(dateArr[0]);
		System.out.println(dateArr[1]);
		System.out.println(dateArr[2]);
		return date;
	}
	
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
						
		String futureDate = getFutureDate(10);
		HashMap<String,String> expectedHMap = new HashMap<String,String>();
		
		String dateArr[]=futureDate.split("/");
				System.out.println(dateArr[0]);
				System.out.println(dateArr[1]);
				System.out.println(dateArr[2]);
				String expectedYear = dateArr[2];//2025
				
				String actualYear= driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();//2025
				
				while(!actualYear.equals(expectedYear))
				{
					driver.findElement(By.xpath("//span[text()='Next']")).click();
					actualYear =driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();
				}
				
				String expectedMonth = dateArr[1];//April
				
				String actualMonth = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();//January
				
				while(!actualMonth.equals(expectedMonth))
				{
					driver.findElement(By.xpath("//span[text()='Next']")).click();
					actualMonth=driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
				}
				
			driver.findElement(By.linkText(dateArr[0])).click()	;
			
			Select timeSelect = new Select(driver.findElement(By.id("time")));
			String appointmentTime="11Am";
			timeSelect.selectByVisibleText(appointmentTime);
			expectedHMap.put("time",appointmentTime);
			
			//Duration d = new Duration(30);
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("status")));
		driver.findElement(By.xpath("//button[@id='ChangeHeatName']")).click();
		driver.switchTo().defaultContent();
		
		
		String symp ="fever & flu";
		expectedHMap.put("appointment", symp);
		
		driver.findElement(By.id("sym")).sendKeys(symp);
		driver.findElement(By.xpath("//input[@value='Submit']")).click();
		System.out.println("Expected HMap"+expectedHMap);
		
		
		HashMap<String,String> actualHMap = new HashMap<String,String>();
		actualHMap.put("doctor", driver.findElement(By.xpath("//table/tbody/tr[1]/td[4]")).getText().trim());
		actualHMap.put("appointment", driver.findElement(By.xpath("//table/tbody/tr[1]/td[3]")).getText().trim());
		actualHMap.put("time", driver.findElement(By.xpath("//table/tbody/tr[1]/td[2]")).getText().trim());
		actualHMap.put("date", driver.findElement(By.xpath("//table/tbody/tr[1]/td[1]")).getText().trim());
		
		
	}
}






