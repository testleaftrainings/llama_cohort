package sprint1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class Task2 {

	@Test
	public void DeleteAccount() throws InterruptedException {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		
		ChromeDriver driver = new ChromeDriver(options);
		driver.get("https://login.salesforce.com/?locale=in");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.findElement(By.id("username")).sendKeys("Gokul.sekar@testleaf.com");
		driver.findElement(By.id("password")).sendKeys("Leaf$321");
		driver.findElement(By.id("Login")).click();
		//To delete
		driver.findElement(By.xpath("//button[@title='App Launcher']")).click();
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		
		driver.findElement(By.xpath("//input[contains(@placeholder,'Search apps')]")).sendKeys("Sales");
		driver.findElement(By.xpath("(//*[text()='Sales'])[3]")).click();
		
		Thread.sleep(3000);
		WebElement MoreDropDown = driver.findElement(By.xpath("//span[text()='More']"));
		try {
			MoreDropDown.click();
		} catch (StaleElementReferenceException e) {
			MoreDropDown = driver.findElement(By.xpath("//span[text()='More']"));
		}
			MoreDropDown.click();
			WebElement Case = driver.findElement(By.xpath("//span[text()='Cases']"));
			driver.executeScript("arguments[0].click()",Case);
			//To create Case
			driver.findElement(By.xpath("//div[text()='New']")).click();
			driver.findElement(By.xpath("//input[@placeholder='Search Contacts...']")).sendKeys("Gokul Sekar");
			driver.findElement(By.xpath("(//label[text()='Contact Name']//following::lightning-base-combobox-formatted-text[@title='Gokul Sekar'])[1]")).click();
			WebElement ClickEscalate = driver.findElement(By.xpath("(//span[text()='New'])[2]"));
			driver.executeScript("arguments[0].click()",ClickEscalate);
			driver.findElement(By.xpath("(//lightning-base-combobox-item['Escalated'])[4]")).click();
			driver.findElement(By.xpath("(//span[text()='--None--'])[2]")).click();
			driver.findElement(By.xpath("(//lightning-base-combobox-item['Email'])[11]")).click();
			driver.findElement(By.xpath("(//button[text()='Save'])[2]")).click();
			
			Thread.sleep(5000);
			WebElement Case2 = driver.findElement(By.xpath("//span[text()='Cases']"));
			driver.executeScript("arguments[0].click()",Case2);
			
			Thread.sleep(5000);
			driver.findElement(By.xpath("//tbody//tr[1]//td[7]")).click();
			WebElement Deletedropdown = driver.findElement(By.xpath("//div[text()='Delete']"));
			driver.executeScript("arguments[0].click()",Deletedropdown);
			
			Thread.sleep(5000);
			driver.findElement(By.xpath("//h1[text()='Delete Case']//following::button[3]/span[text()='Delete']")).click();
			
			WebElement outputscreen = driver.findElement(By.xpath("//div[@id='toastDescription4120:0']"));
			if (outputscreen.isDisplayed()) {
				System.out.println(outputscreen.getText());
			}
				else {
					System.out.println(" Case Deleted " + " Account not deleted ");
				}
			driver.quit();
			}
	}

