package com.qa.zerobank.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.zerobank.base.TestBase;
import com.qa.zerobank.pages.AccountSummaryPage;
import com.qa.zerobank.pages.HomePage;
import com.qa.zerobank.pages.LoginPage;

public class AccountSummaryTestCases extends TestBase{
	LoginPage lp;
	HomePage hp;
	AccountSummaryPage accountSummaryPage;
	
	public AccountSummaryTestCases() {
		super();
	}
	
	@BeforeMethod
	public void setup() {
		initialization();
		lp = new LoginPage();
		hp = new HomePage();
		accountSummaryPage = new AccountSummaryPage();
	}
	
	@AfterMethod
	public void cleanup() {
		wd.close();
		wd.quit();
	}
	
	/**
	 * Tests All Links except 
	 * for settings and username dropdown in navbar
	 * nav-tabs are tested also
	 */
	@Test
	public void accountSummaryFunctionality() {
		hp.assertHomePageTitle();
		hp.clickOnSigninButton();
		lp.assertLoginPageTitle();
		lp.loginToAccountSummaryPage();
		try {
			accountSummaryPage.AccountSummaryPageLinkFunctionalityTest();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
