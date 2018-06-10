package core;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Firefox {

	private static WebDriver driver;
	private static String url = "http://alex.academy/ua";
	private static String driverPath = "./resources/windows/geckodriver.exe";

	public static void main(String[] args) {

		Logger logger = Logger.getLogger("");
		logger.setLevel(Level.OFF);

		String os = System.getProperty("os.name");

		if (os.contains("Windows")) {
			System.out.println("The OS is " + os);
		} else {
			throw new IllegalArgumentException("The OS is " + os + ", but requered Windows");
		}

		System.setProperty("webdriver.gecko.driver", driverPath);

		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		driver.get(url);

		String ua = driver.findElement(By.id("id_ua")).getText();

		System.out.println("Element text: " + ua);

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		driver.quit();
	}
}
