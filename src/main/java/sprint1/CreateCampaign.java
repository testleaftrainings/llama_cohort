package sprint1;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class CreateCampaign {

	@Test
	public void CreateCampaign() throws InterruptedException, MalformedURLException {
		
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setBrowserName("chrome");
		dc.setPlatform(Platform.LINUX);
		RemoteWebDriver driver = new RemoteWebDriver(new URL("http://20.40.48.160:4444/wd/hub"), dc);
		//ChromeDriver driver = new ChromeDriver();
		driver.get("https://login.salesforce.com/");
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		
		//ChromeDriver driver = new ChromeDriver(options);
		//driver.get("https://login.salesforce.com/?locale=in");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.findElement(By.id("username")).sendKeys("Gokul.sekar@testleaf.com");
		driver.findElement(By.id("password")).sendKeys("Leaf$321");
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
			WebElement newcampaign = driver.findElement(By.xpath("//span[text()='New Campaign']"));
			driver.executeScript("arguments[0].click()",newcampaign);
			driver.findElement(By.xpath("//div//span[text()='Campaign Name']/following::input")).sendKeys("Bootcamp");
			String retrive = driver.findElement(By.xpath("//div//span[text()='Campaign Name']/following::input")).getAttribute("value");
			System.out.println(retrive);
		
			WebElement status = driver.findElement(By.xpath("//label/span[text()='Start Date']//following::div"));
			Actions sd = new Actions(driver);
			sd.scrollToElement(status).perform();
			
			driver.findElement(By.xpath("//label/span[text()='Start Date']//following::div")).click();
			LocalDate today = LocalDate.now();
			String tomorrow = (today.plusDays(20)).format(DateTimeFormatter.ISO_DATE);
			String[] split = tomorrow.split("-");
			String date = split[2];
			Thread.sleep(3000);
			driver.findElement(By.xpath("//table[@class='calGrid']//tbody//td//span[text()='" + date + "']")).click();
			WebElement status1 = driver.findElement(By.xpath("(//label/span[text()='End Date']//following::input)[1]"));
			Actions nd = new Actions(driver);
			nd.scrollToElement(status1).perform();
			driver.findElement(By.xpath("(//label/span[text()='End Date']//following::input)[1]")).click();
			String dayaftertomorrow = (today.plusDays(2)).format(DateTimeFormatter.ISO_DATE);
			String[] splitnextday = dayaftertomorrow.split("-");
			String nextdate =splitnextday[2];
			driver.findElement(By.xpath("//table[@class='calGrid']//tbody//td//span[text()='" + nextdate + "']")).click();
			driver.findElement(By.xpath("(//span[text()='Save'])[1]")).click();
			driver.quit();
	}
}

