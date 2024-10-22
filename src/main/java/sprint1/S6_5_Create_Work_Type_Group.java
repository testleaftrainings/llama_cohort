package sprint1;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class S6_5_Create_Work_Type_Group {
	@Test
	public void createWorkTypeGroup() throws InterruptedException, MalformedURLException {
		
		EdgeOptions option = new EdgeOptions();
		option.addArguments("--disable-notifications");
		DesiredCapabilities dc = new DesiredCapabilities(option);
		dc.setBrowserName("chrome");
		dc.setPlatform(Platform.LINUX);
		RemoteWebDriver driver = new RemoteWebDriver(new URL("http://20.40.48.160:4444/wd/hub"), dc);
		
////		
		//EdgeDriver driver=new EdgeDriver(option);             
		driver.get("https://login.salesforce.com/"); 
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.id("username")).sendKeys("gokul.sekar@testleaf.com");
		driver.findElement(By.id("password")).sendKeys("Leaf@123");
		driver.findElement(By.id("Login")).click();
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
		
		//Click on toggle menu button from the left corner
		driver.findElement(By.xpath("//button[@title='App Launcher']")).click();
		//Click View All and click Work Type Groups from App Launcher 
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		driver.findElement(By.xpath("//div[@type='search']/input")).sendKeys("Work Type Groups");
		
		
		driver.executeScript("arguments[0].click()",  driver.findElement(By.xpath("//a[@data-label='Work Type Groups']")));
		//Click on the Dropdown icon in the Work Type Groups tab 
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("(//a[contains(@title,'Work Type Groups')])[2]/following-sibling::*//a"))));
		
		driver.findElement(By.xpath("(//a[contains(@title,'Work Type Groups')])[2]/following-sibling::*//a")).click();
		//Click on New Work Type Group 
		driver.executeScript("arguments[0].click()",driver.findElement(By.xpath("//span[text()='New Work Type Group']")));
		//Enter Work Type Group Name as 'Salesforce Automation by *Your Name*' 
		driver.findElement(By.xpath("//label[text()='Work Type Group Name']/following::input[@name='Name']")).sendKeys("Salesforce Automation by Manoj");
		//Click save and verify Work Type Group Name 
		driver.findElement(By.xpath("//button[@name='SaveEdit']")).click();
		if(driver.findElement(By.xpath("//div[@data-aura-class='forceToastMessage']")).isDisplayed()) {
			System.out.println(driver.findElement(By.xpath("(//a[@class='forceActionLink']/div)[2]")).getText());
			System.out.println("Work Type Group created Successfully");
		}
			
		else System.out.println("Work Type Group not created ");
		//Thread.sleep(2000);
		//driver.quit();
	}
	
	
}
