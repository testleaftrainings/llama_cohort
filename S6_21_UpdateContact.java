package SDETSelenium;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class S6_21_UpdateContact {
	
	@Test
	public void updateContact() throws InterruptedException
	{
		ChromeDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().window().maximize();
		driver.get("https://login.salesforce.com/");
		driver.findElement(By.id("username")).sendKeys("gokul.sekar@testleaf.com");
		driver.findElement(By.id("password")).sendKeys("Leaf$321");
		driver.findElement(By.id("Login")).click();
		Thread.sleep(5000);
		//4)Click on menu button from the Left corner	
		driver.findElement(By.xpath("//button[@title='App Launcher']/div")).click();
		//5) Click 'view All'
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		//6) Click on contacts
		Actions actions=new Actions(driver);
        actions.moveToElement(driver.findElement(By.xpath("//p[text()='Contacts']"))).click().build().perform();
        //7) Get the size of conatcts available and print the list
        driver.findElement(By.xpath("//div[contains(@class,'uiScroller')]")).sendKeys(Keys.END);
		List<WebElement> contacts=driver.findElements(By.xpath("//table[contains(@class,'uiVirtualDataTable')]//following::tbody//tr//th//a"));
		System.out.println("size of contacts"+contacts.size());
		String contactName;
		for(int i=0;i<contacts.size();i++)
		{
			contactName=contacts.get(i).getText();
			System.out.println(contactName);
		}
		//8) search for the contact using unique name 
		driver.findElement(By.xpath("//input[@name='Contact-search-input']")).sendKeys("Dhanusha Ballikhana",Keys.ENTER);
		Thread.sleep(3000);
		//9) Click on the dropdown icon available in the unique contact and select edit
		driver.findElement(By.linkText("Show Actions")).click();
		driver.findElement(By.xpath("//a[@title='Edit']")).click();
		//10)Update Email with your persinal mail id
		WebElement eleEmail=driver.findElement(By.xpath("//label[text()='Email']//following::input[@name='Email']"));
		eleEmail.clear();
		eleEmail.sendKeys("abc@gmail.com");
		//11)Update Lead Source as Partner Referral from bottom
		driver.findElement(By.xpath("//label[text()='Lead Source']//following::div[1]")).click();
		driver.findElement(By.xpath("(//div[contains(@id,'dropdown-element')])[4]//following::span[text()='Partner Referral']")).click();
		//12) Update MailingAddress with personal address
		driver.findElement(By.xpath("//label[text()='Mailing Street']//following::div[1]//*[@name='street']")).sendKeys("321 Fairmout Ave");
		driver.findElement(By.xpath("//label[text()='Mailing City']//following::div[1]//input[@name='city']")).sendKeys("Jerseycity");
		driver.findElement(By.xpath("//label[text()='Mailing Zip/Postal Code']//following::div[1]//*[@name='postalCode']")).sendKeys("07306");
		driver.findElement(By.xpath("//label[text()='Mailing State/Province']//following::div[1]//*[@name='province']")).sendKeys("NJ");
		driver.findElement(By.xpath("//label[text()='Mailing Country']//following::div[1]//*[@name='country']")).sendKeys("USA");
		//13) Update Level as Tertiary
		driver.findElement(By.xpath("//label[text()='Level']//following::div[1]")).click();
		driver.findElement(By.xpath("//label[text()='Level']//following::div[1]//span[text()='Tertiary']")).click();
		//14) Update title as Automation Testing
		actions.moveToElement(driver.findElement(By.xpath("//label[text()='Title']//following::div[1]"))).sendKeys("Automation Testing");
		Thread.sleep(3000);
		//15) Click Save and Verify and print Email 
		String email=driver.findElement(By.xpath("//a[contains(@class,'emailuiFormattedEmail')]")).getText();
		System.out.println(email);
		driver.quit();
		}
		
	}


