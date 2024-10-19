package SDETSelenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class S6_001_CreateAccount {
	
	@Test
	public void CreateAccount() throws InterruptedException
	{
		// Login to Login | Salesforce 
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--disable-notifications");
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://login.salesforce.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().window().maximize();
		driver.findElement(By.id("username")).sendKeys("gokul.sekar@testleaf.com");
		driver.findElement(By.id("password")).sendKeys("Leaf$321");
		driver.findElement(By.id("Login")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("//button[@title='App Launcher']/div")).click();
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		driver.findElement(By.xpath("//p[text()='Sales']")).click();
		//Click Accounts tab
		//driver.findElement(By.xpath("//a[@title='Accounts']")).click();
		WebElement eleAccounts = driver.findElement(By.xpath("//a[@title='Accounts']"));
		driver.executeScript("arguments[0].click();", eleAccounts);

		driver.findElement(By.xpath("//a[@title='New']")).click();
		driver.findElement(By.xpath("//label[text()='Account Name']//following::input[1]")).sendKeys("Dhanusha");
		WebElement eleOwnership=driver.findElement(By.xpath("//label[text()='Ownership']/following::button[1]//*[text()='--None--']"));
		driver.executeScript("arguments[0].click()", eleOwnership);
		driver.findElement(By.xpath("//span[@title='Public']")).click();
		driver.findElement(By.xpath("//button[@name='SaveEdit']")).click();
		//driver.findElement(By.xpath("//label[text()='Description']/following::button[text()='Save']")).click();
		Thread.sleep(2000);
		String text = driver.findElement(By.xpath("//div[contains(@id,'toastDescription')]")).getText();
		System.out.println(text);
		driver.quit();
		
		
	}

}
