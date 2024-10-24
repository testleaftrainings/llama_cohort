package sprint1;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class S644CreateNewChart {
	@Test
	public void createNewChart() throws InterruptedException, MalformedURLException {
		
		EdgeOptions option = new EdgeOptions();
		option.addArguments("--disable-notifications");
		DesiredCapabilities dc = new DesiredCapabilities(option);
		dc.setBrowserName("MicrosoftEdge");
		dc.setPlatform(Platform.LINUX);
		
		//dc.
		RemoteWebDriver driver = new RemoteWebDriver(new URL("http://20.40.48.160:4444/wd/hub"), dc);
		
		//EdgeDriver driver=new EdgeDriver();             
		driver.get("https://login.salesforce.com/"); 
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.id("username")).sendKeys("gokul.sekar@testleaf.com");
		driver.findElement(By.id("password")).sendKeys("Leaf@123");
		driver.findElement(By.id("Login")).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	//	File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	
		//Click on toggle menu button from the left corner
		driver.findElement(By.xpath("//button[@title='App Launcher']")).click();
		//Click view All and click Service Console from App Launcher
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		driver.findElement(By.xpath("//P[text()='Service Console']")).click();
		//Click on the drop down and select Refunds 
		//Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//button[@title='Show Navigation Menu']"))));
		driver.findElement(By.xpath("//button[@title='Show Navigation Menu']")).click();
		Thread.sleep(1000);
		Actions action = new Actions(driver);
		
//		 File destinationFile = new File("D:\\TestSS\\screenshot.png");
//		 FileHandler.copy(screenshot, destinationFile);
		WebElement element = driver.findElement(By.xpath("//a[@data-itemid='Refund']"));
		action.scrollToElement(element).perform();
     
		
		 driver.findElement(By.xpath("//a[@data-itemid='Refund']")).click();
		
		//Click on drop down near Recently viewed and change into 'All'.
		
		driver.findElement(By.xpath("//button[@title='Select a List View: Refunds']")).click();
		driver.findElement(By.xpath("//span[text()='All Refunds']")).click();
		
		//Click on Chart icon under New Button 
		driver.findElement(By.xpath("//button[@title='Charts']")).click();
		
		//Click New Chart 
		 element=driver.findElement(By.xpath("//a[@title='Settings']"));
		Thread.sleep(1000);
		action.scrollToElement(element).perform();
		driver.findElement(By.xpath("//a[@title='Settings']")).click();
		driver.findElement(By.xpath("//a[@title='New Chart']")).click();
		
		//Give Chart Name and Select Chart Type
		Thread.sleep(1000);
		
       // driver.findElement(By.xpath("//input[@part='input']")).click();
		driver.findElement(By.xpath("//div[@data-aura-class='forceListviewChartsSetupPage']//input")).sendKeys("Manoj");
		driver.findElement(By.xpath("//button[@aria-label='Chart Type']")).click();
		//Thread.sleep(1000);
		driver.findElement(By.xpath("//span[@title='Vertical Bar Chart']")).click();
		Thread.sleep(1000);
		//Select Aggregate Type as Average and ggregate Field as Amount 
		driver.findElement(By.xpath("//button[@aria-label='Aggregate Type']")).click();
		driver.findElement(By.xpath("//span[@title='Average']")).click();
		driver.findElement(By.xpath("//button[@aria-label='Aggregate Field']")).click();
		driver.findElement(By.xpath("(//span[@title='Amount'])[2]")).click();
		
		//Select Grouping Field as Account and click Save 
		element=driver.findElement(By.xpath("//button[@aria-label='Grouping Field']"));
		action.scrollToElement(element).perform();
		driver.findElement(By.xpath("//button[@aria-label='Grouping Field']")).click();
		driver.findElement(By.xpath("//div[@aria-label='Grouping Field']//span[@title='Account']")).click();
		driver.findElement(By.xpath("//button[@title='Save']")).click();
		
		//Click on settings icon and change the Chart Type
		System.out.println(driver.findElement(By.xpath("//a[@class='select']")).getText());
		Thread.sleep(1000);
		element=driver.findElement(By.xpath("//a[@title='Settings']"));
		Thread.sleep(1000);
		action.scrollToElement(element).perform();
		driver.findElement(By.xpath("//a[@title='Settings']")).click();
		driver.findElement(By.xpath("//a[@title='Donut Chart']")).click();
		//Thread.sleep(2000);
		driver.quit();
	}
}
