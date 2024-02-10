package browsertest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class browserNavigation {

	public static void main(String[] args) {
	
	WebDriver driver =new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://www.amazon.com/");
	System.out.println(driver.getTitle());
	driver.navigate().to("https://www.yahoo.com/");
	System.out.println(driver.getTitle());
	driver.navigate().back();
	driver.navigate().forward();
	driver.navigate().refresh();
	driver.close();
	
		
	}

}
