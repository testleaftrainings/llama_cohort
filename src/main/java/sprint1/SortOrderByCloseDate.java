package sprint1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class SortOrderByCloseDate {
	
	@Test
	public void SortOrderByCloseDate() throws InterruptedException {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(options);
		
		driver.get("https://login.salesforce.com/?locale=in");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.findElement(By.id("username")).sendKeys("learners@testleaf.com");
		driver.findElement(By.id("password")).sendKeys("Leaf@1234");
		driver.findElement(By.id("Login")).click();
		
		driver.findElement(By.xpath("//button[@title='App Launcher']")).click();
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		
		driver.findElement(By.xpath("//input[contains(@placeholder,'Search apps')]")).sendKeys("Sales");
		driver.findElement(By.xpath("(//*[text()='Sales'])[3]")).click();
		WebElement ClickOppurtunity = driver.findElement(By.xpath("//a[@title='Opportunities']"));
		driver.executeScript("arguments[0].click()",ClickOppurtunity);
		
		Thread.sleep(5000);

		WebElement Date = driver.findElement(By.xpath("//span[text()='Close Date']"));
		driver.executeScript("arguments[0].click()",Date);
		driver.quit();
		}
	}

