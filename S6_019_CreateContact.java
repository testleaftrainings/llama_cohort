package com.salesforce.testcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class S6_019_CreateContact 
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
		
//		4) Click on Global Actions SVG icon

        // finding the SVG element
		Thread.sleep(8000);
		driver.findElement(By.xpath("//*[@data-key='add']")).click();
        
//		5) After clicking Global Actions SVG icon, Click 'New Contact'.
        driver.findElement(By.xpath("//span[text()='New Contact']")).click();
        
//		6) Pick Salutation as 'Mr.'
        driver.findElement(By.xpath("//span[text()='Salutation']//following::a")).click();
        driver.findElement(By.xpath("//a[@title='--None--']")).click();
        
//		7) Enter First Name as 'Naveen'
        WebElement firstName = driver.findElement(By.xpath("//label/span[text()='First Name']//following::input[1]"));
        firstName.sendKeys("Naveen");
//		8) Enter Last Name as 'Elumalai'
        driver.findElement(By.xpath("//label/span[text()='Last Name']//following::input[1]")).sendKeys("Elumalai");
//		9) Enter email as 'naveen@test.com'
        driver.findElement(By.xpath("//label/span[text()='Email']//following::input[1]")).sendKeys("naveenn@test.com");
//		10) Create a New Account for Account Name

        WebElement accounName = driver.findElement(By.xpath("//label/span[text()='Account Name']//following::input[1]"));
        actions.moveToElement(accounName).click().perform();
        
        Thread.sleep(5000);
        WebElement newAccounName = driver.findElement(By.xpath("//span[text()='New Account']"));
        actions.moveToElement(newAccounName).click().build().perform();
        
        //      11) Enter account name as 'Credits' and save
        driver.findElement(By.xpath("(//label/span[text()='Account Name'])[2]/following::input[1]")).sendKeys("Credits");
        driver.findElement(By.xpath("(//button[@title='Save'])[2]")).click();
//		12) Click and save
     // Set the explicit wait timeout to 10 seconds
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
       // Wait for the element to be visible
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[text()='Save'])[2]")));
        // Perform actions on the element
        driver.executeScript("arguments[0].click();", element);
        //driver.findElement(By.xpath("(//span[text()='Save'])[2]")).click();
//		13) Verify contact using Unique name and print the name
        String text = driver.findElement(By.xpath("//div[contains(@id,'toastDescription')]")).getText();
	if(text.contains(firstName.getText())) {
		System.out.println("Contact created");
	}
	else {
		System.out.println("contact not created");
	}
	}
}
