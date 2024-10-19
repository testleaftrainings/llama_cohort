package com.salesforce.testcases;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class S6_032_VerifyDashboardSubscribe {
@Test	
public void runVerifyDashboardSubscribe() throws InterruptedException {
	
//Preconditions:
ChromeOptions options=new ChromeOptions();
options.addArguments("--disable-notifications");
ChromeDriver driver=new ChromeDriver(options);
Actions action=new Actions(driver);
driver.get("https://login.salesforce.com");
driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

//Step 1: Login to Salesforce 
driver.findElement(By.id("username")).sendKeys("gokul.sekar@testleaf.com");
driver.findElement(By.id("password")).sendKeys("Leaf$321");
driver.findElement(By.id("Login")).click();
//	Click on the toggle menu button from the left corner
WebElement appLauchElement = driver.findElement(By.xpath("//button[@title='App Launcher']/div"));
action.moveToElement(appLauchElement).click().build().perform();
//	Click View All and click Dashboards from App Launcher
WebElement viewAll = driver.findElement(By.xpath("//button[text()='View All']"));
action.moveToElement(viewAll).click().build().perform();
WebElement dbTabElement = driver.findElement(By.xpath("//p[text()='Dashboards']"));
action.moveToElement(dbTabElement).click().build().perform();
//Click on the Dashboards tab 
WebElement dsTabElemet = driver.findElement(By.xpath("//a[@title='Dashboards']/span[text()='Recent or Dashboards' or text()='Dashboards']"));
//WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
//webDriverWait.until(ExpectedConditions.visibilityOf(dbTabElement));
driver.executeScript("arguments[0].click()",dsTabElemet);
//dsTabElemet.click();
//Search the Dashboard 'Salesforce Automation by *Your Name*'
//driver.findElement(By.xpath("//input[@placeholder='Search recent dashboards...']")).sendKeys("Salesforce Automation by Praveena");
//Thread.sleep(5000);
//driver.findElement(By.linkText("text:Salesforce Automation by Praveena")).click();
WebElement findText = driver.findElement(By.xpath("//table//tbody//th//a[@title='Salesforce Automation by Praveena']//following::td[6]//button"));
//	Click on the Dropdown icon and Select Subscribe
findText.click();
WebElement subscribeEle = driver.findElement(By.xpath("//span[text()='Subscribe']"));
driver.executeScript("arguments[0].click();", subscribeEle);
// Select frequency as 'Daily' and Click on Save in the Edit Subscription popup window. 
driver.findElement(By.xpath("//input[@id='daily']//following-sibling::span[text()='Daily']")).click();
driver.findElement(By.xpath("//button[@title='Save']//span[text()='Save']")).click();
//	8.Verify Whether the dashboard is subscribed.      
String actualtext = driver.findElement(By.xpath("//span[contains(@class,'toastMessage')]")).getText();
String expectedText="You started a dashboard subscription";
System.out.println(actualtext);
// ??????2   assertEquals(text,expectedText);
if(actualtext.contains("started")){
	System.out.println("subscribed successsfully");
}
else {
	System.out.println("Not subscribed successsfully");
}
//	Expected Result:
//	Dashboards should be subscribed Successfully    
//driver.findElement(By.xpath("//span[text()='OK']")).click();
}
}
