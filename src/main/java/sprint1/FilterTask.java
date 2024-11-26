package sprint1;


import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class FilterTask {

@Test
	
	public void FilterTask() throws InterruptedException {
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		
		ChromeDriver driver = new ChromeDriver(options);
		driver.get("https://login.salesforce.com/?locale=in");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.findElement(By.id("username")).sendKeys("Gokul.sekar@testleaf.com");
		driver.findElement(By.id("password")).sendKeys("Leaf@123");
		driver.findElement(By.id("Login")).click();
		
		driver.findElement(By.xpath("//button[@title='App Launcher']")).click();
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		
		driver.findElement(By.xpath("//input[contains(@placeholder,'Search apps')]")).sendKeys("Content");
		driver.findElement(By.xpath("//p/mark[text()='Content']")).click();
		Thread.sleep(3000);
		
		WebElement todaytask = driver.findElement(By.xpath("//div/h2//span[text()='Today’s Tasks']"));
		Actions ft = new Actions(driver);
		ft.scrollToElement(todaytask).perform();
		driver.findElement(By.xpath("(//div/a//span[text()='View All'])[2]")).click();
		
		driver.findElement(By.xpath("//div/button[@title='Select a List View: Tasks']")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		WebElement opentask = driver.findElement(By.xpath("(//div/li)[3][@role='row']"));
		Actions ot = new Actions(driver);
		ot.scrollToElement(opentask).perform();
		WebElement opetask = driver.findElement(By.xpath("(//span[text()='Open Tasks'])[1]"));
		driver.executeScript("arguments[0].click()",opetask);
		
		driver.findElement(By.xpath("//div[@title='Select list display']")).click();
		Thread.sleep(5000);
		
		WebElement listtable = driver.findElement(By.xpath("(//a[@role='menuitemcheckbox'])[1]"));
		driver.executeScript("arguments[0].click()",listtable);
		driver.findElement(By.xpath("//button[@title='Filters']")).click();
		driver.findElement(By.xpath("//div[text()='Filter by Owner']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div/following::button/span[text()='Done']")).click();
		
		WebElement scrollfilter = driver.findElement(By.xpath("//div[@class='addFilterRemoveAll']"));
		Actions filter = new Actions(driver);
		filter.scrollToElement(scrollfilter).perform();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[text()='Add Filter']")).click();
		
		driver.findElement(By.xpath("(//span[text()='Assigned Alias'])[2]")).click();
		WebElement scroll = driver.findElement(By.xpath("//div/lightning-base-combobox-item[@data-value='Status']"));
		Actions fil1 = new Actions(driver);
		fil1.scrollToElement(scroll).perform();
		driver.findElement(By.xpath("(//span[text()='Status'])[3]")).click();
		
		driver.findElement(By.xpath("//a[text()='0 options selected']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[text()='In Progress']")).click();
		
		driver.findElement(By.xpath("//button/span[text()='Done']")).click();
		driver.findElement(By.xpath("//button[text()='Save']")).click();
		
		driver.quit();
		
	}

}

