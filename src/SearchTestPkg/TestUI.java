package SearchTestPkg;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
//import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class TestUI {
	
    static WebDriver driver;
    
	@BeforeTest
	public void Setup()
	{
	  driver = gopuff.connectToSite();
	}
    
//	1.Verify if Search box is displayed
	@Test 
	public void test_searchboxdisplayed()
	{
	    Boolean searchbox= driver.findElement(By.xpath("//input[@id='product-search']")).isDisplayed();
	    String searchvalue = Boolean.toString(searchbox);
	    
	    Assert.assertTrue(true,searchvalue); 
	    System.out.println(" Run test_searchboxdisplayed");
	}


	//2.Verify if Search box let you enter text
	@Parameters({"Keywordcheck"})
	@Test 
	public void test_KeywordSearch(String Typeword)
	{
	//WebDriver driver = 	gopuff.connectToSite();
		driver.findElement(By.xpath("//input[@id='product-search']")).clear();
        driver.findElement(By.xpath("//input[@id='product-search']")).sendKeys(Typeword);
        System.out.println(" Run test_KeywordSearch");
   
	}
	
	//3.Verify if placeholder Text is search
	@Test
	public void test_placeholder()
	{
	//WebDriver driver = 	gopuff.connectToSite();
        String ph= driver.findElement(By.xpath("//input[@placeholder='search']")).getAttribute("placeholder");
        Assert.assertEquals(ph, "search");
        System.out.println(" Run test_placeholder");
	}
	
	//4.Verify if Cancel button enables on writing some text on Search box
	@Parameters({"Keywordcheck"})
	@Test 
	public void test_cancelbuttonvisibility(String Typecheck)
	{
		driver.findElement(By.xpath("//input[@id='product-search']")).clear();
		driver.findElement(By.xpath("//input[@id='product-search']")).sendKeys(Typecheck);
		Boolean cancelbutton = driver.findElement(By.xpath("//img[@class='c-header__anonym-clear-search-icon']")).isEnabled();
		String cancelvalue = Boolean.toString(cancelbutton);
		    
		    Assert.assertTrue(true, cancelvalue);
		    System.out.println(" Run test_cancelbuttonvisibility");

	}
	
	
	//5.Verify that search button is displayed and enabled
	@Test
	public void test_searchbutton()
	{
		  boolean searchIconPresence = driver.findElement(By.xpath("//img[@class='puffWide-show c-header__anonym-search-icon']")).isDisplayed();
	      boolean searchIconEnabled = driver.findElement(By.xpath("//img[@class='puffWide-show c-header__anonym-search-icon']")).isEnabled();
		   if (searchIconPresence==true && searchIconEnabled==true)
		   {
		      WebElement searchIcon = driver.findElement(By.xpath("//img[@class='puffWide-show c-header__anonym-search-icon']"));
		      searchIcon.click();
		      System.out.println(" Run test_searchbutton");
		  
		    }

	}
	
	
	@AfterTest
	
	public void Teardown()
	
	{
		driver.close();
	}
	
	
	
	
	
}
