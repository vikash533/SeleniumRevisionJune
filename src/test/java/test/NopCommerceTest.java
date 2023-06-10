package test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class NopCommerceTest {
	public WebDriver driver;
	@BeforeClass
	public void setup() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demo.nopcommerce.com/");
		driver.manage().window().maximize();
	}
	@Test(priority = 1)
	void testLogo() {
		try
		{
		boolean flag = driver.findElement(By.xpath("//img[@alt='nopCommerce demo store']")).isDisplayed();
		Assert.assertEquals(flag,true);
		}
		catch(Exception e) {
			Assert.assertTrue(false);
		}
	}
	@Test(priority = 2)
	void testLogin() {
		try
		{
			driver.findElement(By.xpath("//a[text()='Log in']")).click();
			Thread.sleep(400);
			driver.findElement(By.name("Email")).sendKeys("singhvikash533@gmail.com");
			Thread.sleep(500);
			driver.findElement(By.name("Password")).sendKeys("#Vikash@23");
			driver.findElement(By.xpath("//button[text()='Log in']")).click();
		}
		catch(Exception e) {
			Assert.fail();
			
		}
	}
	@Test(priority = 3)
	void testLogout() throws InterruptedException {
		Thread.sleep(400);
		driver.findElement(By.xpath("//a[text()='Log out']")).click();
	}
	@AfterTest
	void tearDown() {
		driver.close();
	}

}
