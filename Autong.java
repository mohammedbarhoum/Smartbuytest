import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Autong {
 
	public WebDriver driver;
	
	
	
	@BeforeTest
	
	public void Login() {
		
		WebDriverManager.edgedriver().setup();
	
		driver= new EdgeDriver();
		
		
		
		
		
		driver.get("https://github.com/login");
		
		driver.findElement(By.xpath("//*[@id=\"login_field\"]")).sendKeys("mohammedbarhoum777@gmial.com");
		driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("mohammed12345$");
		driver.findElement(By.xpath("//*[@id=\"login\"]/div[4]/form/div/input[11]")).click();
		
	}
	@Test()
	
	public void Test_Title()
	{
		String ActualTitleName =driver.getTitle();
		 String ExpectedTittle="Gethub";
		
		Assert.assertEquals("ActualTitleName", "ExpectedTittle");
		
	}
	
	}

	
	
	
	
	

