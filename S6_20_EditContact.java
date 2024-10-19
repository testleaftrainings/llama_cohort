package SDETSelenium;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class S6_20_EditContact {

	
	@Test
	public void editContact() throws InterruptedException
	{
		ChromeDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().window().maximize();
		driver.get("https://login.salesforce.com/");
		driver.findElement(By.id("username")).sendKeys("gokul.sekar@testleaf.com");
		driver.findElement(By.id("password")).sendKeys("Leaf$321");
		driver.findElement(By.id("Login")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//button[@title='App Launcher']/div")).click();
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		Actions actions=new Actions(driver);
		actions.moveToElement(driver.findElement(By.xpath("//p[text()='Contacts']"))).click().build().perform();
		driver.findElement(By.xpath("//div[contains(@class,'uiScroller')]")).sendKeys(Keys.END);
		WebElement table= driver.findElement(By.xpath("//table[contains(@class,'uiVirtualDataTable')]//tbody"));
		List<WebElement> table_rows=table.findElements(By.tagName("tr"));
		List<WebElement> col_rows= new ArrayList<WebElement>();
		for(int row=0;row<table_rows.size();row++)
		{
			col_rows=table_rows.get(row).findElements(By.xpath("//table[contains(@class,'uiVirtualDataTable')]//following::tbody//tr//th//a"));
			System.out.println(col_rows.get(row).getText());
		}
		driver.findElement(By.xpath("//input[@name='Contact-search-input']")).sendKeys("Dhanusha Ballikhana",Keys.ENTER);
		Thread.sleep(5000);
		driver.findElement(By.xpath("//span[text()='Show Actions']//ancestor::a")).click();
		driver.findElement(By.xpath("//a[@title='Edit']")).click();
		driver.findElement(By.xpath("//label[text()='Title']//following::input[@name='Title']")).sendKeys("Test");
		WebElement eledate=driver.findElement(By.xpath("//label[text()='Birthdate']//following::input[@name='Birthdate']"));
		eledate.clear();
		eledate.sendKeys("06/06/1993",Keys.TAB);
		Thread.sleep(5000);
		WebElement eleLeadSource=driver.findElement(By.xpath("//label[text()='Lead Source']//following::div[1]"));
		driver.executeScript("arguments[0].scrollIntoView()", eleLeadSource);
		eleLeadSource.click();
		driver.findElement(By.xpath("(//div[contains(@id,'dropdown-element')])[4]//following::span[text()='Purchased List']")).click();
		WebElement elePhone=driver.findElement(By.xpath("//label[text()='Phone']//following::input[@name='Phone']"));
		elePhone.clear();
		elePhone.sendKeys("5513449298");
		driver.findElement(By.xpath("//button[@name='SaveEdit']")).click();
		System.out.println(driver.findElement(By.xpath("//span[contains(@class,'forceOutputPhone')]")).getText());
		
		driver.quit();
		
	}
}
