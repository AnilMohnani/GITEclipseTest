package com.TalSale.BaseClass;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;


public class TestBase {
	public WebDriver driver;
	public Properties prop;
	FileInputStream fis;
	String path=System.getProperty("user.dir")+"\\src\\main\\java\\com\\TalSale\\Resources\\Global.properties";
	
	public WebDriver browserInitialisation()
	{
		try {
			fis = new FileInputStream(path);
			prop = new Properties();
			prop.load(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		return driver;
	}
	
}
