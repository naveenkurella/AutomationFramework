package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {

	public WebDriver driver;

	public LandingPage(WebDriver driver) {
		this.driver = driver;
	}

	By signIn = By.cssSelector("a[href*='sign_in']");
	By title = By.cssSelector(".text-center>h2");
	By navbar = By.cssSelector(".nav.navbar-nav.navbar-right>li>a");
	By popUp=By.xpath("//button[text()='NO THANKS']");
	public void getLogin() {

		if(getPopUpSize().size()>0) {
			getPopUp().click();
		}
		 driver.findElement(signIn).click();
		// LoginPage lp = new LoginPage(driver);
		 //return lp;
	}

	public WebElement getTitle() {

		return driver.findElement(title);
	}

	public WebElement getNavBar() {

		return driver.findElement(navbar);
	}
	
	public List<WebElement> getPopUpSize() {

		return driver.findElements(popUp);
	}
	
	public WebElement getPopUp() {

		return driver.findElement(popUp);
	}
}
