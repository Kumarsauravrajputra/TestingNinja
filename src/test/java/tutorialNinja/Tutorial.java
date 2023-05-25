package tutorialNinja;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Tutorial {
	
	WebDriver driver;
	@BeforeMethod
	public void start() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://tutorialsninja.com/demo/");
		driver.manage().window().maximize();
		Thread.sleep(2000);
	}
	@Test(priority = 1)
	public void register() {
		
		WebElement acc=  driver.findElement(By.xpath("//i[@class='fa fa-user']"));
		Actions act=new Actions(driver);
		act.moveToElement(acc).click().perform();
		WebElement reg=driver.findElement(By.xpath("//a[normalize-space()='Register']"));
		act.moveToElement(reg).click().perform();
		driver.findElement(By.id("input-firstname")).sendKeys("Kumar");
		driver.findElement(By.id("input-lastname")).sendKeys("Saurav");
		driver.findElement(By.id("input-email")).sendKeys("something@gmail.com");
		driver.findElement(By.id("input-telephone")).sendKeys("9876543219");
		driver.findElement(By.id("input-password")).sendKeys("Tutorial123");
		driver.findElement(By.id("input-confirm")).sendKeys("Tutorial123");
		List<WebElement>radio=driver.findElements(By.xpath("//input[@type='radio'and contains(@name,'newsletter')]"));
		for(WebElement button:radio) {
			button.click();
			break;
		}
		driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/div/input[1]")).click();
		driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/div/input[2]")).click();
	}
	@Test(priority = 2)
	public void login() throws InterruptedException {
		
		WebElement log=driver.findElement(By.xpath("//i[@class='fa fa-user']"));
		Actions lo=new Actions(driver);
		lo.moveToElement(log).click().perform();
		Thread.sleep(2000);
		WebElement el=driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/ul/li[2]/a"));
		lo.moveToElement(el).click().perform();
		driver.findElement(By.id("input-email")).sendKeys("something@gmail.com");
		driver.findElement(By.id("input-password")).sendKeys("Tutorial123");
		driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/form/input")).click();
		
	}
	
	@Test(priority = 3)
	public void addtcart() throws InterruptedException {
		WebElement log=driver.findElement(By.xpath("//i[@class='fa fa-user']"));
		Actions lo=new Actions(driver);
		lo.moveToElement(log).click().perform();
		Thread.sleep(2000);
		WebElement el=driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/ul/li[2]/a"));
		lo.moveToElement(el).click().perform();
		driver.findElement(By.id("input-email")).sendKeys("something@gmail.com");
		driver.findElement(By.id("input-password")).sendKeys("Tutorial123");
		driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/form/input")).click();
		
		driver.findElement(By.xpath("//input[@type='text' and contains(@name,'search')]")).sendKeys("iMac");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@type='button'and contains (@class,'btn btn-default btn-lg')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"content\"]/div[3]/div/div/div[2]/div[2]/button[1]/i")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("cart-total")).click();
		driver.findElement(By.xpath("//*[@id=\"cart\"]/ul/li[2]/div/p/a[2]/strong")).click();
		
	}
	@Test(priority = 4)
	public void checkout() throws InterruptedException {
		WebElement log=driver.findElement(By.xpath("//i[@class='fa fa-user']"));
		Actions lo=new Actions(driver);
		lo.moveToElement(log).click().perform();
		Thread.sleep(2000);
		WebElement el=driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/ul/li[2]/a"));
		lo.moveToElement(el).click().perform();
		driver.findElement(By.id("input-email")).sendKeys("something@gmail.com");
		driver.findElement(By.id("input-password")).sendKeys("Tutorial123");
		driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/form/input")).click();
		driver.findElement(By.id("cart-total")).click();
		driver.findElement(By.xpath("//*[@id=\"cart\"]/ul/li[2]/div/p/a[2]/strong")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//input[@type='radio'and contains(@name,'payment_address')])[2]")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("input-payment-firstname")).sendKeys("Kumar");
		driver.findElement(By.id("input-payment-lastname")).sendKeys("Saurav");
		driver.findElement(By.id("input-payment-address-1")).sendKeys("Delhi");
		driver.findElement(By.id("input-payment-city")).sendKeys("New Delhi");
		Thread.sleep(2000);
		WebElement ele=driver.findElement(By.id("input-payment-country"));
		Select drop=new Select(ele);
		drop.selectByValue("99");
		Thread.sleep(2000);
		WebElement el2=driver.findElement(By.id("input-payment-zone"));
		Select dro=new Select(el2);
		dro.selectByValue("1483");
		Thread.sleep(2000);
		driver.findElement(By.id("button-payment-address")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"collapse-shipping-address\"]/div/form/div[1]/label/input")).click();
		driver.findElement(By.id("button-shipping-address")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("button-shipping-method")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@type='checkbox'and contains(@name,'agree')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("button-payment-method")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("button-confirm")).click();
		}
	
	
	
	@AfterMethod
    public void teardown() throws InterruptedException {
    	Thread.sleep(5000);
    	driver.close();
    }
}
