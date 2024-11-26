package sprint1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class CreateContactForCampaign {

@Test
	
	public void CreateContactForCampaign() throws InterruptedException {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		
		ChromeDriver driver = new ChromeDriver(options);
		driver.get("https://login.salesforce.com/?locale=in");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.findElement(By.id("username")).sendKeys("Gokul.sekar@testleaf.com");
		driver.findElement(By.id("password")).sendKeys("Leaf@123");
		driver.findElement(By.id("Login")).click();
		
		driver.findElement(By.xpath("//button[@title='App Launcher']")).click();
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		
		driver.findElement(By.xpath("//input[contains(@placeholder,'Search apps')]")).sendKeys("Sales");
		driver.findElement(By.xpath("(//*[text()='Sales'])[3]")).click();
		Thread.sleep(3000);
		
		WebElement MoreDropDown = driver.findElement(By.xpath("//a[@title='Campaigns']/following::one-app-nav-bar-item-dropdown"));
		try {
			MoreDropDown.click();
		} catch (StaleElementReferenceException e) {
			MoreDropDown = driver.findElement(By.xpath("//a[@title='Campaigns']/following::one-app-nav-bar-item-dropdown"));
		}
			MoreDropDown.click();
			Thread.sleep(3000);
			
			WebElement newcampaign = driver.findElement(By.xpath("(//span[text()='Bootcamp'])[1]"));
			driver.executeScript("arguments[0].click()",newcampaign);
			driver.findElement(By.xpath("//a/following::div[text()='New Contact']")).click();
		
		driver.findElement(By.xpath("(//span[text()='Salutation']/following::div)[1]")).click();
		WebElement clickname = driver.findElement(By.xpath("//div[@class='select-options']//li/a[@title='Mr.']"));
		driver.executeScript("arguments[0].click()",clickname);
		
		driver.findElement(By.xpath("(//span[text()='First Name']/following::input)[1]")).sendKeys("Prabhu");
		driver.findElement(By.xpath("(//span[text()='Last Name']/following::input)[1]")).sendKeys("M");
		driver.findElement(By.xpath("(//span[text()='Save'])[2]")).click();
		Thread.sleep(5000);
		
		WebElement campmember = driver.findElement(By.xpath("(//a/following::span[text()='Campaign Members'])[1]"));
		Actions cc = new Actions(driver);
		cc.scrollToElement(campmember).perform();
		WebElement campfield = driver.findElement(By.xpath("//a/following::div[text()='Add Contacts']"));
		driver.executeScript("arguments[0].click()",campfield);
		
		driver.findElement(By.xpath("((//tbody/tr/td)[2]/following::span[@class='slds-checkbox--faux slds-checkbox_faux'])[2]")).click();
				
		driver.findElement(By.xpath("//button[text()='Next']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[text()='Submit']")).click();
	
		WebElement action = driver.findElement(By.xpath("(//a/div[@class='slds-card__footer'])[2]"));
		Actions va = new Actions(driver);
		va.scrollToElement(action).perform();
		
		WebElement va1 = driver.findElement(By.xpath("(//div/span[text()='View All'])[2]"));
		driver.executeScript("arguments[0].click()",va1);
		Thread.sleep(3000);
		
		WebElement con = driver.findElement(By.xpath("//div/following::one-app-nav-bar-item-root/a[@title='Contacts']"));
		driver.executeScript("arguments[0].click()",con);

		driver.findElement(By.xpath("//input[contains(@placeholder,'Search this list...')]")).sendKeys("Prabhu M");	
		driver.quit();
		
	}
}

