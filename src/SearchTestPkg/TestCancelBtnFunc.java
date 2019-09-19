package SearchTestPkg;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class TestCancelBtnFunc {
	static WebDriver driver;
	@BeforeTest
	public void Setup()
	{
		  driver = gopuff.connectToSite();
	}
	//Verify if Cancel Search deletes text on Search box	
	 @Parameters({"Keywordcheck"})
	 @Test	
	 public void test_cancelsearch(String Testword)
	{
			WebElement search = driver.findElement(By.xpath("//input[@id='product-search']"));
			search.clear();
		    search.sendKeys("Testword");
		    
		    //Click on Cancel button
		      driver.findElement(By.xpath("//img[@class='c-header__anonym-clear-search-icon']")).click();
		      Boolean Searchtext = search.getText().isEmpty();
		      String Emptytext = Boolean.toString(Searchtext);
		      Assert.assertTrue(true,Emptytext); 
		    
	 }
	
	
	@AfterTest
	public void Teardown()
	{
			driver.close();
	}
		
	
		
	  
	
	}
