package SDETSelenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class S6_52_DeleteOpportunity {
	
	@Test
	public void deleteOpportunity() throws InterruptedException
	{
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--diable-notifications");
		ChromeDriver driver=new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().window().maximize();
		driver.get("https://login.salesforce.com/");
		driver.findElement(By.id("username")).sendKeys("gokul.sekar@testleaf.com");
		driver.findElement(By.id("password")).sendKeys("Leaf$321");
		driver.findElement(By.id("Login")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//button[@title='App Launcher']/div")).click();
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		driver.findElement(By.xpath("//p[text()='Sales']")).click();
		WebElement eleCampaign=driver.findElement(By.xpath("//a[@title='Campaigns']"));
		driver.executeScript("arguments[0].click()", eleCampaign);
		driver.findElement(By.xpath("//input[@name='Campaign-search-input']")).sendKeys("Bootcamp",Keys.ENTER);
		Thread.sleep(5000);
		driver.findElement(By.xpath("//a[@title='Bootcamp']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//a[contains(@title,'more actions')]")).click();
		driver.findElement(By.xpath("//a[@title='Delete']")).click();
		driver.findElement(By.xpath("//button[@title='Delete']")).click();
		String message=driver.findElement(By.xpath("//div[contains(@id,'toastDescription')]//span")).getText();
		System.out.println(message);
		driver.findElement(By.xpath("//input[@name='Campaign-search-input']")).sendKeys("Bootcamp",Keys.ENTER);
		System.out.println(driver.findElement(By.xpath("//div[contains(@class,'emptyContentInner')]//span")).getText());
		WebElement eleOppor=driver.findElement(By.xpath("//a[@title='Opportunities']"));
		driver.executeScript("arguments[0].click()", eleOppor);
		driver.findElement(By.xpath("//input[@name='Opportunity-search-input']")).sendKeys("Bootcamp",Keys.ENTER);
		System.out.println(driver.findElement(By.xpath("//div[contains(@class,'emptyContentInner')]//span")).getText());
		
	}

}
