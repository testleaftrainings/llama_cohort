package SDETSelenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class S6_28_CreateNewDashboard {
	
	@Test
	public void createDashboard() throws InterruptedException
	{
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--disable-notifications");
		ChromeDriver driver=new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().window().maximize();
		driver.get("https://login.salesforce.com/");
		driver.findElement(By.id("username")).sendKeys("gokul.sekar@testleaf.com");
		driver.findElement(By.id("password")).sendKeys("Leaf$321");
		driver.findElement(By.id("Login")).click();
		Thread.sleep(5000);
		//2. Click on the toggle menu button from the left corner	
		driver.findElement(By.xpath("//button[@title='App Launcher']/div")).click();
		//3. Click View All and click Dashboards from App Launcher
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		Actions actions=new Actions(driver);
		actions.moveToElement(driver.findElement(By.xpath("//p[text()='Dashboards']"))).click().build().perform();
		driver.findElement(By.xpath("//a[@title='New Dashboard']")).click();
		Thread.sleep(1000);
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(60));
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@title='dashboard']")));
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//label[text()='Name']//following::input[@id='dashboardNameInput']")))).sendKeys("Salesforce Automation By Dhanusha");
		driver.findElement(By.id("submitBtn")).click();
		Thread.sleep(5000);
		driver.switchTo().parentFrame();
		Thread.sleep(5000);
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@title='dashboard']")));
		WebElement eleSave=driver.findElement(By.xpath("//div[@class='actionRibbon']//button[text()='Save']"));
		actions.moveToElement(eleSave).click().build().perform();
		actions.moveToElement(driver.findElement(By.xpath("//button[text()='Done']"))).click().build().perform();
		String name=driver.findElement(By.xpath("//span[text()='Dashboard']//following::span[1]")).getText();
		System.out.println(name);
			System.out.println("The New Dashboard is created");
		driver.quit();
		
		
		
		
	}

}
