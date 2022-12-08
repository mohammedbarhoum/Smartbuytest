import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestCar {public WebDriver driver;
public int numberofTry = 5;
public SoftAssert SoftAssertPrice = new SoftAssert();

@BeforeTest

public void Test_Before() {

	WebDriverManager.chromedriver().setup();

	driver = new ChromeDriver();
	driver.get("https://jo.opensooq.com/en/cars");
	driver.manage().window().maximize();
}
@Test
public void Test() {
	
	
	
	
}





}
