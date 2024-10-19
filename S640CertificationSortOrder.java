package salesforce.test.automation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class S640CertificationSortOrder extends ReusableClass{
	
	@Test
	public void certificationsSortOrder() throws InterruptedException
	{
//		Click on the sliding icon until 'See System Status' is displayed.
//		Click on Get Started link
		boolean flag=true,temp;
		
		while (flag) {
			temp=driver.findElement(By.xpath("//span[text()='See System Status']")).isDisplayed();
			if(temp)
			{
				driver.findElement(By.xpath("//span[text()='See System Status']/following::button[1]")).click();
				flag=false;
			}
			else driver.findElement(By.xpath("//div[@class='rightScroll']/button")).click();
		}
		
		//Click confirm on the redirecting page and navigate to SalesForce Trust new Window.
		
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> windows= new ArrayList<String>(windowHandles);
		driver.switchTo().window(windows.get(1));
		driver.findElement(By.xpath("//button[@onclick='goAhead()']")).click();
		Thread.sleep(5000);

//		Click on the Compliance
		performWaitandJSClick(driver.findElement(By.xpath("//a[text()='Compliance']")));

//		Click on the Documents
		performWaitandJSClick(driver.findElement(By.xpath("//a[text()='Documents']")));

//		Click on the 'Name' to sort name in Ascending order
		boolean sort = true;
		while(sort) 
		{
			String sorting = driver.findElement(By.xpath("//table/thead/tr/th[contains(@aria-label,'Name')]")).getAttribute("aria-sort");
			if(!sorting.equals("ascending"))
			{
				performWaitandClick(driver.findElement(By.xpath("//table/thead/tr/th/span[text()='Name']")));
			}
			sorting = driver.findElement(By.xpath("//table/thead/tr/th[contains(@aria-label,'Name')]")).getAttribute("aria-sort");
			if(sorting.equals("ascending"))
			{
				sort = false;
			}			
		}

//		Verify the Documents are displayed in alphabetical order 
		List<WebElement> docNameListElements = driver.findElements(By.xpath("//table/tbody/tr/td[1]/a"));
		Thread.sleep(2000);
		List<String> docNameList = new ArrayList<>();
		for(WebElement eachDoc : docNameListElements)
		{
			docNameList.add(eachDoc.getText());
		}
		System.out.println(docNameList);
		
		List<String> sortedDocNameList = new ArrayList<String>(docNameList);
		Collections.sort(sortedDocNameList,String.CASE_INSENSITIVE_ORDER);
		System.out.println(sortedDocNameList);
		Thread.sleep(2000);
		
//		Expected Result: The order should be in the alphabetical order  
		if(docNameList.equals(sortedDocNameList))
		{
			System.out.println("Test Passed");
		}
		else
		{
			System.out.println("Test Failed");
		}
		
	}
}
