package resources;

import java.io.File;
import java.io.FileInputStream;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class base {

	public WebDriver driver;
	public Properties prop;

	public WebDriver initializeDriver() throws IOException {

		prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\data.properties");
		prop.load(fis);

		//String browserName=System.getProperty("browser");
		String browserName = prop.getProperty("browser");

		if (browserName.contains("chrome")) {
			System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\jars\\chromedriver.exe");
			// Initiate Chrome
			ChromeOptions options=new ChromeOptions();
			if(browserName.contains("headless"))
			options.addArguments("headless");
			driver = new ChromeDriver(options);

		} else if (browserName.equals("firefox")) {

			System.setProperty("webdriver.gecko.driver", "D:\\Selenium\\jars\\drivers\\geckodriver.exe");
			// Initiate Firefox
			driver = new FirefoxDriver();
		}

		else if (browserName.equals("IE")) {

			System.setProperty("webdriver.ie.driver", "D:\\Selenium\\jars\\drivers\\IEDriverServer.exe");

			// Initiate IE
			driver = new InternetExplorerDriver();

		}

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		return driver;
	}
	
	
	public String getScreenshot(String testName,WebDriver driver) {
		TakesScreenshot ts=(TakesScreenshot) driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		String destinationFile=System.getProperty("user.dir")+"\\reports\\"+testName+".png";
		
			try {
				FileUtils.copyFile(src,new File(destinationFile));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return destinationFile;
		
	}

}
