package tools;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class pageTools {

	WebDriver driver;

	public pageTools(WebDriver driver) {
		this.driver = driver;
	}

	public void clickBookStore() throws InterruptedException {

		WebElement bookStore = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div/div[6]/div/div[3]/h5"));

		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", bookStore);
		Thread.sleep(1000);
		bookStore.click();
		Thread.sleep(1000);
	}
}
