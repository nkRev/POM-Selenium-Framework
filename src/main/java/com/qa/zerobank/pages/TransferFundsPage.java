package com.qa.zerobank.pages;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.qa.zerobank.base.TestBase;

public class TransferFundsPage extends TestBase{

	@FindBy(id = "tf_fromAccountId")
	WebElement fromAccId;
	@FindBy(id = "tf_toAccountId")
	WebElement toAccId;
	@FindBy(id= "tf_amount")
	WebElement amtTextbox;
	@FindBy(name = "description")
	WebElement desc;
	@FindBy(id = "btn_submit")
	WebElement submitBtn;
	@FindBy(xpath = "//a[contains(text(),'Transfer Funds')]")
	WebElement transferFunds;
	
	public TransferFundsPage() {
		PageFactory.initElements(wd, this);
	}
	
	public void assertPageTitle() {
		assertEquals(wd.getTitle(), "Zero - Transfer Funds");
	}

	public void transferFunds() {
		transferFunds.click();
		Select fromAccount = new Select(fromAccId);
		Select toAccount = new Select(toAccId);
		fromAccount.selectByIndex(2);
		toAccount.selectByIndex(5);
		amtTextbox.sendKeys("500");
		desc.sendKeys("Investing $500 into my brokerage account");
		submitBtn.click();
		
	}
}
