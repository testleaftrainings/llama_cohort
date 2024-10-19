package com.salesforce.testcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class S6_013_CreateCaseWithoutMandatoryFields {
	@Test
	public void runCreateCaseWithoutMandatoryFields() {
		// TODO Auto-generated method stub
//	    1. Login to https://login.salesforce.com
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--disable-notifications");
		ChromeDriver driver=new ChromeDriver(options);
		Actions actions=new Actions(driver);
		driver.get("https://login.salesforce.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
//			username: gokul.sekar@testleaf.com
//			password: Leaf$321
		WebElement userName = driver.findElement(By.id("username"));
		userName.sendKeys("gokul.sekar@testleaf.com");
		WebElement password = driver.findElement(By.id("password"));
		password.sendKeys("Leaf$321");
		driver.findElement(By.id("Login")).click();
		
//		2. Click on toggle menu button from the left corner
		driver.findElement(By.xpath("//button[@title='App Launcher']/div")).click();
//		3. Click view All and click Sales from App Launcher
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		driver.findElement(By.xpath("//p[text()='Sales']")).click();
//		4. Click on Cases tab 
		WebElement caseTabElement = driver.findElement(By.xpath("//a[@title='Cases']/span"));
		driver.executeScript("arguments[0].click()", caseTabElement);
//		5) Click on New button
		driver.findElement(By.xpath("//div[@title='New']")).click();
//		6) Choose Contact Name from DropDown
		driver.findElement(By.xpath("//label[text()='Contact Name']/following::input[1]")).click();
		driver.findElement(By.xpath("//h3[@title='Recent Contacts']/following::li[1]")).click();
		//7) Select status as None
		driver.findElement(By.xpath("//label[text()='Status']/following::span[text()='New'][1]")).click();
		driver.findElement(By.xpath("(//label[text()='Status']/following::span[text()='--None--'])[1]")).click();
		
		
//		8) Enter Subject as 'Testing' and description as 'Automation testing'
	    WebElement subjectElement = driver.findElement(By.xpath("//label[text()='Subject']/following::input[1]"));
	    actions.moveToElement(subjectElement);
	    actions.perform();
	    subjectElement.sendKeys("Testing");
	    
	    driver.findElement(By.xpath("//label[text()='Description']/following::textarea[1]")).sendKeys("Automation testing");
	    //9) Click 'Save'
	    driver.findElement(By.xpath("(//button[text()='Save'])[2]")).click();
//		10)Get the text of Error message Displayed and Verify the message
	    //div[@class='genericNotification']/strong
	    String message="Case is not Created Successfully";
	    WebElement errorNoticeElement = driver.findElement(By.xpath("//div[@class='genericNotification']/strong"));
	    if(errorNoticeElement.getText().contains("Review")){
	    	System.out.println(message);
	    }
//		Expected Result:
//		Case is not Created Successfully
	}
}

//following 6
//freeze dom 6a
