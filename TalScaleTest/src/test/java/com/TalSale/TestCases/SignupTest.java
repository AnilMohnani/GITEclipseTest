package com.TalSale.TestCases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.TalSale.BaseClass.TestBase;
import com.TalSale.Pages.SignupPage;

public class SignupTest extends TestBase {
	SignupPage signupPage;

	@BeforeMethod
	public void setup() {
		driver = browserInitialisation();
		driver.get(prop.getProperty("url"));

	}

	@AfterMethod
	public void tearDown() {
		driver.close();
	}

	@Test
	public void test1() {
		signupPage = new SignupPage(driver);
		signupPage.clickRegisterBtn();
		System.out.println("ok");
		signupPage.errorMessage();
		Assert.assertEquals(signupPage.errorMessage(), "This field is required.");

	}

	@Test
	public void test2() {

	}

	@Test
	public void test3() {
		signupPage.enterUserName("#%");
		Assert.assertEquals(signupPage.errorMessage(), "Please create a username with only alphanumeric characters.");

	}

	@Test(dataProvider = "getData")
	public void test4(String first, String last, String user, String email, String password, String invF, String invUser,
			String invEmail, String invPass, String errorFirst, String errorUser, String errorEmail,
			String errorPassword,String googleError,String googlePasswordError) {
		signupPage.enterFirstName(first);
		signupPage.enterLastName(last);
		signupPage.enterUserName(user);
		signupPage.enterEmail(invEmail);
		signupPage.enterPassword(password);
		signupPage.clickRegisterBtn();
		Assert.assertEquals(signupPage.errorMessage(), invEmail);
	}

	@Test(dataProvider="getData")
	public void test5(String first, String last, String user, String email, String password, String invF, String invUser,
			String invEmail, String invPass, String errorFirst, String errorUser, String errorEmail,
			String errorPassword,String googleError,String googlePasswordError) {
		signupPage.enterFirstName(first);
		signupPage.enterLastName(last);
		signupPage.enterUserName(user);
		signupPage.enterEmail(email);
		signupPage.enterPassword(invPass);
		signupPage.clickRegisterBtn();
		Assert.assertEquals(signupPage.errorMessage(), errorPassword);
	}

	@DataProvider
	public Object[][] getData() {
		return new Object[][] { { "Anil", "Kumar", "Anil999878", "mohnani.anil@gmail.com", "Anil99$$", "A", "K", "#$%",
				"mohnani.anil", "Anil", "This field is required.",
				"Please create a username with only alphanumeric characters.", "Please provide a valid email address.",
				"Minimum length is 8 characters.", "Couldn’t find your Google Account",
				"Wrong password. Try again or click Forgot password to reset it" } };

	}

}
