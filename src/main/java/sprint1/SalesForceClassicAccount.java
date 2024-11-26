package sprint1;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SalesForceClassicAccount {

@Test
	
	public void classicaccount() throws InterruptedException {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		
		ChromeDriver driver = new ChromeDriver(options);
		driver.get("https://login.salesforce.com/?locale=in");
		driver.manage().window().maximize();
		
		driver.findElement(By.id("username")).sendKeys("learners@testleaf.com");
		driver.findElement(By.id("password")).sendKeys("Leaf@1234");
		driver.findElement(By.id("Login")).click();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Accounts']")));
		
		driver.findElement(By.xpath("//a[text()='Accounts']")).click();
		WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(30));
		Select create = new Select(driver.findElement(By.xpath("//select[@id='createNewSelect']")));
		create.selectByVisibleText("Account");
		
		driver.findElement(By.xpath("(//input[@title='Go!'])[2]")).click();
		
		driver.findElement(By.xpath("//input[@id='acc2']")).sendKeys("BootCamp Puppeteer Prabhu");
		
		driver.findElement(By.xpath("//textarea[@id='acc17street']")).sendKeys("Yagappa Nagar");
		driver.findElement(By.xpath("//input[@id='acc17city']")).sendKeys("Thanjavur");
		driver.findElement(By.xpath("//input[@id='acc17zip']")).sendKeys("613007");
		driver.findElement(By.xpath("//input[@id='acc17state']")).sendKeys("TamilNadu");
		driver.findElement(By.xpath("//input[@id='acc17country']")).sendKeys("India");
		
		driver.findElement(By.xpath("//span/a[text()='Copy Billing Address to Shipping Address']")).click();
		
		String currentdatetext = driver.findElement(By.xpath("//label[text()='SLA Expiration Date']/following::a[1]")).getText();
		DateTimeFormatter date= DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate curdate = LocalDate.parse(currentdatetext, date);
		LocalDate futdate = curdate.plusDays(20);
		String futuredatetext = futdate.format(date);
		driver.findElement(By.xpath("//label[text()='SLA Expiration Date']/following::input[1]")).sendKeys(futuredatetext);
		
		driver.findElement(By.xpath("(//input[@title='Save'])[2]")).click();
		
		WebElement verify = driver.findElement(By.xpath("//span[text()='BootCamp Puppeteer Prabhu']"));
		Assert.assertTrue(verify.isDisplayed(), "expected not displayed");
		
		WebDriverWait ww = new WebDriverWait(driver, Duration.ofSeconds(30));
		ww.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Accounts']"))).click();
		
		WebElement newaccount = driver.findElement(By.xpath("//a[text()='BootCamp Puppeteer Prabhu']"));
		if (newaccount.isDisplayed()) {
			System.out.println(newaccount.getText());
		}
			else {
				System.out.println(" Create account " + " new account not created Successfully ");
			}
		driver.quit();
	}

}

