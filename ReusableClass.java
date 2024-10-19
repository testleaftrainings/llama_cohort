package salesforce.test.automation;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;

public class ReusableClass {
	
	static ChromeDriver driver;
	static WebDriverWait wait;
	static Actions action;
	
	@BeforeSuite
    public void initializeBrowserAndLogin()
    {
    	//Initialize Driver and Start App
    	ChromeOptions options = new ChromeOptions();       
        // Add argument to disable notifications
        options.addArguments("--disable-notifications");
    	driver = new ChromeDriver(options);
    	driver.get("https://login.salesforce.com/");
    	driver.manage().window().maximize();
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    	
    	//    	Step 1: Login to Login | Salesforce  
    	String username = "gokul.sekar@testleaf.com";
    	String password = "Leaf$321";
    	driver.findElement(By.id("username")).sendKeys(username);
    	driver.findElement(By.id("password")).sendKeys(password);
    	driver.findElement(By.id("Login")).click();
    	wait = new WebDriverWait(driver, Duration.ofSeconds(25));
    	wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//button[@title='App Launcher']"))));
    	action = new Actions(driver);
    }
	
	@AfterTest
    public void TearDownStep()
    {	
    	driver.quit();
    }
	
	public void performWaitandClick(WebElement element) throws InterruptedException
    {
    	Thread.sleep(2000);
    	wait.until(ExpectedConditions.visibilityOf(element));
    	element.click();
    	Thread.sleep(2000);
    }
    
    public void performWaitandJSClick(WebElement element) throws InterruptedException
    {
    	Thread.sleep(2000);
    	wait.until(ExpectedConditions.visibilityOf(element));
    	driver.executeScript("arguments[0].click()", element);
    	Thread.sleep(2000);
    }
    
    public void chooseContacts(String contactName) throws InterruptedException
    {
    	Thread.sleep(2000);
    	driver.findElement(By.xpath("//label[text()='Contact Name']/following-sibling::div//input")).sendKeys(contactName);
    	driver.findElement(By.xpath("//*[contains(text(),'"+contactName+"')]/parent::lightning-base-combobox-formatted-text[contains(@title,'"+contactName+"')]")).click();
    	Thread.sleep(2000);
    }
	

}
