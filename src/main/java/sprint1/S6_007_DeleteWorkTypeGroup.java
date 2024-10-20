package sprint1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;


public class S6_007_DeleteWorkTypeGroup {

public static void main(String[] args) throws InterruptedException {
	// TODO Auto-generated method stub	
	
//		1. Login to Login | Salesforce  
	    //https://login.salesforce.com/
//		Step 1: Login to Login | Salesforce  
	ChromeOptions options=new ChromeOptions();
	options.addArguments("--disable-notifications");
	ChromeDriver driver=new ChromeDriver(options);
	JavascriptExecutor  executor =(JavascriptExecutor)driver;
	driver.get("https://login.salesforce.com/");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
//		username: gokul.sekar@testleaf.com
//		password: Leaf$321
	WebElement userName = driver.findElement(By.id("username"));
	userName.sendKeys("gokul.sekar@testleaf.com");
	WebElement password = driver.findElement(By.id("password"));
	password.sendKeys("Leaf$321");
	driver.findElement(By.id("Login")).click();
//		Click on toggle menu button from the left corner
	driver.findElement(By.xpath("//button[@title='App Launcher']/div")).click();
//		Click view All and click Work Type Groups from App Launcher
	driver.findElement(By.xpath("//button[text()='View All']")).click();
	WebElement wtgroups = driver.findElement(By.xpath("//p[text()='Work Type Groups']"));
	Actions actions =new Actions(driver);
	actions.moveToElement(wtgroups).click();
	actions.perform();
//		 4. Click on the Work Type Group tab  
	WebElement wtgroupSeach = driver.findElement(By.xpath("//input[@name='WorkTypeGroup-search-input']"));
//	5. Search the Work Type Group 'Salesforce Automation by *Your Name*' 
	actions.moveToElement(wtgroupSeach);
	actions.perform();
	wtgroupSeach.sendKeys("Salesforce Automation by Praveena", Keys.ENTER);
	//
//		6. Click on the Dropdown icon and Select Delete 
	Thread.sleep(5000);
	//System.out.println("hi " + driver.findElement(By.xpath("//a[@title='Show 2 more actions']")).isEnabled());
	driver.findElement(By.xpath("(//table//tr)[2]//following::a[2]")).click();
     
	//actions.moveToElement(dropdownElemet).click().build().perform();
	//Thread.sleep(5000);
//	WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
//	wait.until((ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//table//tr//td[5]//li")))));
//	driver.findElement(By.xpath("//a[@title='Show 2 more actions']")).click();
	
//		7.Click on the Delete option in the displayed popup window. 

	WebElement delElement = driver.findElement(By.xpath("//div[@title='Delete']"));
	driver.executeScript("arguments[0].click();", delElement);
//		8. Verify Whether Work Type group is Deleted using Work Type Group Name 
 			  driver.findElement(By.xpath("//span[text()='Delete']")).click();
 	//  Expected Result: The Work Type Group is deleted Successfully  
 			  String text = driver.findElement(By.xpath("//span[contains(@class,'toastMessage')]")).getText();
 			 if(text.contains("deleted"))
 				 System.out.println(text);
 			 else
 				 System.out.println("Not deleted");
}
}

