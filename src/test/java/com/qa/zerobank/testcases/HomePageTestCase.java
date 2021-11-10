package com.qa.zerobank.testcases;

import static org.testng.Assert.assertTrue;

import java.sql.Connection;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.zerobank.base.TestBase;
import com.qa.zerobank.pages.HomePage;
import com.qa.zerobank.pages.LoginPage;

public class HomePageTestCase extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	// TestUtil testUtil;
	Connection conn;

	public HomePageTestCase() {
		super();
	}

	@BeforeMethod
	public void setup() {
		initialization();
		loginPage = new LoginPage();
		homePage = new HomePage();
		// testUtil = new TestUtil();
	}

	@AfterMethod
	public void teardown() {
		wd.close();
		wd.quit();
	}

	@Test
	public void validateHomePage() {
		homePage.assertHomePageTitle();
	}

	@Test
	public void valdiateLogo() {
		assertTrue(homePage.validateBrandLogo());
	}

	@Test
	public void dbConnectionTest() {
//		Connection conn = testUtil.getConnection();
//		testUtil.
	}
}
