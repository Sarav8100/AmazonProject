package Amazon;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.apache.commons.compress.compressors.FileNameUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;

public class AmazonLogin {

	private static Object SECONDS;

	public static void main(String[] args) throws IOException, Exception {

		Properties prop = new Properties();
		

		FileInputStream input = new FileInputStream ("Amazon.properties");
	
		prop.load(input);
			
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Prabhakaran\\Desktop\\ChromeJares\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		
		driver.get("https://amazon.in");
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		driver.manage().window().maximize();
		
		System.out.println(driver.getTitle());
		
		driver.findElement(By.id("nav-link-accountList")).click();
		
		driver.findElement(By.id("ap_email")).clear();
		
		driver.findElement(By.id("ap_email")).sendKeys(prop.getProperty("Username"));
		 
		driver.findElement(By.id("continue")).click();
		
		driver.findElement(By.name("password")).sendKeys(prop.getProperty("Password"));
		
		driver.findElement(By.id("signInSubmit")).click();
		
		driver.findElement(By.xpath("//a[@id='nav-cart']")).click();
		
		Thread.sleep(3000);
		
		WebElement element2 = driver.findElement(By.xpath("//select[@name='quantity']"));	
		
		String qty = "2";
		
		Select sel = new Select(element2);
		
		
		sel.selectByVisibleText(qty);
		
		Actions action = new Actions(driver);
		WebElement we = driver.findElement(By.xpath("//*[@id=\'nav-link-accountList\']"));
		action.moveToElement(we).moveToElement(driver.findElement(By.xpath("//*[@id=\'nav-al-your-account\']/a[3]"))).click().build().perform();
		
		driver.findElement(By.xpath("//*[@id=\'pab-I3JX7TPWP8KYP0\']")).click();
		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//a[@id='nav-cart']")).click();
		
		
		
		
		//*[@id="nav-al-your-account"]/a[3]/
		
				//*[@id="nav-link-accountList"]
//		Actions action = new Actions(driver);
//		
//		Action arrowdown = action.sendKeys(Keys.ARROW_DOWN.ENTER).build();
//		
//		arrowdown.perform();
//		
//		Action arrow = action.
		
		

	}

}

