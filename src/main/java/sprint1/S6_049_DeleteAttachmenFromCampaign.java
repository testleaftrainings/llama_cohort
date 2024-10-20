package sprint1;

import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class S6_049_DeleteAttachmenFromCampaign {
	@Test
	public void runDeleteAttachmentCampaign() throws InterruptedException, MalformedURLException {
// TODO Auto-generated method stub
		// 1. Login to https://login.salesforce.com
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--disable-notifications");
		DesiredCapabilities dc = new DesiredCapabilities(options);
		dc.setBrowserName("chrome");
		dc.setPlatform(Platform.LINUX);
		RemoteWebDriver driver = new RemoteWebDriver(new URL("http://20.40.48.160:4444/wd/hub"), dc);
//		ChromeOptions options=new ChromeOptions();
//		options.addArguments("--disable-notifications");
//		ChromeDriver driver = new ChromeDriver(options);
		JavascriptExecutor jexecutor=(JavascriptExecutor)driver;
        Actions actions=new Actions(driver);
		driver.get("https://login.salesforce.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.id("username")).sendKeys("gokul.sekar@testleaf.com");
		driver.findElement(By.id("password")).sendKeys("Leaf$321");
		driver.findElement(By.id("Login")).click();
		// 2. Click on toggle menu button from the left corner
		driver.findElement(By.xpath("//button[@title='App Launcher']/div")).click();
		// 3. Click view All and click Sales from App Launcher
		
		WebElement viewAll = driver.findElement(By.xpath("//button[text()='View All']"));
		actions.moveToElement(viewAll).click().build().perform();
		driver.findElement(By.xpath("//p[text()='Sales']")).click();
		// 4. Click on Campaigns tab
		WebElement campaignElement = driver.findElement(By.xpath("//span[text()='Campaigns']"));
		jexecutor.executeScript("arguments[0].click();", campaignElement);
		// 5. Click Bootcamp link
		driver.findElement(By.linkText("Praveena Bootcamp")).click();
//		6. Click on View All link in the Attachments section 
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
		WebElement viewAllLink = driver.findElement(By.xpath("(//span[text()='Attachments'])[2]/parent::span"));
//		wait.until(ExpectedConditions.visibilityOf(viewAllLink));
//		wait.until(ExpectedConditions.elementToBeClickable(viewAllLink));
		actions.moveToElement(viewAllLink).click().build().perform();
		System.out.println(viewAllLink.isDisplayed());
		
		List<WebElement> trs = driver.findElements(By.xpath("/h1[text()='Attachments']/following::table//tbody//tr"));
		int size=trs.size();
		//h1[text()='Attachments']/following::table//tbody//tr
//		7. Click the dropdown icon for the recently attached document 
		//table//tbody//th//a[@title='Praveena Bootcamp']//following::td[6]//button
        //WebElement down = driver.findElement(By.xpath("//table//tbody//th//a[@title='Praveena Bootcamp']//following::td[6]//button"));
		 
		//table/tbody//tr//td//a//*[@data-key='down']
		
		driver.findElement(By.xpath("//h1[text()='Attachments']/following::table//tbody//tr[1]//td[5]")).click();
		//8. Select Delete and Confirm the delete 
        WebElement deleteElement = driver.findElement(By.xpath("//a//div[text()='Delete']"));
        actions.moveToElement(deleteElement).click().build().perform();
        
        driver.findElement(By.xpath("//span[text()='Delete']")).click();
//		9. Verify the file deleted from the Attachments 
        
		if(size==size-1 || size==0) {
			System.out.println("attached file deleted");
		}
		else
		{
			System.out.println("attached file not deleted");
		}
		//Expected Result: File should be removed from the attachements
		Thread.sleep(2000);
		driver.quit();
		
	}

}
