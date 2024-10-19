package salesforce.test.automation;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class S639DownloadPDF extends ReusableClass{

	@Test 
	public void downloadPDF() throws InterruptedException {
		
		Thread.sleep(5000);
		Actions action = new Actions(driver);
		List<WebElement> carousel = driver.findElements(By.xpath("//div[@class='tileTitle']"));		
		String expectedCarousel = "View Release Notes";
		for(WebElement cName : carousel)
		{	
			String cNametext = cName.getText();
			
			if(cNametext.equals(expectedCarousel))
			{
					try {
						Thread.sleep(2000);
						WebElement link = cName.findElement(By.xpath("following-sibling::div[@class='tileNavButton']/button"));
						link.click();
						System.out.println("Element is clicked");
						break;
					} catch (Exception e) {
						Thread.sleep(2000);
						WebElement link = cName.findElement(By.xpath("following-sibling::div[@class='tileNavButton']/button"));
						action.moveToElement(link).click();
						break;
					}
			}
			else if(cNametext.isEmpty()) {
				Thread.sleep(1000);
				driver.findElement(By.xpath("//div[@class='rightScroll']")).click();
				Thread.sleep(1000);
				cNametext = cName.getText();
				if(cNametext.equals(expectedCarousel))
				{
					Thread.sleep(5000);
					WebElement link = cName.findElement(By.xpath("following-sibling::div[@class='tileNavButton']/button"));
					link.click();
					break;
				}
			}
		}
		Thread.sleep(20000);
		String currentWindowHandle = driver.getWindowHandle();
		Set<String> windowHandles = driver.getWindowHandles();
		String releaseSelection = "Summer '22";  //Summer '22
		String releaseValue;
		for(String handle : windowHandles)
		{
			if(!handle.equals(currentWindowHandle))
			{
				driver.switchTo().window(handle);
				Thread.sleep(5000);
				if(driver.findElement(By.xpath("//div[@class='dialog']/h1")).getText().equals("Confirm redirect?")) 
				{
					driver.findElement(By.xpath("//div[@class='dialog']/button[text()='Confirm']")).click();
					Thread.sleep(5000);
					performWaitandClick(driver.findElement(By.xpath("//button[@name='releaseVersionPicker']")));
					action.moveToElement(driver.findElement(By.xpath("//span[text()=\"" + releaseSelection + "\"]"))).click().build().perform();
					Thread.sleep(10000);
					WebElement releaseNumber = driver.findElement(By.xpath("//span[@id='releaseNumber']"));
					releaseValue = releaseNumber.getText();
					if(releaseValue.contains("Summer") && releaseValue.contains("22")) 
						{
							performWaitandJSClick(driver.findElement(By.xpath("//button[@title='Open PDF']")));
							System.out.println("PDF Download is clicked");
							Thread.sleep(10000);
						}
				}				
			}
		}		
	}
}
