package sprint1;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class S6_30_Delete_Dashboard {

	@Test
	public void deleteDashboard() throws InterruptedException, MalformedURLException
	{
		EdgeOptions option = new EdgeOptions();
		option.addArguments("--disable-notifications");
		DesiredCapabilities dc = new DesiredCapabilities(option);
		dc.setBrowserName("MicrosoftEdge");
		dc.setPlatform(Platform.LINUX);
		
		//dc.
		RemoteWebDriver driver = new RemoteWebDriver(new URL("http://20.40.48.160:4444/wd/hub"), dc);
		
		//EdgeDriver driver = new EdgeDriver(option);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		//Login to Login | Salesforce 
		driver.get("https://login.salesforce.com");
		//Login to Login | Salesforce 
		driver.findElement(By.id("username")).sendKeys("gokul.sekar@testleaf.com");
		driver.findElement(By.id("password")).sendKeys("Leaf@123");
		driver.findElement(By.id("Login")).click();

		//Click on the toggle menu button from the left corner
		driver.findElement(By.xpath("//button[@title='App Launcher']")).click();

		//Click View All and click Dashboards from App Launcher
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		driver.findElement(By.xpath("(//input[@type='search'])[3]")).sendKeys("Dashboards");
		driver.findElement(By.xpath("//div[@class='slds-accordion__content']//li[1]")).click();

		//Click on the Dashboards tab
		WebElement element= driver.findElement(By.xpath("(//a[contains(@title,'Dashboards')])[1]"));
		driver.executeScript("arguments[0].click()", element);

		//Search the Dashboard 'Salesforce Automation by *Your Name*'
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Salesforce Automation by");
		Thread.sleep(2000);
		String before=driver.findElement(By.xpath("//div[@class='test-listViewStatusInfo']")).getText();
		if(before.length()==0)
			before=driver.findElement(By.xpath("//div[@class='test-listViewStatusInfo']/span")).getAttribute("innerHTML");
		String[] split = before.split(" ");

		//Click on the Dropdown icon and Select Delete
		driver.findElement(By.xpath("//tbody/tr/td[6]//button")).click();
		driver.findElement(By.xpath("//span[text()='Delete']")).click();

		//Click on the Delete option in the displayed popup window.
		driver.findElement(By.xpath("//button[@title='Delete']")).click();
		//Verify Whether Dashboard is Deleted using Dashboard 
		Thread.sleep(2000);
		System.out.println(driver.findElement(By.xpath("//div[@data-aura-class='forceToastMessage']//span[@data-aura-class='forceActionsText']")).getText());
		String url=driver.getCurrentUrl();
		driver.get(url);
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Salesforce Automation by");
		Thread.sleep(2000);
		String after=driver.findElement(By.xpath("//div[@class='test-listViewStatusInfo']")).getText();
		if(after.length()==0)
			after=driver.findElement(By.xpath("//div[@class='test-listViewStatusInfo']/span")).getAttribute("innerHTML");
		String[] split1 = after.split(" ");

		if(Integer.parseInt(split1[0])==Integer.parseInt(split[0])-1) System.out.println("Dashboard Deleted Successfully");
		else System.out.println("Dashboard not Deleted");
		driver.close();
	}
}
