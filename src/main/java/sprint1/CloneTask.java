package sprint1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;


public class CloneTask {
	@Test
	public void CloneTask() {
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		
		ChromeDriver driver = new ChromeDriver(options);
		driver.get("https://login.salesforce.com/?locale=in");
		driver.manage().window().maximize();
		
		driver.findElement(By.id("username")).sendKeys("Gokul.sekar@testleaf.com");
		driver.findElement(By.id("password")).sendKeys("Leaf@123");
		driver.findElement(By.id("Login")).click();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("//button[@title='App Launcher']")).click();
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		
		driver.findElement(By.xpath("//input[contains(@placeholder,'Search apps')]")).sendKeys("Content");
		driver.findElement(By.xpath("(//*[text()='Content'])[2]")).click();
		
		WebElement todaytask = driver.findElement(By.xpath("//div/h2[@class='header-title-container']/following::span[text()='Key Deals - Recent Opportunities']"));
		Actions tt = new Actions(driver);
		tt.scrollToElement(todaytask).perform();
		WebElement campfield = driver.findElement(By.xpath("(//div/a/following::span[text()='View All'])[2]"));
		driver.executeScript("arguments[0].click()",campfield);
		
		driver.findElement(By.xpath("//h1/span[text()='Recently Viewed']")).click();
		
		WebElement opentask = driver.findElement(By.xpath("(//div[@class='listContent'])//span[text()='Open Tasks']"));
		Actions ot = new Actions(driver);
		ot.scrollToElement(opentask).perform();
		WebElement otask = driver.findElement(By.xpath("//span[text()='Open Tasks']"));
		driver.executeScript("arguments[0].click()",otask);
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("//button[@title='Select list display']")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("//ul/li[@title='Display as table']")).click();
		
		driver.findElement(By.xpath("//button[@title='List View Controls']")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		WebElement clone = driver.findElement(By.xpath("//span[text()='Clone']"));
		driver.executeScript("arguments[0].click()",clone);
		
		WebElement listname = driver.findElement(By.xpath("//input[@name='title']"));
		listname.clear();
		listname.sendKeys("New open tasks");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		WebElement listapiname = driver.findElement(By.xpath("//input[@name='developerName']"));
		listapiname.clear();
		listapiname.sendKeys("New_open_ask");

		driver.findElement(By.xpath("//label/following::span[text()='All users can see this list view']")).click();
		driver.findElement(By.xpath("(//button/span[text()='Save'])[2]")).click();
		
		WebElement subjectfield = driver.findElement(By.xpath("(((//table[@aria-label=\"New Open Tasks\"]//tr)[1]/following::button)[1]/span)[1]"));
		subjectfield.click();
		subjectfield.clear();
		subjectfield.sendKeys("map");
		
		driver.findElement(By.xpath("//span[text()='Save']")).click();
	}
}


