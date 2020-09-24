package com.TalSale.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.TalSale.BaseClass.TestBase;
import com.TalSale.Utils.ReusableMethods;

public class SignupPage{
	WebDriver driver;

	public SignupPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="new_user_first_name")
	WebElement firstName;
	
	@FindBy(id="new_user_last_name")
	WebElement lastName;
	
	@FindBy(css="#new_user_username")
	WebElement username;
	
	@FindBy(xpath="//*[@class='form-control middle gl-field-error-outline']")
	WebElement email;
	
	@FindBy(id="new_user_password")
	WebElement password;
	
	@FindBy(xpath="//*[@type='submit' and @value='Register']")
	WebElement registerBtn;
	
	@FindBy(xpath="//*[@class='gl-field-error']")
	WebElement ErrorMsg;
	
	
	
	public void enterFirstName(String firstNameValue)
	{
		ReusableMethods.sendKeys(firstName, firstNameValue);
	}
	public void enterLastName(String lastNameValue)
	{
		ReusableMethods.sendKeys(lastName, lastNameValue);
	}
	public void enterUserName(String userNameValue)
	{
		ReusableMethods.sendKeys(username, userNameValue);
	}
	public void enterEmail(String emailValue)
	{
		ReusableMethods.sendKeys(email, emailValue);
	}
	
	public void enterPassword(String passwordValue)
	{
		ReusableMethods.sendKeys(password, passwordValue);
	}
	
	public void clickRegisterBtn()
	{
		ReusableMethods.click(registerBtn);
	}
	
	public String errorMessage()
	{
		return ReusableMethods.getText(ErrorMsg);
	}
	
	
	
	
	
	
	
	
	
}
