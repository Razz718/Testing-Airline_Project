package com.Simplilearn.TestingAirlinesTravelApplication;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Testcases {
	
	@Test(priority = 1)
	public class createuser extends RegistrationPage{
		ChromeDriver driver;
		@Test
		public void singup() throws InterruptedException{
			
			RegistrationPage obj = new createuser();
			obj.register();
		}
	}
	
	@Test(priority = 2)
	public class loginuser extends LoginPage{
		@Test
		public void login() throws InterruptedException{
			LoginPage obj = new loginuser();
			obj.sigin();
		}
		
	}
	@Test(priority = 3)
	public class homepage extends Homepage{
		@Test
		public void flightsearch() throws InterruptedException{
			Homepage obj = new homepage();
			obj.homepage();
			
		}
	}
	
	@Test(priority = 4)
	public class flightbooking extends Bookings{
		@Test
		public void book_flight() throws InterruptedException{
			Bookings obj = new flightbooking();
			obj.flights();
		}
	}
	
	
		
		
	}


