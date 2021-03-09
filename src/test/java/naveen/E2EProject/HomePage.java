package naveen.E2EProject;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.ForgotPassword;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.base;

public class HomePage extends base {
	public WebDriver driver;

	@Test(dataProvider = "getData")
	public void basePageNavigation(String un, String pw) throws IOException {
		driver = initializeDriver();
		driver.get(prop.getProperty("url"));

		LandingPage l = new LandingPage(driver);
		//LoginPage lp = l.getLogin();
		
		if(l.getPopUpSize().size()>0) {
			l.getPopUp().click();
		}
		l.getLogin();
		LoginPage lp=new LoginPage(driver);
		lp.getEmail().sendKeys(un);
		lp.getPassword().sendKeys(pw);;
		lp.getLogin().click();
		ForgotPassword fp=lp.forgotPassword();
		fp.getEmail().sendKeys("abc@gmail.com");
	//	fp.sendMeInstruction().click();
		
	}

	@AfterTest
	public void tearDown() {

		driver.close();
	}

	@DataProvider
	public Object[][] getData() {

		// row stands for no.of different kind of data
		// coloumn stands for no.of values for each kind of data
		Object data[][] = new Object[2][2];
		data[0][0] = "abc@qw.com";
		data[0][1] = "123";
		data[1][0] = "abc@qw.net";
		data[1][1] = "123";
		return data;
	}

}
