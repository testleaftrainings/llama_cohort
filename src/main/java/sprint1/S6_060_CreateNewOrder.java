package sprint1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

public class S6_060_CreateNewOrder extends ReusableClass{

	@Test
	public void createNewOrder() throws InterruptedException
	{
		performWaitandClick(driver.findElement(By.xpath("//button[@title='App Launcher']")));

    	//    	Click view All and click Sales from App Launcher
		performWaitandClick(driver.findElement(By.xpath("//button[text()='View All']")));   	
    	Thread.sleep(2000);

//    	Click on  Service Console 
    	wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//a//p[text()='Service Console']"))));
    	driver.findElement(By.xpath("//a//p[text()='Service Console']")).click();
    	
//    	4. Click on the drop down and select Orders
    	Thread.sleep(3000);
    	performWaitandJSClick(driver.findElement(By.xpath("//a/span[text()]/following::button[1]")));
    	action.scrollToElement(driver.findElement(By.xpath("//a[@data-itemid='Order']"))).build().perform();
    	performWaitandJSClick(driver.findElement(By.xpath("//a[@data-itemid='Order']")));
    	
//    	5. Click on New
    	performWaitandClick(driver.findElement(By.xpath("//a[@title='New']")));
    	
//    	6. Select Account name as Testleaf Software
    	String accName = "Testleaf Software";
    	performWaitandClick(driver.findElement(By.xpath("//label[text()='Account Name']/following::input[1]")));
    	driver.findElement(By.xpath("//label[text()='Account Name']/following::input[1]")).sendKeys(accName);
    	performWaitandClick(driver.findElement(By.xpath("//ul[@role='group']/li//lightning-base-combobox-formatted-text[@title='"+accName+"']")));
    	
//    	7. Contract number as 00000133
    	String accContractNumber = "00000133";
    	performWaitandClick(driver.findElement(By.xpath("//label[text()='Contract Number']/following::input[1]")));
    	driver.findElement(By.xpath("//label[text()='Contract Number']/following::input[1]")).sendKeys(accContractNumber);
    	performWaitandClick(driver.findElement(By.xpath("//ul[@role='group']/li//lightning-base-combobox-formatted-text[@title='"+accContractNumber+"']")));
    	  	
//    	8. Status as Draft
    	performWaitandClick(driver.findElement(By.xpath("//button[@aria-label='Status']")));
    	Thread.sleep(2000);
    	action.moveToElement(driver.findElement(By.xpath("//span[@title='Draft']"))).click().build().perform();
    	
//    	9.Select Order Start Date as next month 10th date
//    	String currentDate = driver.findElement(By.xpath("//table[@class='slds-datepicker__month']//tbody/tr/td[@class='slds-is-today']/span")).getText();
//    	String currMonth = driver.findElement(By.xpath("//h2[@class='slds-align-middle']")).getText();
    	performWaitandClick(driver.findElement(By.xpath("//label[text()='Order Start Date']/following::input[1]")));
    	performWaitandJSClick(driver.findElement(By.xpath("//button[@title='Next Month']")));
    	performWaitandJSClick(driver.findElement(By.xpath("//table[@class='slds-datepicker__month']/tbody/tr/td/span[text()='10']")));
    	
//    	10. Click Save Expected Result:
    	performWaitandClick(driver.findElement(By.xpath("//button[@name='SaveEdit']")));
    	WebElement toastMessage = driver.findElement(By.xpath("//div[@role='alert' and @data-key='success']"));
//    	String orderID = driver.findElement(By.xpath("//div[@role='alert' and @data-key='success']//a/div")).getText();
    	if(toastMessage.isDisplayed())
    	{
    		String orderID = driver.findElement(By.xpath("//div[@role='alert' and @data-key='success']//a/div")).getText();
    		System.out.println("Order is Created : "+orderID);
    	}
    	else
    	{
    		System.out.println("Could not find Success Message");
    	}
    	
    	String expAccountName = driver.findElement(By.xpath("//p[@title='Account Name']/following-sibling::p//slot[text()]")).getText();
    	String expContactNumber = driver.findElement(By.xpath("//p[@title='Contract Number']/following-sibling::p//a//slot[text()]")).getText();
    	
    	if(accName.equals(expAccountName) && accContractNumber.equals(expContactNumber))
    	{
    		System.out.println("Test Passed");
    	}
    	else
    	{
    		System.out.println("Test Failed");
    	}
    	
	}
	
}
