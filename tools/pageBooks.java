package tools;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class pageBooks {
	WebDriver driver;

	public pageBooks(WebDriver driver) {
		this.driver = driver;
	}

	public void clickLogin() {

		WebElement loginButton = driver.findElement(By.id("login"));
		loginButton.click();
	}

	public void clickLogout() {

		WebElement logoutButton = driver.findElement(By.id("submit"));
		logoutButton.click();
	}

	public String getUserName() {

		WebElement userName = driver.findElement(By.id("userName-value"));
		return userName.getText();
	}

	public void clickBook() {
		WebElement bookButton = driver
				.findElement(By.xpath("//*[@id=\"see-book-Learning JavaScript Design Patterns\"]/a"));
		bookButton.click();
	}

	public void addBooks() throws InterruptedException {
		WebElement addBookButton = driver.findElements(By.xpath("//*[@id=\"addNewRecordButton\"]")).get(1);

		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", addBookButton);
		Thread.sleep(1000);
		addBookButton.click();
		Thread.sleep(1000);
		
		Alert al = driver.switchTo().alert();
		al.accept();
	}

	public void clickProfile() {
		WebElement profileButton = driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div[1]/div/div/div[6]/div/ul/li[3]"));
		profileButton.click();
	}

}
