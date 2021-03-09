package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ForgotPassword {

	public WebDriver driver;

	public ForgotPassword(WebDriver driver) {
		this.driver = driver;
	}

	By email = By.id("user_email");
	By send = By.cssSelector("[value*='Send Me Instruction']");
	
	public WebElement getEmail() {

		return driver.findElement(email);
	}

	public WebElement sendMeInstruction() {

		return driver.findElement(send);
	}

	
}
