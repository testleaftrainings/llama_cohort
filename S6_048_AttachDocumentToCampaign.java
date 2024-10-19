package com.salesforce.testcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class S6_048_AttachDocumentToCampaign {
	@Test
	public void runAttachDocumentToCampaign() throws InterruptedException {
// TODO Auto-generated method stub
		// 1. Login to https://login.salesforce.com
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(options);
		JavascriptExecutor jexecutor=(JavascriptExecutor)driver;
		driver.get("https://login.salesforce.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.id("username")).sendKeys("gokul.sekar@testleaf.com");
		driver.findElement(By.id("password")).sendKeys("Leaf$321");
		driver.findElement(By.id("Login")).click();
		// 2. Click on toggle menu button from the left corner
		driver.findElement(By.xpath("//button[@title='App Launcher']/div")).click();
		// 3. Click view All and click Sales from App Launcher
		Thread.sleep(5000);
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		driver.findElement(By.xpath("//p[text()='Sales']")).click();
		// 4. Click on Campaigns tab
		WebElement campaignElement = driver.findElement(By.xpath("//span[text()='Campaigns']"));
		jexecutor.executeScript("arguments[0].click();", campaignElement);
		// 5. Click Bootcamp link
		driver.findElement(By.linkText("BootCamp")).click();
		// 6. Click on Upload button
		//driver.findElement(By.xpath("//a[@title='Upload Files']")).click();
		// 7. Select a file from local and upload a pdf file
		String filePath = "C:\\TestLeaf\\BioEnergy Code Decoder.pdf";
		String fileName = filePath.substring(filePath.lastIndexOf("\\")+1).replace(".pdf", "");
		System.out.println(fileName);
		//File file=new File(filePath);
		//String absPath=file.getAbsolutePath();
		//System.out.println(absPath);
		WebElement uploadElement = driver.findElement(By.xpath("//span[text()='Upload Files']//preceding::input[@type='file']"));
		uploadElement.sendKeys(filePath);
		Thread.sleep(8000);
		WebElement doneElement = driver.findElement(By.xpath("//span[text()='Done']"));
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(doneElement));
		wait.until(ExpectedConditions.elementToBeClickable(doneElement));
		
		jexecutor.executeScript("arguments[0].click();", doneElement);
		
		// 8. Verify the file name displayed as link
        Thread.sleep(5000);
		//String actualtext = driver.findElement(By.xpath("(//span[text()='" + fileName + "'])[1]")).getText();
		String actualtext1 = driver.findElement(By.xpath("(//div[contains(@class, 'forceContentRelatedListPreviewFileList')]//following::span[text()='"+fileName+"'])[2]")).getText();
		if (actualtext1.contentEquals(fileName))
			// Expected result: The file should be attached successfully
			System.out.println("The file  attached successfully");
		else {
			System.out.println("The file not attached successfully");
		}
	}

}
