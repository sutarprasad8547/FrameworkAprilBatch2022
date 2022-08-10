package base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;

	public void init() throws IOException {
	//	System.setProperty("webdriver.chrome.driver", "D:\\2. Java Automation App\\chromedriver_win32\\chromedriver.exe");
		//driver = new ChromeDriver(); //Local variable
		
		prop = new Properties();
		try {
		FileInputStream file = new FileInputStream("C:\\Users\\sutar\\eclipse-workspace\\AutomationFrameworkBatchApril2022\\src\\main\\java\\config\\configuration.properties");
		prop.load(file);
		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println("Configuration file is missing");
		}
		
		String browser = prop.getProperty("browser");
		if(browser.contains("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if(browser.contains("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		else if(browser.contains("Edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
						
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
	}
}
