package com.testing.test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class DriverSetup {

	public static WebDriver driver;
	
	@BeforeSuite
	void launch_browser()
	{
		FirefoxProfile profile = new FirefoxProfile();
	    profile.setPreference("browser.download.folderList", 0); //downloads to desktop
	    profile.setPreference("browser.helperApps.neverAsk.openFile","application/pdf");
	    profile.setPreference("browser.helperApps.neverAsk.saveToDisk","application/pdf");
	    profile.setPreference("browser.helperApps.alwaysAsk.force", false);
	    profile.setPreference("browser.download.manager.showAlertOnComplete", false); 
	    profile.setPreference("browser.download.manager.closeWhenDone", false);
	    driver = new FirefoxDriver(profile);
		driver.manage().window().maximize();
		driver.get("http://link.springer.com/");
	}
	
	
	@BeforeTest
	public void search_keyword()
	{   
		WebElement txt_Search = driver.findElement(By.id("query"));
	    txt_Search.sendKeys("maths");
	    WebElement btn_Search = driver.findElement(By.id("search"));
		btn_Search.click();
		WebElement chk_inclpre = driver.findElement(By.id("results-only-access-checkbox"));
		chk_inclpre.click();
	}
	
	
	@AfterSuite
	void close_browser()
	{
		driver.quit();
		System.out.println("Closing the browser");
	}
	
}

