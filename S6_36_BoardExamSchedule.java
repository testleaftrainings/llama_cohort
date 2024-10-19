package SDETSelenium;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import javax.swing.plaf.basic.BasicTabbedPaneUI.TabSelectionHandler;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class S6_36_BoardExamSchedule {
	
	@Test
	public void boardExam() throws InterruptedException
	{

		ChromeOptions options=new ChromeOptions();
		options.addArguments("--disable-notifications");
		ChromeDriver driver=new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().window().maximize();
		driver.get("https://login.salesforce.com/");
		driver.findElement(By.id("username")).sendKeys("gokul.sekar@testleaf.com");
		driver.findElement(By.id("password")).sendKeys("Leaf$321");
		driver.findElement(By.id("Login")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//span[text()='Learn More']")).click();
		List<String> tabs=new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
		driver.findElement(By.xpath("//button[text()='Confirm']")).click();
		Thread.sleep(10000);
		//This Element is inside single shadow DOM.
		//SearchContext shadow = driver.findElement(By.cssSelector("#global-nav")).getShadowRoot();
		SearchContext shadow = driver.findElement(By.cssSelector("#main-menu > ul > li:nth-child(4) > div.c360-nav__nav-item-h3")).getShadowRoot();
		Thread.sleep(1000);
		shadow.findElement(By.cssSelector("#main-menu > ul > li:nth-child(4) > div.c360-nav__nav-item-h3 > hgf-button > span.nav-item-label--l1")).click();
		WebElement eleLearn=driver.findElement(By.xpath("//span[text()='Learning']"));
		//driver.executeScript("arguments[0].click()", eleLearn);
		Actions actions=new Actions(driver);
		actions.moveToElement(driver.findElement(By.xpath("//span[text()='Learning on Trailhead']"))).build().perform();
		driver.findElement(By.linkText("Salesforce Certification")).click();
	}

}
