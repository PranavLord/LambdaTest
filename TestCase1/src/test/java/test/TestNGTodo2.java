package test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNGTodo2 {

    private RemoteWebDriver driver;
    private String Status = "failed";
    
    @BeforeMethod

    public void setup(Method m, ITestContext ctx) throws MalformedURLException {
        String username = System.getenv("LT_USERNAME") == null ? "jhapranav21" : System.getenv("LT_USERNAME");
        String authkey = System.getenv("LT_ACCESS_KEY") == null ? "jOBCjVTQEbonnXgLkNPdVbSSxArKePbh5tkleJAZ3kzDMFB4Hn" : System.getenv("LT_ACCESS_KEY");
        String hub = "@hub.lambdatest.com/wd/hub";

        DesiredCapabilities caps = new DesiredCapabilities();
        // Configure your capabilities here
        caps.setCapability("platform", "Windows 10");
        caps.setCapability("browserName", "Chrome");
        caps.setCapability("version", "98.0");
        caps.setCapability("resolution", "1366x768");
        caps.setCapability("build", "TestNG With Java");
        caps.setCapability("name", "TestNG With Java");
        caps.setCapability("visual", true);
        caps.setCapability("video", true);
        caps.setCapability("console", true);
        caps.setCapability("plugin", "git-testng");

        String[] Tags = new String[] { "Feature", "Magicleap", "Severe" };
        caps.setCapability("tags", Tags);

        driver = new RemoteWebDriver(new URL("https://" + username + ":" + authkey + hub), caps);
    }

		
		@Test(enabled = true)
			public void basictest() throws InterruptedException
			{
			
			try{
				
			
				
				// initializing webDriver
				//System.setProperty("webdriver.chrome.driver", "C:\\Java_Workspace\\Pranav\\Drivers\\chromedriver.exe");
				//WebDriver driver = new ChromeDriver();
				
				
				
				//launching required URL
				driver.get("https://www.lambdatest.com/selenium-playground");
				
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				
				driver.findElement(By.xpath("//span[contains(text(),'Got it')]")).click();
				Thread.sleep(2000);
				
				driver.findElement(By.xpath("//a[contains(text(),'Simple Form Demo')]")).click();
				
				
				Thread.sleep(2000);
				
				//checking for the specific string (here simple-form-demo) present in url or not 
				String url = driver.getCurrentUrl();
				
				
				if(url.contains("simple-form-demo"))
				{
					System.out.println("simple-form-demo is present in the url "+ url);
				}
				
				String test = "Welcome to LambdaTest";
				
				Thread.sleep(2000);
				
				driver.findElement(By.cssSelector("#user-message")).sendKeys(test);
				
				Thread.sleep(2000);
				
				driver.findElement(By.id("showInput")).click();
				
				Thread.sleep(2000);
				String test1= driver.findElement(By.xpath("//p[@id='message']")).getText();
				
				
				
				if (test.equals(test1))
				{
					System.out.println("Same Text is displayed");
				}
			}catch (Exception e)
			{
				System.out.println(e.getMessage());
			}
			}
		
			
	
		@AfterMethod
	    public void tearDown() {
	       
	        driver.quit();
		
		}
		
}
		
		

		  
		





	
	




