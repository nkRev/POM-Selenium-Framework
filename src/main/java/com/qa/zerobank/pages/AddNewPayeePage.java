package com.qa.zerobank.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.zerobank.base.TestBase;

public class AddNewPayeePage extends TestBase {

	@FindBy(id = "np_new_payee_name")
	WebElement npName;
	@FindBy(css = "[name='address']")
	WebElement npAddress;
	@FindBy(css = "#np_new_payee_account")
	WebElement npAccount;
	@FindBy(name = "details")
	WebElement npDetails;
	@FindBy(id = "submit")
	WebElement addBtn;
	@FindBy(xpath = "//a[contains(text(),'Add New Payee')]")
	WebElement addNewPayee;
	@FindBy(linkText = "Pay Bills")
	WebElement payBills;

	public AddNewPayeePage() {
		PageFactory.initElements(wd, this);
	}

	public void addNewPayee() throws InterruptedException {
		payBills.click();
		addNewPayee.click();
		wd.manage().wait(2000);

		npName.sendKeys("Amazon");
		npAddress.sendKeys("410 Terry Ave N, Seattle, WA 98109");
		npAccount.sendKeys("12345120");
		npDetails.sendKeys("ordered stuff");
		addBtn.click();
	}

}
