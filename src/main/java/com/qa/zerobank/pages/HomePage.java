package com.qa.zerobank.pages;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.zerobank.base.TestBase;

public class HomePage extends TestBase {
	@FindBy(id = "signin_button")
	WebElement home_signin_button;

	@FindBy(name = "searchTerm")
	WebElement searchBox;

	@FindBy(linkText = "Zero Bank")
	WebElement brankLinkZeroBank;

	@FindBy(css = "#online-banking")
	WebElement buttonMoreServices;

	@FindBy(className = "brand")
	WebElement brandLogo;

	// initialize page factory, passes driver and current objs
	public HomePage() {
		PageFactory.initElements(wd, this);
	}

	public void assertHomePageTitle() {
		assertEquals(wd.getTitle(), "Zero - Personal Banking - Loans - Credit Cards", "Home page title assert failed");

	}

	public LoginPage clickOnSigninButton() {
		home_signin_button.click();
		return new LoginPage();
	}

	public boolean validateBrandLogo() {
		return brandLogo.isDisplayed();
	}
}
