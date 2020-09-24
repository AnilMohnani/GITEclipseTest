package com.TalSale.Utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.TalSale.BaseClass.TestBase;

public class ReusableMethods extends TestBase{
	WebDriver driver;
	public static void sendKeys(WebElement element,String value)
	{
		element.sendKeys(value);
	}
	
	public static void click(WebElement element)
	{
		element.click();
	}
	
	public static String getText(WebElement element)
	{
		return element.getText();
	}
}
