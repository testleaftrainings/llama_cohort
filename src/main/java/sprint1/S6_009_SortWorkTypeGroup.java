package sprint1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class S6_009_SortWorkTypeGroup {

	
	@Test
	public void sortWorkGroup() throws InterruptedException
	{
		ChromeDriver driver= new ChromeDriver();
		driver.get("https://login.salesforce.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().window().maximize();
		driver.findElement(By.id("username")).sendKeys("gokul.sekar@testleaf.com");
		driver.findElement(By.id("password")).sendKeys("Leaf$321");
		driver.findElement(By.id("Login")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//button[@title='App Launcher']/div")).click();
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		//Click work type group on View All
		Actions actions=new Actions(driver);
		actions.moveToElement(driver.findElement(By.xpath("//p[text()='Work Type Groups']"))).click().build().perform();
		Thread.sleep(5000);
		//5. Click the sort arrow in the Work Type Group Name 
		WebElement eleWork=driver.findElement(By.xpath("//span[@title='Work Type Group Name']"));
		driver.executeScript("arguments[0].click()", eleWork);	
		Thread.sleep(5000);
		//scroll down the page
	driver.findElement(By.xpath("//div[contains(@class,'uiScroller')]")).sendKeys(Keys.END);
		Thread.sleep(3000);
		//6. Verify the Work Type Group displayed in ascending order by Work Type Group Name.
		WebElement table=driver.findElement(By.xpath("//table[contains(@class,'uiVirtualDataTable')]//tbody"));
		List<WebElement> rowsTable= table.findElements(By.tagName("tr"));
		System.out.println(rowsTable.size());
		List<WebElement> colTable=new ArrayList<WebElement>();
		List<String> colNames=new ArrayList<String>();
		for(int row=0;row<rowsTable.size();row++)
		{
			colTable=(rowsTable.get(row).findElements(By.xpath("//table[contains(@class,'uiVirtualDataTable')]//tbody//tr//th//a")));
			colNames.add(colTable.get(row).getText());
			System.out.println(colNames.get(row));
		}
	List<String> compareNames=new ArrayList<String>();
		
		for(int i=0;i<colNames.size();i++)
		{
			compareNames.add(colNames.get(i));
		}
		Collections.sort(compareNames,String.CASE_INSENSITIVE_ORDER);
		for(int i=0;i<compareNames.size();i++)
		{
			System.out.println(compareNames.get(i));
		}
		
		if(colNames.equals(compareNames))
		System.out.println("Work Type group is in ascending order");
		else
			System.out.println("Work Type group is in descending order");	
		
		driver.quit();
		
		
	}
}
