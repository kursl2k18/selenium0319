package pl.lait.selenium;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import pl.lait.pageObjects.LoginPage;
import pl.lait.pageObjects.ReservationPage;
import pl.lait.pageObjects.ReservationPage2;

public class LoginTest {
	
	WebDriver driver;
	
	
	@Before
	public void bifor() {
		driver = Init.getDriver();
	}
	
	@Test
	public void loginTest() {
		LoginPage lp = new LoginPage(driver);
		lp.goToLoginPage();
		lp.loginAs("admdz", "qwe123");
	}
	
	@Test
	public void reserveTest() {
		LoginPage lp = new LoginPage(driver);
		lp.goToLoginPage();
		lp.loginAs("admdz", "qwe123");
		ReservationPage rp = new ReservationPage();
		rp.from("Frankfurt", "3", "16");
		rp.to("London", "3", "20");
		rp.passCount("2");
		rp.firstClass();
		rp.submit();
		//2gi etap
		ReservationPage2 rp2 = new ReservationPage2();
		rp2.selectFlights(2, 4);
		rp2.submit();
		//3 etap
		rp2.pass0("Adam", "AAAAAA", "KSML");
		Init.sleep(1);
		rp2.submit2();
		
	}

	@After
	public void awter() {
		//tu trzeba zamknąć przeglądarkę
		Init.close();
	}

	
}
