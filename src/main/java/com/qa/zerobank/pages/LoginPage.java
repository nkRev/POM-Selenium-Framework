package com.qa.zerobank.pages;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.zerobank.base.TestBase;

public class LoginPage extends TestBase {
	@FindBy(id = "user_login")
	WebElement login_username;
	@FindBy(name = "user_password")
	WebElement login_password;
	@FindBy(css = ".icon-question-sign")
	WebElement questionMark;
	@FindBy(css = "[name='user_remember_me'")
	WebElement rememberMeCheckBox;
	@FindBy(name = "submit")
	WebElement signinBtn;
	@FindBy(linkText = "Forgot your password ?")
	WebElement forgotPw;

	public LoginPage() {
		PageFactory.initElements(wd, this);
	}

	public void assertLoginPageTitle() {
		assertEquals(wd.getTitle(), "Zero - Log in");
	}

	public AccountSummaryPage loginToAccountSummaryPage() {
		defaultLogin();
		return new AccountSummaryPage();
	}

	public AddNewPayeePage loginToNewPayee() {
		defaultLogin();
		return new AddNewPayeePage();
	}

	public TransferFundsPage logintoTransferfunds() {
		defaultLogin();
		return new TransferFundsPage();
	}

	public PaySavedPayeePage loginToPaySavedPayee() {
		defaultLogin();
		return new PaySavedPayeePage();
	}

	public PurchaseForeignCurrencyPage loginToPurchaseForeignCurrency() {
		defaultLogin();
		return new PurchaseForeignCurrencyPage();
	}

	public void defaultLogin() {
		login_username.sendKeys(p.getProperty("username"));
		login_password.sendKeys(p.getProperty("password"));
		signinBtn.click();

		if (wd.findElement(By.id("details-button")) != null) {
			wd.findElement(By.id("details-button")).click();

			if (wd.findElement(By.id("proceed-link")) != null) {
				wd.findElement(By.id("proceed-link")).click();
			}
		}
	}
}
