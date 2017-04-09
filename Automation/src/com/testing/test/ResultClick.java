package com.testing.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class ResultClick extends DriverSetup {
   
	@Test
	public void result_click() throws InterruptedException
	{
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		WebElement f_result_lnk = driver.findElement(By.xpath(".//*[@id='results-list']/li[1]/h2/a"));
		f_result_lnk.click();
		Thread.sleep(10000);
	}
	
}
