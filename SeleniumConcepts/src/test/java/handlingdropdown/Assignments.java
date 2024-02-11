package handlingdropdown;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignments {
	public static void main(String[] args)
	{
		calculateChangePercentage("Machino Plastics");
		calculateChangePercentage("CHD Chemicals Ltd.");
	}
	
	public static void calculateChangePercentage(String stockName) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://money.rediff.com/gainers");
		String prevClose = driver.findElement(By.xpath("//a[normalize-space()='"+stockName+"']/parent::td/following-sibling::td[2]")).getText();
		String currClose = driver.findElement(By.xpath("//a[normalize-space()='"+stockName+"']/parent::td/following-sibling::td[3]")).getText();
		String change =  driver.findElement(By.xpath("//a[normalize-space()='"+stockName+"']/parent::td/following-sibling::td[4]")).getText();
		
		System.out.println(prevClose +"===" + currClose +"==="+change);
		/**
		 * Formula
		 * (CurrentPrice-PreviousClose)
		 * --------------------------------- X 100
		 * (PreviousClose)
		 */
		float currClosefloat = Float.parseFloat(currClose); 
		float prevClosefloat=Float.parseFloat(prevClose); 
		float changepercentage =( (currClosefloat - prevClosefloat)/prevClosefloat)*100;
		System.out.println(changepercentage);
		//driver.close();
	}
}
