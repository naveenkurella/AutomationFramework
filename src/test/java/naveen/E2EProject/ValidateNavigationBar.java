package naveen.E2EProject;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.base;

public class ValidateNavigationBar extends base {
	public WebDriver driver;

	@BeforeTest
	public void initialaize() throws IOException {
		driver = initializeDriver();
		driver.get(prop.getProperty("url"));

	}

	@Test
	public void basePageNavigation() throws IOException {

		LandingPage l = new LandingPage(driver);

		if (l.getPopUpSize().size() > 0) {
			l.getPopUp().click();
		}

		Assert.assertTrue(l.getNavBar().isDisplayed());
	}

	@AfterTest
	public void tearDown() {

		driver.close();
	}

}
