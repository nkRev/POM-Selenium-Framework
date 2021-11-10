package com.qa.zerobank.pages;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.PageFactory;

import com.qa.zerobank.base.TestBase;

public class AccountSummaryPage extends TestBase {

	public AccountSummaryPage() {
		PageFactory.initElements(wd, this);
	}

	public void assertAccountSummaryPageTitle() {
		assertEquals(wd.getTitle(), "Zero - Account Summary");
	}

	public void AccountSummaryPageLinkFunctionalityTest() throws InterruptedException {
		List<WebElement> allAnchorTags = wd.findElements(By.tagName("a"));

		// translate all Web Element links to actual link text
		String[] linkText = new String[allAnchorTags.size()];
		int i = 0;
		for (WebElement link : allAnchorTags) {
			linkText[i] = link.getText();
			System.out.println(linkText[i]);
			i++;
		}

		// iterate and use test functionality
		final String privacyLinkText = "https://www.microfocus.com/about/legal/#privacy";

		for (String linkTxt : linkText) {
			//goes to privacy link
			if (linkTxt.equals(privacyLinkText)) {
				wd.findElement(By.linkText(linkTxt)).click();
				System.out.println("Clicked on " + linkText.toString());
				System.out.println(wd.getTitle() + " " + wd.getCurrentUrl());
				Thread.sleep(1000);
				assertEquals(wd.getTitle(), "Zero - Account Summary");
			} else if (linkTxt.equals("") || linkTxt.contains("Settings") || linkTxt.contains("username")) {
				System.out.println("Skipped " + linkTxt);
				continue;
			} else {
				wd.findElement(By.linkText(linkTxt)).click();
				System.out.println(wd.getTitle());
				Thread.sleep(1000);
				wd.navigate().back();

			}
		}

	}
}
