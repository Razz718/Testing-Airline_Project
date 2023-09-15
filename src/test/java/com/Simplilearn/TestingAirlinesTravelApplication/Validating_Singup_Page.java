package com.Simplilearn.TestingAirlinesTravelApplication;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Validating_Singup_Page {
	
	
	
	private WebDriver driver;
	
	@BeforeTest
	public void openbrowser() throws InterruptedException{
		
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.get("http://localhost:9098/FlyAway/home");
		Thread.sleep(2000);
		
		
	}
	
	@Test
	  public void validating_email() {
		  
		  
		  driver.findElement(By.linkText("Login/Signup")).click();
		  driver.findElement(By.cssSelector("a[href='signup']")).click();
		  driver.findElement(By.name("email_id")).sendKeys("Raj@gmail.com");
		  driver.findElement(By.name("pwd")).sendKeys("1234");
		  driver.findElement(By.name("pwd2")).sendKeys("1234");
		  driver.findElement(By.name("name")).sendKeys("john");
		  driver.findElement(By.name("address")).sendKeys("Gandhinagar");
		  driver.findElement(By.name("city")).sendKeys("Gujrat");
		  driver.findElement(By.tagName("button")).click();
		  
		// Capture a screenshot as a File object
			File screenshotFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			try {
			    // Define the location where you want to save the screenshot
			    File destination = new File("C:\\Screenshots\\Validating_email.png");
			    // Copy the captured screenshot to the specified location
			    FileUtils.copyFile(screenshotFile, destination);			    
			    System.out.println("Screenshot captured and saved to: " + destination.getAbsolutePath());
			} catch (IOException e) {
			    e.printStackTrace();
			}
		  WebElement bodyele = driver.findElement(By.tagName("body"));
		  String body_text = bodyele.getText();
		  String errormsg = "This email id already exists.";
		  boolean body_ele = body_text.contains(errormsg);
		  Assert.assertTrue(body_ele);
		  System.out.println(errormsg);
		  
		  
		
	}
	  
	  @Test
	  public void validating_pwd() {
		  
		  driver.findElement(By.linkText("Login/Signup")).click();
		  driver.findElement(By.cssSelector("a[href='signup']")).click();
		  driver.findElement(By.name("email_id")).sendKeys("aman@gmai.com");
		  driver.findElement(By.name("pwd")).sendKeys("3214");
		  driver.findElement(By.name("pwd2")).sendKeys("321");
		  driver.findElement(By.name("name")).sendKeys("john");
		  driver.findElement(By.name("address")).sendKeys("Gandhinagar");
		  driver.findElement(By.name("city")).sendKeys("Gujrat");
		  driver.findElement(By.tagName("button")).click();
		  
		  File screenshotFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		  try {
			  
			  File destination = new File("C:\\Users\\ravis\\eclipse-workspace\\TestingAirlinesTravelApplication\\Screenshorts\\Validating_password.png");
			  
			  FileUtils.copyFile(screenshotFile, destination);
			  System.out.println("Screenshot captured and saved to: " + destination.getAbsolutePath());
		  } catch(IOException e) {
			  e.printStackTrace();
		  }
		  WebElement bodyele = driver.findElement(By.tagName("body"));
		  String body_text = bodyele.getText();
		  String errormsg = "Error , Passwords do not match.";
		  boolean body_ele = body_text.contains(errormsg);
		  Assert.assertTrue(body_ele);
		  System.out.println(errormsg);
		  
		 
		  
		  
	  }
	  
	  @Test
	  public void validating_Name() {
		  
		  driver.findElement(By.linkText("Login/Signup")).click();
		  driver.findElement(By.cssSelector("a[href='signup']")).click();
		  driver.findElement(By.name("email_id")).sendKeys("john@gmai.com");
		  driver.findElement(By.name("pwd")).sendKeys("4321");
		  driver.findElement(By.name("pwd2")).sendKeys("4321");
		  driver.findElement(By.name("name")).sendKeys("");
		  driver.findElement(By.name("address")).sendKeys("Gandhinagar");
		  driver.findElement(By.name("city")).sendKeys("Gujrat");
		  driver.findElement(By.tagName("button")).click();
		  
		  File screenshotFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		  try {
			  
			  File destination = new File("C:\\Users\\ravis\\eclipse-workspace\\TestingAirlinesTravelApplication\\Screenshorts\\Valading_Name.png");
			  
			  FileUtils.copyFile(screenshotFile, destination);
			  System.out.println("Screenshot cap[tured and saved to: " +destination.getAbsolutePath());
		  } catch(IOException e) {
			  e.printStackTrace();
		  }
		  WebElement bodyele = driver.findElement(By.tagName("body"));
		  String body_text = bodyele.getText();
		  String errormsg = "Name is required.";
		  boolean body_ele = body_text.contains(errormsg);
		  Assert.assertTrue(body_ele);
		  System.out.println(errormsg);
		  
	  }
	  
	  @AfterTest
	  public void closebrowser() {
		  
		  driver.close();
		  
	  }

}
