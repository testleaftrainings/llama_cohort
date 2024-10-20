package sprint1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class S6_015_EditOpportunity {

	
	@Test
	public void editOpportunity() throws InterruptedException
	{
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://login.salesforce.com");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().window().maximize();
		driver.findElement(By.id("username")).sendKeys("gokul.sekar@testleaf.com");
		driver.findElement(By.id("password")).sendKeys("Leaf$321");
		driver.findElement(By.id("Login")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//button[@title='App Launcher']/div")).click();
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		driver.findElement(By.xpath("//p[text()='Sales']")).click();
		//4. Click on Opportunity tab 
		WebElement eleOpportunity=driver.findElement(By.xpath("//a[@title='Opportunities']"));
		driver.executeScript("arguments[0].click()", eleOpportunity);
		//5. Search the Opportunity 'Salesforce Automation by *Your Name*'
        driver.findElement(By.xpath("//input[@name='Opportunity-search-input']")).sendKeys("Salesforce Automation by Dhanusha",Keys.ENTER);
       // 6. Click on the Dropdown icon and Select Edit
        Thread.sleep(5000);
        driver.findElement(By.xpath("//span[text()='Show Actions']//ancestor::a")).click();
        driver.findElement(By.xpath("//div[@title='Edit']//ancestor::a")).click();
        //7. Choose close date as Tomorrow date
        WebElement closedate=driver.findElement(By.xpath("//input[@name='CloseDate']"));
        closedate.clear();
        closedate.sendKeys("13/10/2024");
        //8. Select 'Stage' as Perception Analysis
        driver.findElement(By.xpath("//label[text()='Stage']//following::div//span")).click();
        driver.findElement(By.xpath("//label[text()='Stage']//following::span[text()='Perception Analysis']")).click();
        //9. Select Deliver Status as In Progress
         Actions actions=new Actions(driver);
         WebElement eleDelivery=driver.findElement(By.xpath("//label[text()='Delivery/Installation Status']//following::div[1]"));
        driver.executeScript("arguments[0].scrollIntoView()", eleDelivery);
        eleDelivery.click();
        driver.findElement(By.xpath("//span[@title='In progress']")).click();
        //10. Enter Description as SalesForce
        driver.findElement(By.xpath("//label[text()='Description']//following::div//textarea")).sendKeys("Salesforce");
        //11. Click on Save and Verify Stage as Perception Analysis
        driver.findElement(By.xpath("//button[@name='SaveEdit']")).click();
        String successMessage=driver.findElement(By.xpath("//div[contains(@id,'toastDescription')]")).getText();
        System.out.println(successMessage);
        String stage= driver.findElement(By.xpath("//table[contains(@class,'uiVirtualDataTable')]//td[5]//span[1]/span")).getText();
       
        if(stage=="Perception Analysis")
        	System.out.println("The Oppurtunity is Edited Successfully ");                              
        		
	}
}
