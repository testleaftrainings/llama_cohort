package sprint1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class LegalEntityWithoutMandatoryFields {
	
	@Test
	public void LegalEntityWithoutMandatoryFields() throws InterruptedException {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(options);
		
		driver.get("https://login.salesforce.com/?locale=in");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.findElement(By.id("username")).sendKeys("Gokul.sekar@testleaf.com");
		driver.findElement(By.id("password")).sendKeys("Leaf$321");
		driver.findElement(By.id("Login")).click();
		//To delete
		driver.findElement(By.xpath("//button[@title='App Launcher']")).click();
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		
		driver.findElement(By.xpath("//input[contains(@placeholder,'Search apps')]")).sendKeys("Legal Entities");
		driver.findElement(By.xpath("//*[text()='Legal Entities']")).click();
		driver.findElement(By.xpath("//span[text()='Legal Entities']/following::one-app-nav-bar-item-dropdown")).click();
		WebElement newlegal = driver.findElement(By.xpath("//span[text()='New Legal Entity']"));
		driver.executeScript("arguments[0].click()",newlegal);
		
		driver.findElement(By.xpath("//input[@name='CompanyName']")).sendKeys("TESTLEAF");
		driver.findElement(By.xpath("//label[text()='Description']//following::div/textarea")).sendKeys("SALESFORCE");
		
		WebElement status = driver.findElement(By.xpath("(//label[text()='Status']//following::button)[1]"));
		Actions aa = new Actions(driver);
		aa.scrollToElement(status).perform();
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()",status);
		
		driver.findElement(By.xpath("//span[text()='Active']")).click();
		driver.findElement(By.xpath("//li/following::button[text()='Save']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[text()='Legal Entity Name']")).click();
		
		WebElement outputscreen = driver.findElement(By.xpath("//div[text()='Complete this field.']"));
		if (outputscreen.isDisplayed()) {
			System.out.println(outputscreen.getText());
			outputscreen.equals("Complete this field.");
		}
			else {
				System.out.println(" is not present " + " Throw error ");
			}
		driver.quit();
		
	}



}
