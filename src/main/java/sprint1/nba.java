package sprint1;


import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
@Test
public class nba {
	public  void main(String[] args) throws InterruptedException {
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//		1. Navigate to https://www.nba.com/stats
		driver.get("https://www.nba.com/stats");
		Actions action =new Actions(driver);
		driver.findElement(By.xpath("//button[text()='Continue without Deciding']")).click();
//			2. Click on 'See All Player Stats'
		driver.findElement(By.xpath("//a[text()='See All Player Stats']")).click();
//			3. Choose 'Season' as '2023-24'
		WebElement seasonEle = driver.findElement(By.xpath("//label//p[text()='Season']//following-sibling::div//select"));
		seasonEle.click();
		Select seasonDdl=new Select(seasonEle);
		seasonDdl.selectByIndex(1);
//			4. Choose 'Season Type' as 'NBA Cup'
		WebElement seasonTypeEle = driver.findElement(By.xpath("//label//p[text()='Season Type']//following-sibling::div//select"));
		seasonEle.click();
		Select seasonTypeDdl=new Select(seasonTypeEle);
		seasonTypeDdl.selectByVisibleText("NBA Cup");
//			5. Choose 'Per Mode' as 'Per Game'
		WebElement perModeEle = driver.findElement(By.xpath("//label//p[text()='Per Mode']//following-sibling::div//select"));
		perModeEle.click();
		Select permodeDdl=new Select(perModeEle);
		permodeDdl.selectByVisibleText("Per Game");
//			6. Choose 'Season Segment' as 'Last Game'
		WebElement seasonSegEle = driver.findElement(By.xpath("//label//p[text()='Season Segment']//following-sibling::div//select"));
		seasonSegEle.click();
		//Select seasonSegDdl=new Select(seasonSegEle);
		//seasonSegDdl.selectByIndex(0);
		seasonSegEle.click();
//			7. Click on the player name with lowest age
	int size = driver.findElements(By.xpath("//table[@class='Crom_table__p1iZz']//tbody//tr")).size();	
	System.out.println(size);
	List<WebElement> list = driver.findElements(By.xpath("//table[@class='Crom_table__p1iZz']//tbody//tr//td[4]"));
	
	action.moveToElement(list.get(list.size()-1)).perform();
	//String totalPages = driver.findElement(By.xpath("//div[@class='Pagination_pageDropdown__KgjBU']//following::div[3]")).getText();
	//totalPages.substring(totalPages.replace("", ""))
	
	 //List<Integer> minAge=new ArrayList<Integer>();
    Set<Integer> setage=new HashSet<Integer>();
	for (WebElement age : list) {
		String eachAge = age.getText();
		setage.add(Integer.parseInt(eachAge));
	}
	List<Integer> intlist=new ArrayList<Integer>(setage);
	Collections.sort(intlist);
	System.out.println(intlist.get(0));
  
		//driver.findElement(By.xpath("")).click();
//			8. Click on the Profile
		//driver.findElement(By.xpath("")).click();
//			9. Get the Experience of the player
		//driver.findElement(By.xpath("")).click();
//			10. Verify the player experience as 1.
		//driver.findElement(By.xpath("")).click();
		
	}
}

