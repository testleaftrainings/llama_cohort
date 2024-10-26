package sprint1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

public class S6_061_EditOrder extends ReusableClass{

	@Test
	public void editOrder() throws InterruptedException
	{
//	3. Click view All and click Service Console from App Launcher
		performWaitandClick(driver.findElement(By.xpath("//button[@title='App Launcher']")));

    	//    	Click view All and click Sales from App Launcher
		performWaitandClick(driver.findElement(By.xpath("//button[text()='View All']")));   	
    	Thread.sleep(2000);

//    	Click on  Orders
    	performWaitandJSClick(driver.findElement(By.xpath("//a[@data-label='Orders']")));
    	
//	5.Click drop down near Recently Viewed and Select All Orders
    	performWaitandClick(driver.findElement(By.xpath("//span[text()='Recently Viewed']/following::button[1]")));
    	performWaitandClick(driver.findElement(By.xpath("//li/a/span[text()='All Orders']")));
    	
    	
//	6. Select first result, click the dropdown of the result and click on Edit
    	Thread.sleep(5000);
    	performWaitandClick(driver.findElement(By.xpath("(//table/tbody/tr)[1]/td[8]")));
    	performWaitandClick(driver.findElement(By.xpath("//a[@title='Edit']")));
    	
//	7.Click on the close button form the Account Name Field and Select Account name as Testing001
    	performWaitandClick(driver.findElement(By.xpath("//label[text()='Account Name']/following::button[1]")));
    	String accName = "Testing001";
    	performWaitandClick(driver.findElement(By.xpath("//label[text()='Account Name']/following::input[1]")));
    	driver.findElement(By.xpath("//label[text()='Account Name']/following::input[1]")).sendKeys(accName);    	
    	performWaitandClick(driver.findElement(By.xpath("//ul[@role='group']/li//lightning-base-combobox-formatted-text[@title='"+accName+"']")));
    	
//	8.Click on the close button form theContract Number field and select Contract number as 00000104
    	performWaitandClick(driver.findElement(By.xpath("//label[text()='Contract Number']/following::button[1]")));
    	String accContractNumber = "00000132";
    	performWaitandClick(driver.findElement(By.xpath("//label[text()='Contract Number']/following::input[1]")));
    	driver.findElement(By.xpath("//label[text()='Contract Number']/following::input[1]")).sendKeys(accContractNumber);
    	performWaitandClick(driver.findElement(By.xpath("//ul[@role='group']/li//lightning-base-combobox-formatted-text[@title='"+accContractNumber+"']")));
    	
    	
//	9. Click Save Expected Result:
    	performWaitandClick(driver.findElement(By.xpath("//button[@name='SaveEdit']")));
//    	wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@role='alert' and @data-key='success']"))));
//    	WebElement toastMessage = driver.findElement(By.xpath("//div[@role='alert' and @data-key='success']"));
//    	if(toastMessage.isDisplayed())
//    	{
//    		String orderID = driver.findElement(By.xpath("//div[@role='alert' and @data-key='success']//a/div")).getText();
//    		System.out.println("Order is Updated : "+orderID);
//    	}
//    	else
//    	{
//    		System.out.println("Could not find Success Message");
//    	}
    	String updatedAccountName = driver.findElement(By.xpath("(//table/tbody/tr)[1]/td[3]//a")).getText();
    	String updatedContractNumber = driver.findElement(By.xpath("(//table/tbody/tr)[1]/td[7]//a")).getText();
    	
    	if(updatedAccountName.equals(accName) && updatedContractNumber.equals(accContractNumber))
    	{
    		System.out.println("Test Passed");
    	}
    	else
    	{
    		System.out.println("Test Failed");
    	}
    	
    	
	}
}
