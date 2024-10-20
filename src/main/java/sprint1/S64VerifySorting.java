package sprint1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

public class S64VerifySorting extends ReusableClass{

    @Test 
    public void verifySorted() throws InterruptedException {
    	//    	Click on toggle menu button from the left corner
    	driver.findElement(By.xpath("//button[@title='App Launcher']")).click();

    	//    	Click view All and click Sales from App Launcher
    	driver.findElement(By.xpath("//button[text()='View All']")).click();
    	wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//a//p[text()='Sales']"))));
    	driver.findElement(By.xpath("//a//p[text()='Sales']")).click();
    	
    	//    	Click on Accounts tab
    	WebElement eleAccounts = driver.findElement(By.xpath("//a[@title='Accounts']"));
    	wait.until(ExpectedConditions.visibilityOf(eleAccounts));
    	driver.executeScript("arguments[0].click()", eleAccounts);
    	
    	
    	String currentSort;
    	currentSort = driver.findElement(By.xpath("//span[@title='Account Name']/parent::a/following-sibling::span")).getText();
    	String Sort = "Ascending";
    	if(!currentSort.contains(Sort))
    	{
    		
    		driver.findElement(By.xpath("//span[@title='Account Name']/parent::a")).click();
    		wait.until(ExpectedConditions.textToBePresentInElement(driver.findElement(By.xpath("//span[@title='Account Name']/parent::a/following-sibling::span")), Sort));
    		currentSort = driver.findElement(By.xpath("//span[@title='Account Name']/parent::a/following-sibling::span")).getText();
    		if(currentSort.contains(Sort)) {
    		System.out.println("Current Sort is "+currentSort);
    		}
    	}   
    	// Table Handling
    	Thread.sleep(5000);
    	wait.until(ExpectedConditions.visibilityOfAllElements(driver.findElements(By.xpath("//table/tbody/tr/th//a[@data-refid='recordId']"))));
    	Thread.sleep(5000);
    	List<WebElement> accountNames = driver.findElements(By.xpath("//table/tbody/tr/th//a[@data-refid='recordId']"));
    	int actualCountSize = accountNames.size();
    	int totalCountSize = 0;
    	Actions action = new Actions(driver);
    	
    	//Scroll till End
    	while(actualCountSize > totalCountSize) {
    		totalCountSize = actualCountSize;
    		action.moveToElement(accountNames.get(accountNames.size()-1)).perform();
    		accountNames = driver.findElements(By.xpath("//table/tbody/tr/th//a[@data-refid='recordId']"));
    		actualCountSize = accountNames.size();
    		action.moveToElement(accountNames.get(accountNames.size()-1)).perform();
    	}
    	
    	//Iterate and get all text
    	List<String> accountNameText = new ArrayList<String>();
    	for(WebElement textElement : accountNames) {
    		accountNameText.add(textElement.getText());	
    		action.moveToElement(accountNames.get(accountNames.size()-1)).perform();
    	}
    	System.out.println(accountNameText);
    	List<String> sortedAccountNameText = new ArrayList<String>(accountNameText);
    	Collections.sort(sortedAccountNameText,String.CASE_INSENSITIVE_ORDER);
    	System.out.println(sortedAccountNameText);
    	
    	if(accountNameText.equals(sortedAccountNameText))
    	{
    		System.out.println("PASS : Verified Account Name is sorted in Ascending Order");
    	}
    	else 
    	{
    		System.out.println("FAIL : Account Name is not sorted in Ascending Order");	
    	}
    }
	
}
