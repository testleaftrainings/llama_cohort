package SDETSelenium;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class NBA_Assessment_Dhanusha {
	
	@Test
	public void verifyNBA() throws InterruptedException, MalformedURLException
	{
		
		ChromeOptions options=new ChromeOptions();
		//options.addArguments("--disable-notifications");
		//EdgeOptions options=new EdgeOptions();
		DesiredCapabilities dc = new DesiredCapabilities(options);
		dc.setBrowserName("chrome");
		dc.setPlatform(Platform.LINUX);
		RemoteWebDriver driver = new RemoteWebDriver(new URL("http://20.40.48.160:4444/wd/hub"), dc);
		//ChromeDriver driver=new ChromeDriver(options);
		driver.get("https://www.nba.com/stats");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//button[@id='onetrust-accept-btn-handler']")).click();
		driver.findElement(By.linkText("See All Player Stats")).click();
		Select selectSeason=new Select(driver.findElement(By.xpath("//label//p[text()='Season']//following::select[1]")));
		selectSeason.selectByValue("2023-24");
		Select selectSeasonType=new Select(driver.findElement(By.xpath("//label//p[text()='Season Type']//following::select[1]")));
		selectSeasonType.selectByVisibleText("NBA Cup");
		Select selectMode=new Select(driver.findElement(By.xpath("//label//p[text()='Per Mode']//following::select[1]")));
		selectMode.selectByValue("PerGame");
		Select selectSegment=new Select(driver.findElement(By.xpath("//label//p[text()='Season Segment']//following::select[1]")));
		selectSegment.selectByVisibleText("Last Game");
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//button[contains(@id,'bx-close-inside')])[2]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//button[contains(@id,'bx-close-inside')])[1]")).click();
		List<WebElement> tableRows= driver.findElements(By.xpath("//table[contains(@class,'Crom_table')]/tbody//tr"));
		List<WebElement> tableCol= driver.findElements(By.xpath("//table[contains(@class,'Crom_table')]/tbody//tr//td[4]"));
		List<WebElement> tableNames= driver.findElements(By.xpath("//table[contains(@class,'Crom_table')]/tbody//tr//td[2]//a"));
		
		String colAge= null;
		List<String> age=new ArrayList<String>();
		for(int i=0;i<tableRows.size();i++)
		{
			colAge=tableCol.get(i).getText();
			age.add(colAge);
		}
		Collections.sort(age);
		String lowestAge=age.get(0);
		System.out.println(lowestAge);
		for(int i=0;i<tableRows.size();i++)
		{
			colAge=tableCol.get(i).getText();
			if(lowestAge.equals(colAge))
			{
				tableNames.get(i).click();
				break;
			}
			
		}
		String exp=driver.findElement(By.xpath("(//p[text()='EXPERIENCE'])[1]//following::p[1]")).getText();
		System.out.println(exp);
		driver.quit();
	}

}
