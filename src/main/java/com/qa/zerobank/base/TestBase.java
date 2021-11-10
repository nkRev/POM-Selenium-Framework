package com.qa.zerobank.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class TestBase {
	public static WebDriver wd;
	public static Properties p;

	public TestBase() {
		try {
			p = new Properties();
			FileInputStream ip = new FileInputStream(
					System.getProperty("user.dir") + "\\src\\main\\java\\com\\qa\\zerobank\\config\\config.properties");
			p.load(ip);

		} catch (FileNotFoundException e) {
			e.printStackTrace();

		} catch (IOException e) {
			e.printStackTrace();

		}
	}

	public static void initialization() {
		String browserName = p.getProperty("browser");
		String bdPath = System.getProperty("user.dir") + "\\src\\main\\resources\\com\\qa\\zerobank\\browserdriver\\";

		if (browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", bdPath + "chromedriver.exe");
			wd = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("ff")) {
			System.setProperty("webdriver.gecko.driver", bdPath + "geckodriver.exe");
			wd = new FirefoxDriver();
		} else if (browserName.equalsIgnoreCase("ie")) {
			System.setProperty("webdriver.ie.driver", bdPath + "IEDriverServer.exe");
			wd = new InternetExplorerDriver();
		}

		wd.manage().window().maximize();
		wd.manage().deleteAllCookies();
		wd.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		wd.get(p.getProperty("url"));

	}

}
