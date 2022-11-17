package myAssignment;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MyAssignment {

	public static void main(String args[]) {

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\p\\Downloads\\Assignment\\Assignment\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		driver.get("https://webdriver.io/");

		WebElement greenLightHouseIntegrationSection = driver.findElement(By.xpath("//*[text()='speedIndex']"));

		Actions act = new Actions(driver);

		act.moveToElement(greenLightHouseIntegrationSection).build().perform();

		String codeLine1 = driver.findElement(By.xpath(
				"//span[text()='await browser.enablePerformanceAudits({']/parent::span/following-sibling::span[1]"))
				.getText();

		String codeLine2 = driver.findElement(By.xpath(
				"//span[text()='await browser.enablePerformanceAudits({']/parent::span/following-sibling::span[2]"))
				.getText();

		String codeLine3 = driver.findElement(By.xpath(
				"//span[text()='await browser.enablePerformanceAudits({']/parent::span/following-sibling::span[3]"))
				.getText();

		List<String> copiedCode = new ArrayList<String>();

		copiedCode.add(codeLine1);

		copiedCode.add(codeLine2);

		copiedCode.add(codeLine3);

		System.out.println("Copied code has : " + copiedCode.size() + " lines");

		for (int i = 0; i < copiedCode.size(); i++) {
			if (copiedCode.get(i).trim().equalsIgnoreCase(driver.findElement(By.xpath(
					"//span[text()='await browser.enablePerformanceAudits({']/parent::span/following-sibling::span["
							+ (i + 1) + "]"))
					.getText().trim())) {
				System.out.println("The copied text is matched with the text given by user");
			} else {
				System.out.println("The copied text is not matched with the text given by user");
			}
		}
		driver.quit();

	}

}
