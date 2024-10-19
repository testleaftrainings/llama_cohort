package salesforce.test.automation;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import io.github.sukgu.Shadow;

public class S641NonProfitCertifications extends ReusableClass{

	@Test
	public void verifyNonProfitCertificate() throws InterruptedException
	{
		Thread.sleep(5000);
		Actions action = new Actions(driver);
		List<WebElement> carousel = driver.findElements(By.xpath("//div[@class='tileTitle']"));		
		String expectedCarousel = "See System Status";
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
					String expectedResource = "Trailhead";
					List<WebElement> allResources = driver.findElements(By.xpath("//h4[text()='Resources']/following::h5"));
					for(WebElement resource : allResources)
					{
						String resourceName = resource.getText().trim();
						if(resourceName.equals(expectedResource))
						{
							Thread.sleep(5000);
							WebElement link = resource.findElement(By.xpath("ancestor::div[@slot='header']/following-sibling::a"));
							link.click();
							break;
						}
					}
					
					Thread.sleep(5000);
					Shadow shadow = new Shadow(driver);
					WebElement industriesButton = shadow.findElementByXPath("//span[text()='Industries']");
//					WebElement shadowHost1 = driver.findElement(By.cssSelector("hgf-c360nav"));
//					SearchContext  shadowRoot1 = shadowHost1.getShadowRoot();
//			        
//	
//			        WebElement shadowHost2 = shadowRoot1.findElement(By.cssSelector("hgf-button"));			        
//			        SearchContext  shadowRoot2 = shadowHost2.getShadowRoot();
//
//			        Thread.sleep(3000);
//			        WebElement industriesButton = shadowRoot2.findElement(By.cssSelector("span.nav-item-label--11"));
//			        wait.until(ExpectedConditions.elementToBeClickable(industriesButton));
			        industriesButton.click();
			        Thread.sleep(5000);
			        WebElement nonprofitButton = shadow.findElementByXPath("//span[text()='Nonprofit']");
			        driver.executeScript("arguments[0].scrollIntoView(true);", nonprofitButton);
			        driver.executeScript("arguments[0].click()", nonprofitButton);
			        Thread.sleep(5000);
			        
			        WebElement startLearning = shadow.findElementByXPath("//a[@aria-label='Start learning: Salesforce for Nonprofits Basics']");
			        wait.until(ExpectedConditions.elementToBeClickable(startLearning));
			        driver.executeScript("arguments[0].scrollIntoView(true);", startLearning);
			        driver.executeScript("arguments[0].click()", startLearning);
			        Thread.sleep(5000);
//			        action.scrollToElement(startLearning).click().build().perform();
			        Thread.sleep(10000);
			        String title = driver.getTitle();
			        if(title.contains("Salesforce for Nonprofits Basics | Salesforce Trailhead"))
	        		{
			        	System.out.println("Test Passed");
	        		}
			        else
			        {
			        	System.out.println("Test Failed");
			        }
			        
			        
					
				}				
			}
		}
	}
}

