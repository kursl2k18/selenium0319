package pl.lait.selenium;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MenuTest {
	
	WebDriver driver;
		
	@Before
	public void bifor() {
		//otwieramy przeglądarkę przed testem
		Init.log("Otwieram okno przeglądarki");
		driver = Init.getDriver();
	}
	
	@Test
	public void topMenu() {
		Init.log("klikam w link CONTACT");
		driver.findElement(By.linkText("CONTACT")).click();
		Init.log("Klikam w link SUPPORT");
		driver.findElement(By.linkText("SUPPORT")).click();
		driver.findElement(By.linkText("REGISTER")).click();
		driver.findElement(By.linkText("SIGN-ON")).click();
		Init.log(driver.getTitle());
		
		driver.findElement(By.name("userName")).sendKeys("admdz");
		driver.findElement(By.name("password")).sendKeys("qwe123");
		driver.findElement(By.name("login")).click();
		
		Init.sleep(5);
	}
	
	@After
	public void awter() {
		//tu trzeba zamknąć przeglądarkę
		Init.close();
	}

}
