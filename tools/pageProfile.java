package tools;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class pageProfile {
	WebDriver driver;

	public pageProfile(WebDriver driver) {
		this.driver = driver;
	}

	public void clickBookStoreButton() {
		WebElement bookStoreButton = driver.findElement(By.id("gotoStore"));
		bookStoreButton.click();

	}

	public String getBookTitle() {
		WebElement bookTitle = driver.findElement(By.id("see-book-Learning JavaScript Design Patterns"));
		return bookTitle.getText();

	}

	public void clickDeleteAll() throws InterruptedException {
		WebElement deleteButton = driver.findElements(By.id("submit")).get(2);
		
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", deleteButton);
		Thread.sleep(1000);
		deleteButton.click();
		Thread.sleep(1000);
		
	}

	public void confirmDelete() throws InterruptedException {
		WebElement okButton = driver.findElement(By.id("closeSmallModal-ok"));
		okButton.click();
		Thread.sleep(1000);

		Alert al = driver.switchTo().alert();
		al.accept();
		
	}

	public String getDeletedBook() {
		WebElement textDelete = driver.findElement(By.className("rt-noData"));
		return textDelete.getText();
	}
}
