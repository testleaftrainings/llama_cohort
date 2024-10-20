package sprint1;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

public class S653CreateLeadforCampaign extends ReusableClass{

	@Test
	public void createLeadforCanpaign() throws InterruptedException
	{
		Actions action = new Actions(driver);
		driver.findElement(By.xpath("//button[@title='App Launcher']")).click();

    	//    	Click view All and click Sales from App Launcher
    	driver.findElement(By.xpath("//button[text()='View All']")).click();    	
    	Thread.sleep(2000);

//    	Click on  Campaigns 
    	performWaitandJSClick(driver.findElement(By.xpath("//a[@data-label='Campaigns']")));

//    	Click Bootcamp link 
    	performWaitandClick(driver.findElement(By.xpath("(//table/tbody/tr[1]/th//a)[1]")));

//    	Click Add Leads
    	performWaitandJSClick(driver.findElement(By.xpath("//a[@title='Add Leads']")));
    	
//    	Click on the Search filed and click New Lead
    	performWaitandClick(driver.findElement(By.xpath("//input[@role='combobox']")));
    	Thread.sleep(5000);
    	WebElement newLeadsButton = driver.findElement(By.xpath("//span[@title='New Lead']"));
//    	action.moveToElement(newLeadsButton).click().build().perform();
    	driver.executeScript("arguments[0].click()", newLeadsButton);
    	
//    	Pick Salutation as 'Mr.' 
    	wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//h1[text()='New Lead']"))));
    	performWaitandClick(driver.findElement(By.xpath("//span[text()='Salutation']/following::a[1]")));
    	performWaitandClick(driver.findElement(By.xpath("//a[text()='Mr.']")));
    	
//    	Enter first name as <your First Name> 
    	driver.findElement(By.xpath("//span[text()='First Name']/following::input[1]")).sendKeys("Jerome");

//    	Enter last name as <your last name> 
    	driver.findElement(By.xpath("//span[text()='Last Name']/following::input[1]")).sendKeys("JKR");

//    	Enter company as 'TestLeaf' 
    	driver.findElement(By.xpath("(//span[text()='Company']/following::input[1])[2]")).sendKeys("TestLeaf");

//    	Click Save 
    	performWaitandClick(driver.findElement(By.xpath("//button[@title='Save']")));

//    	Click Next 
    	performWaitandClick(driver.findElement(By.xpath("//button[text()='Next']")));
    	
//    	Click Submit on the Add to Campaign pop up 
    	performWaitandClick(driver.findElement(By.xpath("//button[text()='Submit']")));

//    	verify the created Lead under Campaign 
//    	Navigate to Leads tab 
    	performWaitandJSClick(driver.findElement(By.xpath("//a[@title='Leads']")));
    	
//    	Search for Lead with your Name  
    	performWaitandClick(driver.findElement(By.xpath("//input[@name='Lead-search-input']")));
    	driver.findElement(By.xpath("//input[@name='Lead-search-input']")).sendKeys("Jerome");
    	driver.findElement(By.xpath("//input[@name='Lead-search-input']")).sendKeys(Keys.ENTER);

//    	Expected Result: Lead should be created in Leads tab and associated to Campaign
    	Thread.sleep(5000);
    	String nameVerify = driver.findElement(By.xpath("(//table/tbody/tr[1]/th)[1]//a")).getText();
    		if(nameVerify.equals("Jerome JKR"))
    			{
    				System.out.println("Test Passed");
    			}
    		else
    		{
    			System.out.println("Test Failed");
    		}
	}
}
