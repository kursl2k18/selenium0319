package pl.lait.selenium;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;


public class Init {
	
	static WebDriver driver;
	
	
	public static WebDriver getDriver() {
		
		//"C:\\LAIT\\chromedriver\\chromedriver.exe"
		
		URL url = null;
		try {
			url = new URL("http://localhost:4444/wd/hub");
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		DesiredCapabilities cap = DesiredCapabilities.chrome();
		//cap.setPlatform(Platform.MAC);
		System.setProperty("webdriver.chrome.driver", "/Users/adam/Documents/LAIT/chromedriver");
		if(driver == null) {
			//driver = new ChromeDriver();
			driver = new RemoteWebDriver(url, cap);
			driver.get("http://newtours.demoaut.com/");
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			return driver;
		} else {
			return driver;
		}
		
		
	}
	
	public static void log(String msg) {
		System.out.println(" --- " + msg + " --- ");
	}
	
	public static void close() {
		driver.close();
		driver.quit();
		driver = null;
	}
	public static void sleep(int seconds) {
		try {
			Thread.sleep(seconds * 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
