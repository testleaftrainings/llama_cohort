package sprint1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class NewChart {

	@Test
	public void NewChart() throws InterruptedException {
		
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
		driver.findElement(By.xpath("(//*[text()='Content'])[2]")).click();
		Thread.sleep(3000);
		
		WebElement todaytask = driver.findElement(By.xpath("//div/h2[@class='header-title-container']/following::span[text()='Key Deals - Recent Opportunities']"));
		Actions tt = new Actions(driver);
		tt.scrollToElement(todaytask).perform();
		WebElement campfield = driver.findElement(By.xpath("(//div/a/following::span[text()='View All'])[2]"));
		driver.executeScript("arguments[0].click()",campfield);
		
		driver.findElement(By.xpath("//h1/span[text()='Recently Viewed']")).click();
		
		WebElement opentask = driver.findElement(By.xpath("(//div[@class='listContent'])[2]//span[text()='Open Tasks']"));
		Actions ot = new Actions(driver);
		ot.scrollToElement(opentask).perform();
		WebElement otask = driver.findElement(By.xpath("//span[text()='Open Tasks']"));
		driver.executeScript("arguments[0].click()",otask);
		
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@title='Select list display']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//ul/li[@title='Display as table']")).click();
	
		driver.findElement(By.xpath("//span/button[@title='Charts']")).click();
		
		WebElement progress = driver.findElement(By.xpath("//div/ul[@id='chartInfo']"));
		Actions gress = new Actions(driver);
		gress.scrollToElement(progress).perform();
		WebElement settingscroll = driver.findElement(By.xpath("//a//span[text()='Settings']"));
		driver.executeScript("arguments[0].click()",settingscroll);
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//a[text()='New Chart']")).click();
		//driver.findElement(By.xpath("(//label[text()='Chart Name']/following::div)[1]")).sendKeys("Opened Task");
		driver.findElement(By.xpath("(//div/input[@type='text'])[2]")).sendKeys("Opened Task");
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//div/label[text()='Chart Type']/following::button)[1]")).click();
		Thread.sleep(3000);
		WebElement donut = driver.findElement(By.xpath("//span[text()='Donut Chart']"));
		driver.executeScript("arguments[0].click()",donut);
		Thread.sleep(3000);
		WebElement aggreatefield = driver.findElement(By.xpath("//div/label[text()='Grouping Field']"));
		Actions af = new Actions(driver);
		af.scrollToElement(aggreatefield).perform();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@name='aggregateFieldPicklist']")).click();
		
		WebElement aggrefield = driver.findElement(By.xpath("//div//span[text()='Recurrence Activity']"));
		Actions prior = new Actions(driver);
		prior.scrollToElement(aggrefield).perform();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//span[text()='Priority'])[3]")).click();
		
		WebElement groupfield = driver.findElement(By.xpath("//button[@name='groupByPicklist']"));
		Actions gf = new Actions(driver);
		gf.scrollToElement(groupfield).perform();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@name='groupByPicklist']")).click();
		
		WebElement status = driver.findElement(By.xpath("(//div//span[@title='Task Subtype'])[2]"));
		Actions ss = new Actions(driver);
		prior.scrollToElement(status).perform();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//span[text()='Status'])[5]")).click();
		
		driver.findElement(By.xpath("(//button/span[text()='Save'])[2]")).click();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("(//canvas[@class='chart'])[2]"))));
		WebElement mouseover = driver.findElement(By.xpath("(//canvas[@class='chart'])[2]"));
		Actions mo = new Actions(driver);
		mo.moveToElement(mouseover, 550, 420).pause(2000).click().perform();
		
		
		driver.findElement(By.xpath("//a/span[text()='Status']")).click();
//		WebDriverWait columnstatus = new WebDriverWait(driver, Duration.ofSeconds(30));
//		columnstatus.until(ExpectedConditions.elementToBeSelected(driver.findElement(By.xpath("//div[text()='In Progress']"))));
		WebElement statushower = driver.findElement(By.xpath("//div[text()='In Progress']"));
		Actions statusfield = new Actions(driver);
		statusfield.moveToElement(statushower);
		
		WebDriverWait selectedit = new WebDriverWait(driver, Duration.ofSeconds(30));
		selectedit.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("(//button[@title='Edit Status: Item In Progress'])[1]"))));
		driver.findElement(By.xpath("(//button[@title='Edit Status: Item In Progress'])[1]")).click();
		
		WebElement clickcompleted = driver.findElement(By.xpath("//div//a[text()='Completed']"));
		driver.executeScript("arguments[0].click()",clickcompleted);
		
	}

}

