package salesforce.test.automation;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class S623CreateLegalEntity extends ReusableClass{
	
	@Test
	public void createLegalEntity() throws InterruptedException 
	{
		driver.findElement(By.xpath("//button[@title='App Launcher']")).click();

    	//    	Click view All and click Sales from App Launcher
    	driver.findElement(By.xpath("//button[text()='View All']")).click();    	
    	Thread.sleep(2000);
    	
    	performWaitandJSClick(driver.findElement(By.xpath("//a[@data-label='Legal Entities']")));
    	
    	performWaitandJSClick(driver.findElement(By.xpath("(//a[contains(@title,'Legal Entities')]/following::one-app-nav-bar-item-dropdown//a[@role='button'])[2]")));
	
    	performWaitandJSClick(driver.findElement(By.xpath("//span[text()='New Legal Entity']/ancestor::a")));
    	
    	//      Salesforce Automation by Jerome  
    	String legalEntityName = "Salesforce Automation by Manoj";
    	driver.findElement(By.xpath("//label[text()='Legal Entity Name']/following-sibling::div/input")).sendKeys(legalEntityName);
    	
    	performWaitandClick(driver.findElement(By.xpath("//button[@name='SaveEdit']")));
    	Thread.sleep(5000);
    	String expectedName = driver.findElement(By.xpath("//h1/slot/lightning-formatted-text[@slot='primaryField']")).getText();
    	
    	if(expectedName.equals(legalEntityName))
    	{
    		System.out.println("Test Passed : Legal Entity is Created");
    	}
    	else
    	{
    		System.out.println("Test Failed");
    	}
	}
	
}
