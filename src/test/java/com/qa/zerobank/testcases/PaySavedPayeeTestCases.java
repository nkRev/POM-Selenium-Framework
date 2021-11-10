package com.qa.zerobank.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.zerobank.base.TestBase;
import com.qa.zerobank.pages.HomePage;
import com.qa.zerobank.pages.LoginPage;
import com.qa.zerobank.pages.PaySavedPayeePage;

public class PaySavedPayeeTestCases extends TestBase{
	
	LoginPage lp;
	HomePage hp;
	PaySavedPayeePage psp;
	
	public PaySavedPayeeTestCases() {
		super();
	}
	
	@BeforeMethod
	public void setup() {
		initialization();
		lp = new LoginPage();
		hp = new HomePage();
		psp = new PaySavedPayeePage();
	}
	
	@AfterMethod
	public void cleanup() {
		wd.close();
		wd.quit();
	}
	
	@Test
	public void paySavedPayeeFunctionalityTest() {
		hp.clickOnSigninButton();
		lp.loginToPaySavedPayee();
		psp.paySavedPayeeFunctionalityTest();
	}

}
