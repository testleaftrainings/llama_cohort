package salesforce.test.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class S616DeleteOpportunity extends ReusableClass{

	 @Test
	    public void deleteOpurtunity() throws InterruptedException
	    {
	    	driver.findElement(By.xpath("//button[@title='App Launcher']")).click();

	    	//    	Click view All and click Sales from App Launcher
	    	driver.findElement(By.xpath("//button[text()='View All']")).click();    	
	    	performWaitandClick(driver.findElement(By.xpath("//a//p[text()='Sales']")));
	    	
	    	//Click Opportunities Button
	    	performWaitandJSClick(driver.findElement(By.xpath("//a[@title='Opportunities']")));
	    	
	    	//Search the Opportunity 'Salesforce Automation by *Your Name*' 
	    	driver.findElement(By.xpath("//div[@type='search']/input[@type='search']")).sendKeys("Salesforce Automation by Gokul");
	    	Thread.sleep(2000);   	
	    	driver.findElement(By.xpath("//div[@type='search']/input[@type='search']")).sendKeys(Keys.ENTER);
	    	Thread.sleep(2000);
	    	Actions actions = new Actions(driver);
	    	actions.moveToElement(driver.findElement(By.xpath("//span[@role='status']"))).click().perform();
	    	Thread.sleep(2000);
	    	String valueBeforeDeletion = driver.findElement(By.xpath("//span[@role='status']")).getText();
	    	String[] str = valueBeforeDeletion.split(" ");
	    	int numBefore = Integer.parseInt(str[0]);
	    	
	    	//Click on the Dropdown icon and Select Delete 
	    	performWaitandJSClick(driver.findElement(By.xpath("//table/tbody/tr[1]//span[contains(text(),'Show Actions')]/parent::*/parent::a")));
	    	performWaitandJSClick(driver.findElement(By.xpath("//div[@role='menu']/ul/li/a[@title='Delete']")));
	    	performWaitandClick(driver.findElement(By.xpath("//button[@title='Delete']")));
	    	
	    	//
	    	Thread.sleep(3000);
	    	String valueAfterDeletion = driver.findElement(By.xpath("//span[@role='status']")).getText();
	    	String[] str1 = valueAfterDeletion.split(" ");
	    	int numAfter = Integer.parseInt(str1[0]);
	    	
	    	if(numBefore-1 == numAfter) {
	    		System.out.println("Test Passed");
	    	}
	    }	
	
}
