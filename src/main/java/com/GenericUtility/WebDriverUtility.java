package com.GenericUtility;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

public class WebDriverUtility  {
	
	public void maximizebrowser(WebDriver driver) {
		driver.manage().window().maximize();
	}
	
	public void waituntillpageload(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	}

}
