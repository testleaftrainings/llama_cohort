package salesforce.test.automation;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class S610CreateCase extends ReusableClass {

    @Test
    public void verifyCreateCase() throws InterruptedException {
    	//    	Click on toggle menu button from the left corner
    	driver.findElement(By.xpath("//button[@title='App Launcher']")).click();

    	//    	Click view All and click Sales from App Launcher
    	driver.findElement(By.xpath("//button[text()='View All']")).click();    	
    	performWaitandClick(driver.findElement(By.xpath("//a//p[text()='Sales']")));
    	
    	//Click More Button
    	performWaitandClick(driver.findElement(By.xpath("//span[text()='More']")));
    	
    	//    	Click on Cases Option
    	performWaitandJSClick(driver.findElement(By.xpath("//a[@role='menuitem']/span/span[text()='Cases']")));
    	
    	//    	Click on New Case
    	performWaitandClick(driver.findElement(By.xpath("//a[@role='button']/div[text()='New']")));
    	 	
    	//Verify New Case Window
    	String newCaseHeading = driver.findElement(By.xpath("//h2[text()='New Case']")).getText();
    	Assert.assertEquals("New Case", newCaseHeading);
    	
    	//    	Choose Contact Name from the dropdown
    	chooseContacts("Singam");  	
    	
		//    	Select Case origin as email
    	performWaitandClick(driver.findElement(By.xpath("//label[text()='Case Origin']/following-sibling::div//button")));
    	performWaitandClick(driver.findElement(By.xpath("//span[@title='Email']/parent::span")));
		
    	//    	Select status as Escalated
    	performWaitandClick(driver.findElement(By.xpath("//label[text()='Status']/following-sibling::div//button")));
    	performWaitandClick(driver.findElement(By.xpath("//span[@title='Escalated']/parent::span")));
    	
		//    	Enter Subject as 'Testing' and description as 'Dummy'
    	driver.findElement(By.xpath("//label[text()='Subject']/following-sibling::div//input")).sendKeys("Testing");
    	driver.findElement(By.xpath("//label[text()='Description']/following-sibling::div//textarea")).sendKeys("Dummy");
    	 	
		//    	Click 'Save' and verify the message
    	performWaitandClick(driver.findElement(By.xpath("//button[@name='SaveEdit']")));
    }
}
