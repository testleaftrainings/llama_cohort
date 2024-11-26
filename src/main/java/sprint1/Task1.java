package sprint1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class Task1 {

@Test
	
	public void LoginSalesForce() throws InterruptedException {
	
	ChromeOptions options = new ChromeOptions();
	options.addArguments("--disable-notifications");
		
		ChromeDriver driver = new ChromeDriver(options);
		
		driver.get("https://login.salesforce.com/?locale=in");
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.findElement(By.id("username")).sendKeys("Gokul.sekar@testleaf.com");
		
		driver.findElement(By.id("password")).sendKeys("Leaf$321");
		
		driver.findElement(By.id("Login")).click();
		
		driver.findElement(By.xpath("//button[@title='App Launcher']")).click();
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		
		driver.findElement(By.xpath("//input[contains(@placeholder,'Search apps')]")).sendKeys("Work Type Groups");
		driver.findElement(By.xpath("//*[text()='Work Type Groups']")).click();
		driver.findElement(By.xpath("//a[contains(@title,'Work Type Groups')]//following::one-app-nav-bar-item-dropdown[2]")).click();
		WebElement newgroup = driver.findElement(By.xpath("//span[text()='New Work Type Group']"));
		driver.executeScript("arguments[0].click()",newgroup);
		driver.findElement(By.xpath("//label[text()='Work Type Group Name']//following::input[@name='Name']")).sendKeys("SalesForce Automation by Prabhu");
		driver.findElement(By.xpath("//button[text()='Save']")).click();
		
		Thread.sleep(5000);
		
		WebElement Closetab = driver.findElement(By.xpath("//a[contains(@title,'Work Type Groups')]//following::one-app-nav-bar-item-dropdown//following::button//span[text()='Close tab']"));
		driver.executeScript("arguments[0].click()",Closetab);
		
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[text()='Search...']")).click();
		//driver.findElement(By.xpath("//button[text()='Search...']")).sendKeys("SalesForce Automation by Prabhu",Keys.ENTER);
		driver.findElement(By.xpath("(//input[@type='search'])[3]")).sendKeys("SalesForce Automation by Prabhu",Keys.ENTER);
		
		driver.findElement(By.xpath("((//table[2]//tr)[1]/following::a[2]")).click();
		WebElement editdropdown = driver.findElement(By.xpath("//div[text()='Edit']"));
		driver.executeScript("arguments[0].click()",editdropdown);
		
		driver.findElement(By.xpath("//label[text()='Description']//following::textarea")).sendKeys("Automated");
		WebElement editDesc = driver.findElement(By.xpath("//label[text()='Group Type']//following::span[text()='Default']"));
		driver.executeScript("arguments[0].click()",editDesc);
		driver.findElement(By.xpath("//span[text()='Capacity']")).click();
		driver.findElement(By.xpath("//button[text()='Save']")).click();
		WebElement outputscreen = driver.findElement(By.xpath("//span[text()='\" was saved.']"));
		if (outputscreen.isDisplayed()) {
			System.out.println(outputscreen.getText());
		}
			else {
				System.out.println(" was saved is not present " + " No you not automated successfully ");
			}
		driver.quit();
		}

}

