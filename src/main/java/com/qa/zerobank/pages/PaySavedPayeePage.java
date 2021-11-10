package com.qa.zerobank.pages;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.qa.zerobank.base.TestBase;

public class PaySavedPayeePage extends TestBase {

	@FindBy(id = "sp_payee")
	WebElement payee;
	@FindBy(name = "account")
	WebElement account;
	@FindBy(name = "amount")
	WebElement amountBox;
	@FindBy(xpath = "//input[@id='sp_date']")
	WebElement datePicker;
	@FindBy(name = "description")
	WebElement desc;

	@FindBy(partialLinkText = "Pay Saved Pay")
	WebElement paySavedPayeeLink;
	@FindBy(id = "pay_saved_payees")
	WebElement payBtn;
	
	@FindBy(linkText = "Pay Bills")
	WebElement payBills;

	public PaySavedPayeePage() {
		PageFactory.initElements(wd, this);
	}

	public void paySavedPayeeFunctionalityTest() {
		payBills.click();
		paySavedPayeeLink.click();
		Select payeeInput = new Select(payee);
		Select accountDropDown = new Select(account);
		payeeInput.selectByValue("apple");
		accountDropDown.selectByValue("3");
		amountBox.sendKeys("100");

		Calendar cal = Calendar.getInstance();
		SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd");
		String date = formatDate.format(cal.getTime());
		datePicker.sendKeys(date);

		desc.sendKeys("paid bills 100 dollars.");
		payBtn.click();

	}

}
