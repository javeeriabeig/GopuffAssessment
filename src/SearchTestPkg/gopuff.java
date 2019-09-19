package SearchTestPkg;
import java.util.concurrent.TimeUnit;			
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
	
	
	
	
	
public class gopuff {
	
	public static void main(String[] args) throws InterruptedException {
		//TestUI Ts = new TestUI();
		//Ts.test_searchboxdisplayed();
		//Ts.test_KeywordSearch();
	   
	}
	
	public static WebDriver connectToSite() {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Javeeria Ali Beig\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		//1. Home
		driver.get("https://www.gopuff.com/");
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	    driver.manage().window().maximize();
	    
	    driver.findElement(By.xpath("//input[@placeholder='Enter your address']")).click();
	    try
	    {
			Thread.sleep(1000);
		} 
	    catch (InterruptedException e1)
	    {
			e1.printStackTrace();
		}
	   
	    WebElement address =driver.findElement(By.xpath("//input[@id='mapSearch']"));
	    address.clear();
	    address.sendKeys("1142 Tremont Street, Allentown, PA, USA");
	   
	    
	
	 
	     try 
	     {
			Thread.sleep(2000);
		} 
	     catch (InterruptedException e) 
	     {
			// TODO Auto-generated catch block
			e.printStackTrace();
		 }
	     address.sendKeys(Keys.ARROW_DOWN);
	     address.sendKeys(Keys.ENTER);
	     try 
	     {
			Thread.sleep(2000);
		} 
	     catch (InterruptedException e) 
	     {
			// TODO Auto-generated catch block
			e.printStackTrace();
		 }
	     
	     //Click the Confirm Address button
	     driver.findElement(By.xpath("//button[@id='mapAddAdddress']")).click();
	     
	   return  driver;
		
	}
	
	
	
	}
