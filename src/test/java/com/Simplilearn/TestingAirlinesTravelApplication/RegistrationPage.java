package com.Simplilearn.TestingAirlinesTravelApplication;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RegistrationPage {
	
	public void register() throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.get("http://localhost:9098/FlyAway/");
		Thread.sleep(2000);
		driver.findElement(By.linkText("Login/Signup")).click();
		driver.findElement(By.cssSelector("a[href='signup']")).click();
		driver.findElement(By.name("email_id")).sendKeys("Raju@gmail.com");
		driver.findElement(By.name("pwd")).sendKeys("4321");
		driver.findElement(By.name("pwd2")).sendKeys("4321");
		driver.findElement(By.name("name")).sendKeys("john");
		driver.findElement(By.name("address")).sendKeys("Gandhinagar");
		driver.findElement(By.name("city")).sendKeys("Gujrat");
		
		File screenshortFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		try {
			
			File destination = new File("C:\\Users\\ravis\\eclipse-workspace\\TestingAirlinesTravelApplication\\Screenshorts\\RegistrationPage.png");
			
			FileUtils.copyFile(screenshortFile, destination);
			
			System.out.println("Screenshot captured and saved to: " + destination.getAbsolutePath());
			
			
		} catch (IOException e) {
			e.printStackTrace();
			
		}
		
	
	driver.findElement(By.tagName("button")).click();
	driver.quit();
	}

}
