package SearchTestPkg;


import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestSearchlist {
	static WebDriver driver;
	@BeforeTest
	public void Setup()
	{
		  driver = gopuff.connectToSite();
	} 
//1.Verify keyword search by entering First, middle or last word of any itemText and verify that it is found in search results
	 @Parameters({"Searchword"})
	 @Test
	 public void test_searchlist(String SearchKeyword)
	 {
		 driver.findElement(By.xpath("//input[@id='product-search']")).clear();
	     driver.findElement(By.xpath("//input[@id='product-search']")).sendKeys(SearchKeyword);
	     try
	     {
			Thread.sleep(3000);
	     }
		  
	     catch (InterruptedException e)
	     {
			e.printStackTrace();
	     }
	     List<WebElement> elements = driver.findElements(By.xpath("//div[@class='itemText']"));
	     
       //Go to each Item in Search list and check it contains search keyword.
	     for (int i=0; i<elements.size();i++){
	    	
	      
	    	 String label = elements.get(i).getText().toLowerCase();
	    	 Boolean labelresult = label.contains(SearchKeyword);
	         if(labelresult == true) 
	    	 {
	    	      System.out.println(" Text is in Element :"+elements.get(i).getText());
	    	 }
	    	else
	    	{
	    		//We can write these wrong Product list in Separate CSV file too depending on the business requirement.
	    		System.out.println("Wrong Product under Search Category :"+elements.get(i).getText());
	    	
	    	}
	       
	     }
		 
	 }
//2.Verify number of products related to search keyword
	 @Parameters({"Searchword"})
	 @Test
	 public void test_searchkeywordCount(String Testdata)
	 {
		 driver.findElement(By.xpath("//input[@id='product-search']")).clear();
	     driver.findElement(By.xpath("//input[@id='product-search']")).sendKeys(Testdata);
	     try
	     {
			Thread.sleep(3000);
	     }
		  
	     catch (InterruptedException e)
	     {
			e.printStackTrace();
	     }
	     List<WebElement> elements = driver.findElements(By.xpath("//div[@class='itemText']"));
	     System.out.println("Search Product " +elements.size() + "are available");
		 
	 }
	 //Verify if you add new item in the database it display under search keyword.
	 //Adding a new item to the system should automatically make it search able.
	 
	 
	 //Verify if you Delete item in the database it doesn't display under search keyword.
	 //Adding a new item to the system should automatically make it search able
	 
	 
	 @AfterTest
	 public void Teardown()
	 {
	 		driver.close();
	 }
	 	
}
