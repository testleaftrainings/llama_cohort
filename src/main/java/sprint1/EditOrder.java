package sprint1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class EditOrder {

	@Test
	public void EditOrder() throws InterruptedException {
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		
		ChromeDriver driver = new ChromeDriver(options);
		driver.get("https://login.salesforce.com/?locale=in");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.findElement(By.id("username")).sendKeys("Gokul.sekar@testleaf.com");
		driver.findElement(By.id("password")).sendKeys("Leaf$321");
		driver.findElement(By.id("Login")).click();
		
		driver.findElement(By.xpath("//button[@title='App Launcher']")).click();
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		
		driver.findElement(By.xpath("//input[contains(@placeholder,'Search apps')]")).sendKeys("Service Console");
		driver.findElement(By.xpath("//*[text()='Service Console']")).click();
		driver.findElement(By.xpath("//a/following::div/button[@title='Show Navigation Menu']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("(//span[text()='Orders'])[1]")).click();
		Thread.sleep(3000);
		WebElement clickOrder = driver.findElement(By.xpath("(//span[text()='Orders'])[2]"));
		driver.executeScript("arguments[0].click()",clickOrder);
	
		
		driver.findElement(By.xpath("//span[text()='All Orders']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//span[text()='Show Actions']/ancestor::a)[1]")).click();
		Thread.sleep(3000);
		WebElement clickedit = driver.findElement(By.xpath("//div[text()='Edit']"));
		driver.executeScript("arguments[0].click()",clickedit);
		
		driver.findElement(By.xpath("(//div/button[@title='Clear Selection'])[2]")).click();
		driver.findElement(By.xpath("//input[contains(@placeholder,'Search Accounts...')]")).sendKeys("Testleaf Software");
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//div/following::lightning-base-combobox-item)[2]")).click();
		
		driver.findElement(By.xpath("//div/button[@title='Clear Selection']")).click();
		driver.findElement(By.xpath("//input[@placeholder='Search Contracts...']")).sendKeys("00000133");
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//div/following::lightning-base-combobox-item)[2]"));
		driver.findElement(By.xpath("//button[text()='Save']")).click();
		WebElement outputscreen = driver.findElement(By.xpath("//div[@data-key='success']"));
		if (outputscreen.isDisplayed()) {
			System.out.println(outputscreen.getText());
		}
			else {
				System.out.println(" Create Order " + " Order not created Successfully ");
			}
		driver.close();
		
	}
}

