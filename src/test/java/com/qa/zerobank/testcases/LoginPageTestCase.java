package com.qa.zerobank.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.zerobank.base.TestBase;
import com.qa.zerobank.pages.AccountSummaryPage;
import com.qa.zerobank.pages.AddNewPayeePage;
import com.qa.zerobank.pages.HomePage;
import com.qa.zerobank.pages.LoginPage;
import com.qa.zerobank.pages.TransferFundsPage;

public class LoginPageTestCase extends TestBase{
	LoginPage loginPage;
	HomePage homePage;
	AccountSummaryPage accountSummaryPage;
	TransferFundsPage tFundsPage;
	AddNewPayeePage addnewPayeepage;

	@BeforeMethod
	public void setup() {
		
		initialization();
		homePage = new HomePage();
		loginPage = new LoginPage();
		accountSummaryPage = new AccountSummaryPage();
		tFundsPage = new TransferFundsPage();
		accountSummaryPage = new AccountSummaryPage();
		addnewPayeepage = new AddNewPayeePage();
	}
	
	@AfterMethod 
	public void cleanup(){
		wd.close();
		wd.quit();
	}
	
	@Test
	public void validateLoginFunctionality() {
		loginPage = homePage.clickOnSigninButton();
		accountSummaryPage = loginPage.loginToAccountSummaryPage();
		accountSummaryPage.assertAccountSummaryPageTitle();
	}
}
