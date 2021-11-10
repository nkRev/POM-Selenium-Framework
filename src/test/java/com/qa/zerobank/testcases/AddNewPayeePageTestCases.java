package com.qa.zerobank.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.zerobank.base.TestBase;
import com.qa.zerobank.pages.AddNewPayeePage;
import com.qa.zerobank.pages.HomePage;
import com.qa.zerobank.pages.LoginPage;

public class AddNewPayeePageTestCases extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	AddNewPayeePage newPayeePage;

	public AddNewPayeePageTestCases() {
		super();
	}

	@BeforeMethod
	public void setup() {
		initialization();
		loginPage = new LoginPage();
		homePage = new HomePage();
		newPayeePage = new AddNewPayeePage();
	}

	@AfterMethod
	public void cleanup() {
		wd.close();
		wd.quit();
	}

	@Test
	public void addNewPayeeTest() {
		try {
			homePage.clickOnSigninButton();
			loginPage.loginToNewPayee();
			newPayeePage.addNewPayee();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
