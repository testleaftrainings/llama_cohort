package sprint1;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class S6_11_Edit_Case {

	@Test
	public void loginPage() throws InterruptedException, IOException {

		EdgeOptions option = new EdgeOptions();
		option.addArguments("--disable-notifications");
		DesiredCapabilities dc = new DesiredCapabilities(option);
		dc.setBrowserName("MicrosoftEdge");
		dc.setPlatform(Platform.LINUX);
		
		//dc.
		RemoteWebDriver driver = new RemoteWebDriver(new URL("http://20.40.48.160:4444/wd/hub"), dc);
		
		//EdgeDriver driver=new EdgeDriver();             
		driver.get("https://login.salesforce.com/"); 
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.id("username")).sendKeys("gokul.sekar@testleaf.com");
		driver.findElement(By.id("password")).sendKeys("Leaf$321");
		driver.findElement(By.id("Login")).click();

		Thread.sleep(1000);
		//Click on toggle menu button from the left corner
		driver.findElement(By.xpath("//button[@title='App Launcher']")).click();
		//Click view All and click Sales from App Launcher
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		driver.findElement(By.xpath("//P[text()='Sales']")).click();
		//Click on Cases tab visible or select from more.
		WebElement element=driver.findElement(By.xpath("//span[text()='Cases']"));

		//  Actions action = new Actions(driver);
		if(element.isDisplayed())
			driver.executeScript( "arguments[0].click()",element);
		else {
			driver.findElement(By.xpath("//span[text()='More']")).click();
			driver.executeScript( "arguments[0].click()",driver.findElement(By.xpath("//div[@role='menu']//span[text()='Cases']")));
		}
		//Click on the Dropdown icon and select Edit from the case you created by reffering 'case owner alias'
		driver.findElement(By.xpath("//tr[1]/td[7]")).click();

		driver.executeScript( "arguments[0].click()",driver.findElement(By.xpath("//div[@title='Edit']")));
		//Update Status as Working
		driver.findElement(By.xpath("//records-record-layout-item[@field-label='Status']//button")).click();
		driver.findElement(By.xpath("//div[@aria-label='Status']//lightning-base-combobox-item[@data-value='Working']")).click();
		//Update Priority to low
		driver.findElement(By.xpath("//records-record-layout-item[@field-label='Priority']//button")).click();
		driver.findElement(By.xpath("//div[@aria-label='Priority']//lightning-base-combobox-item[@data-value='Low']")).click();
		//Update Case Origin as Phone
		driver.findElement(By.xpath("//records-record-layout-item[@field-label='Case Origin']//button")).click();
		driver.findElement(By.xpath("//div[@aria-label='Case Origin']//lightning-base-combobox-item[@data-value='Phone']")).click();
		//Update SLA violation to No
		driver.executeScript("arguments[0].scrollIntoView(true)", driver.findElement(By.xpath("//records-record-layout-item[@field-label='SLA Violation']//button")));
		driver.findElement(By.xpath("//records-record-layout-item[@field-label='SLA Violation']//button")).click();
		driver.findElement(By.xpath("//div[@aria-label='SLA Violation']//lightning-base-combobox-item[@data-value='No']")).click();
		//Click on Save and Verify Status as Working
		driver.findElement(By.xpath("//button[@name='SaveEdit']")).click();
		if(driver.findElement(By.xpath("//tbody/tr[1]/td[4]//span/span[1]")).getText().equals("Working"))
			System.out.println("Working is updated Successfully");
		else System.out.println("Working is not updated Successfully");
		driver.close();

	}
}
