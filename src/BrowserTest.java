import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import junit.framework.Assert;

public class BrowserTest extends Base {

	public static void main(String[] args) throws MalformedURLException {
		AndroidDriver<AndroidElement> driver = CapabilitiesDefine();

		driver.get("https://rahulshettyacademy.com/angularAppdemo/");

		driver.findElement(By.cssSelector(".navbar-toggler")).click();

		driver.findElement(By.cssSelector("a[href*='products']")).click();

		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("window.scrollBy(0,1000)", "");

		/*
		 * here we have 3 li elements with same class so we need to identify that we //
		 * need third one the we traverse to child div then child div again then the //
		 * element we want which is with tag a
		 */
		String text = driver.findElement(By.xpath("(//li[@class='list-group-item'])[3]/div/div/a")).getText();

		Assert.assertEquals(text, "Devops");

	}

}
