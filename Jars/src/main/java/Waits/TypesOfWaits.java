package Waits;

import java.time.Duration;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TypesOfWaits {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Prabhakaran\\Desktop\\Chrome\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		
		driver.get("https://google.com");
		
		//1.Implicit Wait
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//2.Explicit wait
		driver.navigate().to("https://gmail.com");
		
		WebDriverWait wait = new WebDriverWait(driver, 20);
		
		WebElement profile = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"gh-ac\"]")));
		
		profile.click();
		
		//3.Fluent Wait
	
		Wait<WebDriver> wait1 = new FluentWait<WebDriver>(driver)
			.withTimeout(Duration.ofSeconds(10))
			.pollingEvery(Duration.ofSeconds(10))
			.ignoring(NoSuchElementException.class);
		
		WebElement profile1 = wait.until(new Function<WebDriver, WebElement>(){

			@Override
			public WebElement apply(WebDriver driver) {
				// TODO Auto-generated method stub
				return driver.findElement(By.xpath("//*[@id=\"gh-ac\"]"));
			}
			
			
		});
	}

}
