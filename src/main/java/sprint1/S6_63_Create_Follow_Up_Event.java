package sprint1;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.time.LocalDate;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class S6_63_Create_Follow_Up_Event {
	@Test
	public void createNewChart() throws InterruptedException, IOException {
		
		EdgeOptions option = new EdgeOptions();
		option.addArguments("--disable-notifications");
		DesiredCapabilities dc = new DesiredCapabilities(option);
		dc.setBrowserName("MicrosoftEdge");
		dc.setPlatform(Platform.LINUX);
		
		//dc.
		RemoteWebDriver driver = new RemoteWebDriver(new URL("http://20.40.48.160:4444/wd/hub"), dc);
		
		
		//EdgeDriver driver=new EdgeDriver(option);             
		driver.get("https://login.salesforce.com/"); 
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.id("username")).sendKeys("gokul.sekar@testleaf.com");
		driver.findElement(By.id("password")).sendKeys("Leaf@123");
		driver.findElement(By.id("Login")).click();
		//File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	
		//Click on toggle menu button from the left corner
		driver.findElement(By.xpath("//button[@title='App Launcher']")).click();
		//Click view All and click Service Console from App Launcher
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		
		//Click on Content tab 
		driver.findElement(By.xpath("//P[text()='Content']")).click();
		
		//Click View All from Today's Task
		WebElement element = driver.findElement(By.xpath("//div[@data-target-selection-name='runtime_sales_activities_todayTaskContainer']//a"));
		Actions action = new Actions(driver);
		action.scrollToElement(element);
		element.click();
		
		//Click the Display as dropdown under Recently Viewed and select Table
		driver.findElement(By.xpath("//div[@title='Select list display']")).click();
		driver.findElement(By.xpath("//span[text()='Table']")).click();
		
		//Click the dropdown of first result and click Create Follow-Up Event
		String title=driver.findElement(By.xpath("//tbody/tr[1]/th//a")).getAttribute("title");
		driver.findElement(By.xpath("//table/tbody/tr[1]/td[7]")).click();
		driver.findElement(By.xpath("//ul[@class='scrollable']//a[@title='Create Follow-Up Event']")).click();
		
		//Enter Subject as Meeting
		driver.findElement(By.xpath("//label[text()='Subject']/following-sibling::div[1]")).click();
		driver.findElement(By.xpath("//span[@title='Meeting']")).click();
		
		Thread.sleep(1000);
		//Select the Name of the person in Name field
		element=driver.findElement(By.xpath("(//span[text()='Pick an object']/parent::span[@part='boundary'])[2]"));
		action.scrollToElement(element);
		element.click();
		driver.findElement(By.xpath("//span[@title='Contacts']")).click();
		driver.findElement(By.xpath("//span[text()='Name']/parent::label/following::input[1]")).click();
		driver.findElement(By.xpath("//div[@role='listbox']//li[1]")).click();
		
		//Select the Product in releted to field
		
		Thread.sleep(1000);
		//driver.executeScript("window.scrollBy(0, 500)");
		element= driver.findElement(By.xpath("//textarea"));
		driver.executeScript("arguments[0].scrollIntoView(true)",element);
		element= driver.findElement(By.xpath("(//span[text()='Pick an object']/parent::span[@part='boundary'])[3]"));
		element.click();
		Thread.sleep(1000);
		element=driver.findElement(By.xpath("//a[@title='Products']"));
		action.scrollToElement(element);
		element.click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//span[text()='Related To']/parent::label/following::input[1]")).click();
		driver.findElement(By.xpath("//input[@title='Search Products']/parent::div//li[1]")).click();
		
		//Select due date From today to 14 days
		LocalDate date= LocalDate.now();
		LocalDate plusDays = date.plusDays(13);
		String dateAfterAddtion = plusDays.toString();
		driver.findElement(By.xpath("(//label[text()='Date'])[2]/following::input[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//tbody/tr/td[@data-value='"+dateAfterAddtion+"']")).click();
		
		// Click Save button Expected result:
		driver.findElement(By.xpath("//button[@title='Save']")).click();
		if(driver.findElement(By.xpath("//a[@title='Meeting']/div")).isDisplayed())
			System.out.println("Follow up event is created sucessfully");
		else System.out.println("Follow up event is not created");
		//Thread.sleep(3000);
		driver.quit();
	}
}
