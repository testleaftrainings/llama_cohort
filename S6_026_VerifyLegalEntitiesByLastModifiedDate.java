package com.salesforce.testcases;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class S6_026_VerifyLegalEntitiesByLastModifiedDate 
{
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		// 1. Login to https://login.salesforce.com
		//WebDriverWait wait;
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(options);
		Actions actions = new Actions(driver);
		driver.get("https://login.salesforce.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
//		username: gokul.sekar@testleaf.com
//	    password: Leaf$321
		WebElement userName = driver.findElement(By.id("username"));
		userName.sendKeys("gokul.sekar@testleaf.com");
		WebElement password = driver.findElement(By.id("password"));
		password.sendKeys("Leaf$321");
		driver.findElement(By.id("Login")).click();
		
//		Click on the toggle menu button from the left corner
		driver.findElement(By.xpath("//button[@title='App Launcher']")).click();
		
//		Click View All and click Legal Entities from App Launcher
		Thread.sleep(5000);
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		
		WebElement le = driver.findElement(By.xpath("//p[text()='Legal Entities']"));
		actions.moveToElement(le).click().build().perform();

//		Click on the legal Entities tab 
		//driver.findElement(By.xpath("")).click();
//		Click the sort arrow in the Last Modified Date.
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	       // Wait for the element to be clicable
		   
	       WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@title='Last Modified Date']")));
	 
	       driver.executeScript("arguments[0].click();", element);
	       
	       Thread.sleep(5000);         
	       List<WebElement> list = driver.findElements(By.xpath("//table//td[3]"));
	       List<LocalDate> list1=new ArrayList<LocalDate>();
	       DateTimeFormatter pattern = DateTimeFormatter.ofPattern("dd/MM/yyyy, h:mm a");
	       for (WebElement d : list) {
			String text = d.getText();
			LocalDate dp = LocalDate.parse(text,pattern);
			list1.add(dp);
		}
	       System.out.println(list1);
	       List<LocalDate> list2=new ArrayList<LocalDate>(list1);
	       Collections.sort(list2);
	       System.out.println(list2);
	      
	       
	       if(list1.equals(list2)) {
	    	   System.out.println("matching");
	       }
	       else {
	    	   System.out.println("not matching");
	       }
	       
	       //Expected Result:
//	       WebElement textelement = driver.findElement(By.xpath("//span[@title='Last Modified Date']/parent::a/following::span[1]"));
//		String text = driver.findElement(By.xpath("//span[@title='Last Modified Date']/parent::a/following::span[1]")).getText();
//		wait.until(ExpectedConditions.textToBePresentInElement(textelement, text));
//		//System.out.println(text);
//		
//		if(text.contentEquals("Sorted Ascending")) {
//			System.out.println("Sorted Ascending");
//		}
//		else if(text.contentEquals("Sorted Descending") || text.contentEquals("")){
//			System.out.println("Sorted Descending");
//		}
	}
}
