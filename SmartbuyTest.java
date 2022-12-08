import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SmartbuyTest {

	public WebDriver driver;
	public int numberofTry = 5;
	public SoftAssert SoftAssertPrice = new SoftAssert();

	@BeforeTest

	public void Test_Before() {

		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();
		driver.get("https://smartbuy-me.com/smartbuystore/");
		driver.findElement(By.xpath("/html/body/main/header/div[2]/div/div[2]/a")).click();
		driver.manage().window().maximize();
	}

	@Test
	public void Chech_To_Cart() {

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		for (int i = 0; i < numberofTry; i++) {

			driver.findElement(By.xpath(
					"//*[@id=\"newtab-Featured\"]/div/div[1]/div/div/div/div[2]/div/div[3]/div[1]/div/div/form[1]/div[1]/button"))
					.click();

			String msg = driver.findElement(By.xpath("//*[@id=\"addToCartLayer\"]/div[1]")).getText();

			if (msg.contains("Sorry")) {

				driver.findElement(By.xpath("//*[@id=\"addToCartLayer\"]/a[1]")).click();

			} else {
				driver.findElement(By.xpath("//*[@id=\"addToCartLayer\"]/a[2]")).click();

			}

		}
	}

	@Test
	public void Add_Item() {

		driver.navigate().back();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		for (int i = 0; i < numberofTry; i++) {
			driver.findElement(By.xpath(
					"//*[@id=\"newtab-Featured\"]/div/div[1]/div/div/div/div[3]/div/div[3]/div[1]/div/div/form[1]/div[1]/button"))
					.click();
			driver.findElement(By.xpath("//*[@id=\"addToCartLayer\"]/a[2]")).click();
		}
	}

	@Test

	public void Correct_Item() {

		String single_item = driver.findElement(By.xpath(
				"//*[@id=\"newtab-Featured\"]/div/div[1]/div/div/div/div[3]/div/div[3]/div[1]/div/div/form[1]/div[1]/button"))
				.getText();
		String[] TheUpdeteItem = single_item.split("Jod");

		String Finalprice = TheUpdeteItem[0].trim();
		String Update = Finalprice.replace(",", ".");

		Double Final = Double.parseDouble(Update);
		System.out.println(Final);

		System.out.println(Final * numberofTry);

		String ActualWebsite = driver.getTitle();

		SoftAssertPrice.assertEquals(ActualWebsite, "Ahmad");

		SoftAssertPrice.assertAll();
	}

	@Test
	public void Check_Discount() {

		String beforeDiscount = driver.findElement(By.xpath(
				"//*[@id=\"newtab-Featured\"]/div/div[1]/div/div/div/div[3]/div/div[3]/div[1]/div/div/form[1]/div[1]/button"))
				.getText();
		String[] Test = beforeDiscount.split("JOD");
		System.out.println(Test);

	}
	@Test
	public void TestTittle(){
		
		
		String ActualTittle=driver.getTitle();
		SoftAssertPrice.assertEquals(ActualTittle,Testparametar.expectedTittle);
		
		SoftAssertPrice.assertAll();
	}
}
