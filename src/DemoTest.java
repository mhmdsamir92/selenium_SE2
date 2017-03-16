import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class DemoTest {

	
	WebDriver driver;
	
	@BeforeTest
	public void beforeTest(){
		//System.setProperty("webdriver.chrome.driver", "C:\\Study\\work\\Bedo pedia\\chromedriver.exe");
		//System.setProperty("webdriver.gecko.driver", "C:\\Study\\work\\Bedo pedia\\geckodriver-v0.8.0-win32\\geckodriver.exe");
		//driver = new ChromeDriver();
		System.setProperty("webdriver.chrome.driver", "D:\\work\\Bedo pedia\\chromedriver.exe");
		
		driver = new ChromeDriver();
		//driver = new MarionetteDriver();
		driver.manage().window().maximize();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testDemo() throws InterruptedException{
		String annTitle = "TestAnn";
		driver.get("http://localhost/remarkpartners/frontend/web/index.php?r=site%2Flogin");
		driver.findElement(By.cssSelector("body > div.login-container.login-v2 > div > div > form > div:nth-child(1) > div > div > input")).sendKeys("samir");
		driver.findElement(By.cssSelector("body > div.login-container.login-v2 > div > div > form > div:nth-child(2) > div > div > input")).sendKeys("asdasd");
		driver.findElement(By.cssSelector("body > div.login-container.login-v2 > div > div > form > div:nth-child(4) > div > button")).click();
		driver.findElement(By.cssSelector("body > div.page-container > div.page-sidebar > ul > li:nth-child(15)")).click();
		driver.findElement(By.cssSelector("body > div.page-container > div.page-content > div.row > div > div > div.panel-heading > ul > li:nth-child(1)")).click();
		driver.findElement(By.cssSelector("#jvalidate > div.panel-body > div:nth-child(1) > div > div > input")).sendKeys(annTitle);
		driver.findElement(By.cssSelector("#jvalidate > div.panel-body > div:nth-child(2) > div > div > div.note-editable")).sendKeys("TestDesc");
		driver.findElement(By.cssSelector("#jvalidate > div.panel-footer > input")).click();
		Thread.sleep(5000);
		driver.findElement(By.cssSelector("body > div.page-container > div.page-sidebar > ul > li:nth-child(3)")).click();
		String text = driver.findElement(By.cssSelector("body > div.page-container > div.page-content > div > div > div > div:nth-child(2) > div.timeline-item-content > div.timeline-heading.text-center")).getText();
		Assert.assertEquals(text, annTitle);
	}
}
