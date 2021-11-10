package com.qa.zerobank.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.zerobank.base.TestBase;
import com.qa.zerobank.pages.HomePage;
import com.qa.zerobank.pages.LoginPage;
import com.qa.zerobank.pages.PurchaseForeignCurrencyPage;

public class PurchaseForeignCurrencyTestCase extends TestBase {
	LoginPage lp;
	HomePage hp;
	PurchaseForeignCurrencyPage purchaseForeignCurrencyPage;

	public PurchaseForeignCurrencyTestCase() {
		super();
	}

	@BeforeMethod
	public void setup() {
		initialization();
		lp = new LoginPage();
		hp = new HomePage();
		purchaseForeignCurrencyPage = new PurchaseForeignCurrencyPage();
	}

	@AfterMethod
	public void cleanup() {
		wd.close();
		wd.quit();
	}

	@Test
	public void purchaseForeignCurrencyFunctionality() {
		hp.assertHomePageTitle();
		hp.clickOnSigninButton();
		lp.assertLoginPageTitle();
		lp.loginToPurchaseForeignCurrency();
		purchaseForeignCurrencyPage.purchaseForeignCurrencyFunctionality();
	}
}
