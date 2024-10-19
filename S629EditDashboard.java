package salesforce.test.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

public class S629EditDashboard extends ReusableClass{
	
	@Test
    public void editDashboard() throws InterruptedException
    {
    	driver.findElement(By.xpath("//button[@title='App Launcher']")).click();

    	//    	Click view All and click Sales from App Launcher
    	driver.findElement(By.xpath("//button[text()='View All']")).click();    	
    	Thread.sleep(2000);
    	
    	performWaitandJSClick(driver.findElement(By.xpath("//a[@data-label='Dashboards']")));
    	
    	performWaitandJSClick(driver.findElement(By.xpath("//a[@title='Dashboards']")));
    	Thread.sleep(2000);
    	
    	wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//label[text()='Search recent dashboards...']/following-sibling::div/div/input"))));
    	
    	String searchStr = "Automation by Ilangovan";
    	
    	driver.findElement(By.xpath("//label[text()='Search recent dashboards...']/following-sibling::div/div/input")).sendKeys(searchStr);
    	
    	driver.findElement(By.xpath("//label[text()='Search recent dashboards...']/following-sibling::div/div/input")).sendKeys(Keys.ENTER);
    	
    	Thread.sleep(5000);
    	performWaitandJSClick(driver.findElement(By.xpath("//table/tbody/tr[1]//span[contains(text(),'Show actions')]/parent::button")));
    	performWaitandJSClick(driver.findElement(By.xpath("//span[text()='Edit']/parent::a")));
    	
    	Thread.sleep(15000);
    	
//    	wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//button[@title='Edit Dashboard Properties']"))));
    	driver.switchTo().frame(0);
    	
    	performWaitandJSClick(driver.findElement(By.xpath("//button[@title='Edit Dashboard Properties']")));
    	
    	String editedName = "SalesForce Automation by Ilangovan";
    	
    	driver.findElement(By.xpath("//label[text()='Name']/following::input[@id='dashboardNameInput']")).clear();
    	
    	driver.findElement(By.xpath("//label[text()='Name']/following::input[@id='dashboardNameInput']")).sendKeys(editedName);
    	
    	performWaitandClick(driver.findElement(By.xpath("//footer/button[text()='Save']")));
    	
    	String updatedName = driver.findElement(By.xpath("//button/span[text()='Edit Dashboard name']/ancestor::span")).getText();
    	
    	if(updatedName.contains(editedName))
    		{
    		System.out.println("Test Passed");
    		}
    	else
    	{
    		System.out.println("Test Failed");
    	}
    	
    	performWaitandClick(driver.findElement(By.xpath("//button[text()='Done']")));
    	
    	performWaitandClick(driver.findElement(By.xpath("//footer/button[text()='Save']")));
    	
    	String verifyText = driver.findElement(By.xpath("//h1/span[contains(text(),'"+editedName+"')]")).getText();
    	
    	if(verifyText.contains(editedName))
		{
		System.out.println("Test Passed");
		}
		else
		{
			System.out.println("Test Failed");
		}
    	
    }

}
