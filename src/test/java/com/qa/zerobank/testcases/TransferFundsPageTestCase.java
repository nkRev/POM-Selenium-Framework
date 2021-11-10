package com.qa.zerobank.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.zerobank.base.TestBase;
import com.qa.zerobank.pages.HomePage;
import com.qa.zerobank.pages.LoginPage;
import com.qa.zerobank.pages.TransferFundsPage;

public class TransferFundsPageTestCase extends TestBase{
	
	LoginPage lp;
	HomePage hp;
	TransferFundsPage tfundsPage;
	
	public TransferFundsPageTestCase() {
		super();
	}
	
	@BeforeMethod
	public void setup() {
		initialization();
		lp = new LoginPage();
		hp = new HomePage();
		tfundsPage = new TransferFundsPage();
	}
	
	@AfterMethod
	public void cleanup() {
		wd.close();
		wd.quit();
	}
	
	@Test
	public void transferFundsFunctionalityTest() {
		hp.clickOnSigninButton();
		lp.logintoTransferfunds();
		tfundsPage.transferFunds();
	}
}
