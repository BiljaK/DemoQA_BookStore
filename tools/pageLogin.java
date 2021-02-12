package tools;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class pageLogin {
	WebDriver driver;

	public pageLogin(WebDriver driver) {
		this.driver = driver;
	}

	public void login() {
		setUserNameInputField("BiljaK");
		setPasswordInputField("Bilj@K123456");
		clickLogin();
	}

	public WebElement getUserNameInputField() {
		return driver.findElement(By.id("userName"));

	}

	public void setUserNameInputField(String korisnickoIme) {
		getUserNameInputField().sendKeys(korisnickoIme);
	}

	public WebElement getPasswordInputField() {
		return driver.findElement(By.id("password"));

	}

	public void setPasswordInputField(String korisnickaSifra) {
		getPasswordInputField().sendKeys(korisnickaSifra);
	}

	public void clickLogin() {
		WebElement logInButton = driver.findElement(By.id("login"));
		logInButton.click();
	}
	
}
