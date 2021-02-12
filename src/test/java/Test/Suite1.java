package Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Suite1 {
	
	@Test
	public void register() {
		WebDriverManager.chromedriver().setup();
		
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.get("http://magento.com");
		driver.findElement(By.xpath("//*[@id=\"block-header\"]/ul/li[9]/a/span[1]/div")).click();
		driver.findElement(By.id("register")).click();
		driver.findElement(By.id("firstname")).sendKeys("Swarupa");
		driver.findElement(By.id("lastname")).sendKeys("Bhavsar");
		driver.findElement(By.id("email_address")).sendKeys("bhavsar.swarupa@gmail.com");
		
		
		Select cp = new Select(driver.findElement(By.id("company_type")));
		cp.selectByIndex(3);
		//cp.selectByValue("development");
	//	cp.deselectByVisibleText("Provides deployment,customization and integration service to merchants");
		
		
		
		driver.findElement(By.id("password")).sendKeys("welcome@1234");
		driver.findElement(By.id("password-confirmation")).sendKeys("welcome@1234");
		
	//	driver.switchTo().frame(driver.findElement(By.xpath("//*[@id=\"msp-recaptcha-d84b65fc916e7398083ea5f17089d8f1\"]/div/div/iframe")));
	//	driver.findElement(By.className("recaptcha-checkbox-border")).click();
	//	driver.switchTo().defaultContent();
		
		
		
		
		if(!driver.findElement(By.id("agree_terms")).isSelected())
		{
			driver.findElement(By.id("agree_terms")).click();
		}
		driver.quit();

		
	}


        @Test
        public void login() throws InterruptedException {
        	WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.get("http://magento.com");
		
		driver.findElement(By.xpath("//*[@id=\"block-header\"]/ul/li[9]/a/span[1]/div")).click();
		
		driver.findElement(By.id("email")).sendKeys("bhavsar.swarupa@gmail.com");
		
		driver.findElement(By.id("pass")).sendKeys("welcome123");
		driver.findElement(By.id("send2")).click();
		
		Thread.sleep(5000);
		
		System.out.println(driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[1]/div[2]/div/div/div")).getText());
		driver.quit();
		

	}
}