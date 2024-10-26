package sprint1;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class S6_62_CreateNewTask extends ReusableClass{
	
	@Test
	public void createNewTask() throws InterruptedException {
		
		driver.findElement(By.xpath("//button[@title='App Launcher']")).click();

    	//    	Click view All and click Sales from App Launcher
    	driver.findElement(By.xpath("//button[text()='View All']")).click();    	
    	Thread.sleep(2000);
 
//    	4. Click on Content tab 
    	performWaitandClick(driver.findElement(By.xpath("//a//p[text()='Content']")));
    	
//    	5. Click View All from Today's Task
    	performWaitandClick(driver.findElement(By.xpath("//span[text()='Today’s Tasks']/ancestor::article//a")));
    	
//    	6. Click on Show one more Action and click New Task
    	performWaitandClick(driver.findElement(By.xpath("//span[text()='Show more actions']/ancestor::a")));
    	performWaitandClick(driver.findElement(By.xpath("//a[@title='New Task']")));
    	
//    	7. Select a Account Name in Assigned to field 
    	List<WebElement> pillContainers = driver.findElements(By.xpath("//a[@class='deleteAction']"));   	
    	for(WebElement eachPill : pillContainers)
    	{
    		if(eachPill.isDisplayed())
    		{
    			performWaitandClick(driver.findElement(By.xpath("//a[@class='deleteAction']")));
    			Thread.sleep(2000);
    		}
    	}
    	String AssigneeName = "jeyagokul sekar";
    	driver.findElement(By.xpath("//label/span[text()='Assigned To']/following::input[1]")).sendKeys(AssigneeName);
    	performWaitandClick(driver.findElement(By.xpath("//a[@role='option']//div[@title='"+AssigneeName+"']")));
    	
//    	8. Select a subject as Email
    	driver.findElement(By.xpath("//label[text()='Subject']/following::input[1]")).sendKeys("Email");
    	
//    	9. Set Priority as High and Status as In Progress
    	String priority = driver.findElement(By.xpath("//span[@data-aura-class='uiPicklistLabel']/span[text()='Priority']")).getAttribute("id");
    	performWaitandClick(driver.findElement(By.xpath("//a[@aria-describedby='"+priority+"']")));
    	
    	String prioSelection = "High";
    	performWaitandClick(driver.findElement(By.xpath("//a[@title='"+prioSelection+"']")));
    	
//    	10. Click on the image of Name field, click on Contacts and select Contact
    	performWaitandClick(driver.findElement(By.xpath("//label/span[text()='Name']/following::img[1]")));
    	performWaitandClick(driver.findElement(By.xpath("//a[@title='Contacts']")));
    	String nameValue = "Naveen Elumalai";
    	driver.findElement(By.xpath("//label/span[text()='Name']/following::input[1]")).sendKeys(nameValue);
    	performWaitandClick(driver.findElement(By.xpath("(//div[@title='"+nameValue+"']/ancestor::a)[1]")));
    	
//    	11. Click on the image of Related To field, click on Product and Select Product
    	performWaitandClick(driver.findElement(By.xpath("//label/span[text()='Related To']/following::img[1]")));
    	performWaitandClick(driver.findElement(By.xpath("//a[@title='Products']")));
    	String productValue = "JeyaGokul";
    	driver.findElement(By.xpath("//label/span[text()='Related To']/following::input[1]")).sendKeys(productValue);
    	performWaitandClick(driver.findElement(By.xpath("(//div[@title='"+productValue+"']/ancestor::a)[1]")));    	
    	
//    	12. Click Save Expected Result:
    	performWaitandClick(driver.findElement(By.xpath("//button[@title='Save']")));
    	
    	String nameCheck = driver.findElement(By.xpath("(//dt[@title='Name']/following::a)[1]")).getText();
    	String prodCheck = driver.findElement(By.xpath("(//dt[@title='Related To']/following::a)[1]")).getText();
    	String prioCheck = driver.findElement(By.xpath("(//span[text()='Priority']/following::span[text()])[1]")).getText();
    	
    	if(nameCheck.equals(nameValue) && prodCheck.equals(productValue) && prioCheck.equals(prioSelection))
    	{
    		System.out.println("Test Passed");
    	}
    	else
    	{
    		System.out.println("Test Failed");
    	}
    	
	}
	
}
