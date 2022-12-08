import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestSortSwaglab {

	public WebDriver driver;

	@BeforeTest
	public void Sort() throws InterruptedException {
		WebDriverManager.edgedriver().setup();

		driver = new EdgeDriver();

		driver.get("https://www.saucedemo.com/");

		driver.findElement(By.xpath("//*[@id=\"user-name\"]")).sendKeys("standard_user");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("secret_sauce");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@id=\"login-button\"]")).click();
		Thread.sleep(5000);

	}

	@Test()

	public void TestSetp1() throws InterruptedException {

		
		driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/div[2]/span/select")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/div[2]/span/select/option[3]")).click();
		Thread.sleep(3000);

		List<WebElement> MyOptins = driver.findElements(By.className("inventory_item_price"));

		List<Double> newlist = new ArrayList<>();

		for (int i = 0; i < MyOptins.size(); i++) {

			//System.out.println(MyOptins.get(i).getText());
			String price = MyOptins.get(i).getText();

			//price.trim();
			String Edite = price.replace("$","");
			// String[] a = price.split("$");

			double val = Double.parseDouble(Edite.trim());

			// System.out.println(price);

			newlist.add(val);

		}
		 System.out.println(newlist.size());
		 System.out.println(newlist);

		for (int k = 0; k < newlist.size(); k++) {

			Boolean chechProcess = newlist.get(0) < newlist.get(newlist.size() -1);

			Assert.assertEquals(chechProcess,true);
			
			
			

		}

	}
}
