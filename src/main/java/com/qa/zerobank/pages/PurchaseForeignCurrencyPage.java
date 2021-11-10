package com.qa.zerobank.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.qa.zerobank.base.TestBase;

public class PurchaseForeignCurrencyPage extends TestBase {
	@FindBy(id = "pc_currency")
	WebElement currencySelector;
	@FindBy(xpath = "//input[@id='pc_amount']")
	WebElement amtBox;
	@FindBy(linkText = "Pay Bills")
	WebElement payBills;
	@FindBy(linkText = "Purchase Foreign Currency")
	WebElement purchaseForeignCurrency;
	@FindBy(id = "pc_inDollars_true")
	WebElement usdRadioBtn;
	@FindBy(id = "purchase_cash")
	WebElement purchaseBtn;
	
	public PurchaseForeignCurrencyPage() {
		PageFactory.initElements(wd, this);
	}
	
	public void purchaseForeignCurrencyFunctionality() {
		payBills.click();
		purchaseForeignCurrency.click();
		
		Select currencyDropdown = new Select(currencySelector);
		currencyDropdown.selectByIndex(5);
		amtBox.sendKeys("100");
		usdRadioBtn.click();
		purchaseBtn.click();
	}
}
