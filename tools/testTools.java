package tools;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class testTools {

	WebDriver driver;
	pageBooks pageBooks;
	pageTools pageTools;
	pageLogin pageLogin;
	pageProfile pageProfile;

	@BeforeClass
	public void preKlase() {
		System.setProperty("webdriver.chrome.driver", "driver-lib\\chromedriver.exe");
		this.driver = new ChromeDriver();
		this.pageBooks = new pageBooks(driver);
		this.pageTools = new pageTools(driver);
		this.pageLogin = new pageLogin(driver);
		this.pageProfile = new pageProfile(driver);
		driver.manage().window().maximize();

	}

	@BeforeMethod
	public void setup() throws InterruptedException {
		driver.navigate().to("https://demoqa.com/");
		Thread.sleep(2000);
	}

	@Test(priority = 0)
	public void logIn() throws InterruptedException {
		pageTools.clickBookStore();
		Thread.sleep(2000);
		pageBooks.clickLogin();
		Thread.sleep(2000);
		pageLogin.login();
		Thread.sleep(2000);
		
		String text = pageBooks.getUserName();
		Assert.assertEquals("BiljaK", text);
		
		pageBooks.clickBook();
		Thread.sleep(2000);
		pageBooks.addBooks();
		Thread.sleep(2000);
		pageBooks.clickProfile();
		Thread.sleep(2000);

		String bookTitle = pageProfile.getBookTitle();
		Assert.assertEquals("Learning JavaScript Design Patterns", bookTitle);
		Thread.sleep(5000);

		pageProfile.clickDeleteAll();
		Thread.sleep(2000);
		pageProfile.confirmDelete();
		Thread.sleep(2000);

		String izbrisana = pageProfile.getDeletedBook();
		Assert.assertEquals("No rows found", izbrisana);
		Thread.sleep(2000);

	}

	@AfterMethod
	public void afterTest() throws InterruptedException {
		driver.manage().deleteAllCookies();
		driver.navigate().refresh();
		Thread.sleep(2000);
	}

	@AfterClass
	public void posleKlase() {
		driver.close();
		System.out.println("Izvrsava se posle klase");
	}
}
