package Project_FirstCry.Project_FirstCry;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeoutException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Login {
	
	String driverPath = "C:\\Users\\Rohit Pingale\\OneDrive\\Documents\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe";
	
	WebDriver driver= new ChromeDriver();
	
	
	
	@BeforeTest
	void Navigate()
	{  
		driver.get("https://firstcrystore.in/#/");
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
		
	}

	
	
	@Test (priority=1)
	void Username() throws InterruptedException
	{
		WebElement Acc= driver.findElement(By.xpath("//span[normalize-space()='Account']"));
		Acc.click();
		
		WebElement Email= driver.findElement(By.xpath("//input[@name=\"email\"]"));
		Email.sendKeys("xyz456@gmail.com");
		
		WebElement Password= driver.findElement(By.xpath("//input[@name=\"password\"]"));
		Password.sendKeys("Xyz@456");
		
		WebElement SignUp= driver.findElement(By.xpath("//button[@type=\"submit\"]"));
		SignUp.click();	
		
		Thread.sleep(2000);
	}
	
	@Test (priority=2)
	void AlertClk()
	{
		WebDriverWait wait4 = new WebDriverWait(driver, Duration.ofSeconds(10));
 	   
 	   wait4.until(ExpectedConditions.alertIsPresent());
		
		Alert a = driver.switchTo().alert(); 
		
		System.out.println(a.getText());
		
		a.accept();
	}
	
	@Test(priority=3)
	void Accessories() throws InterruptedException
	{
		WebElement Acc= driver.findElement(By.xpath("//div[@class=\"top-cotegories hover-product-list y-gap\"]"));
		Acc.click();
		
		WebElement BabyCradleAutomaticSwing=driver.findElement(By.xpath("//li[normalize-space()='Baby Cradle Automatic Swing']"));
		BabyCradleAutomaticSwing.click();	
		
		Thread.sleep(2000);
	}
	
	@Test (priority=4)
	void AgeSelection()
	{
		WebElement AgeSele= driver.findElement(By.xpath("(//li[normalize-space()='2-3 years'])[1]"));
		AgeSele.click();
		
	}
	
	@Test (priority=5)
	void AddtoCart()
	{
		WebElement AddtoCartSele= driver.findElement(By.xpath("(//button[contains(@class,'cart-btn')])[1]"));
		AddtoCartSele.click();
	}
	
	@Test (priority=6)
	void AddObject() throws InterruptedException
	{
		WebElement AddObjects=driver.findElement(By.xpath("//button[@class='btn btn-primary btn-plus']"));
		AddObjects.click();
		
		Thread.sleep(3000);
		
		WebElement FinalAddToCart= driver.findElement(By.xpath("//a[@href='#/productcart']"));
		FinalAddToCart.click();
		
		Thread.sleep(6000);
	}
	
	@Test (priority=7)
	void ScreenShotATC() throws IOException, InterruptedException
	{
		TakesScreenshot ts= (TakesScreenshot) driver;
		
		File src= ts.getScreenshotAs(OutputType.FILE);
		
		File dest = new File("C:\\Users\\Rohit Pingale\\eclipse-workspace\\Project_FirstCry\\ScreenShot\\AddToCartSS.png");
		
		FileUtils.copyFile(src,dest);
		
		Thread.sleep(3000);
		
	}
	
	@Test (priority=8)
	void Proceed() throws InterruptedException
	{
		
		WebElement Proceedto= driver.findElement(By.xpath("//a[normalize-space()='Proceed To Checkout']"));
		Proceedto.click();
		
		Thread.sleep(6000);
	}
	
	@Test (priority=9)
	void BillingAddressDetails() throws InterruptedException
	{
		WebElement FirstName= driver.findElement(By.xpath("//input[@name=\"firstName\"]"));
		FirstName.sendKeys("Shradha");
		
		WebElement LastName= driver.findElement(By.xpath("(//input[@type=\"text\"])[3]"));
		LastName.sendKeys("Bhujbal");
		
		WebElement AddressLine= driver.findElement(By.xpath("(//input[@type=\"text\"])[4]"));
		AddressLine.sendKeys("F.C Road");
		
		WebElement AddressLine2= driver.findElement(By.xpath("//input[@name='addressLine2']"));
		AddressLine2.sendKeys("Pune");
		
		WebElement City= driver.findElement(By.xpath("(//input[@type=\"text\"])[6]"));
		City.sendKeys("Pune");
		
		WebElement State= driver.findElement(By.xpath("(//input[@type=\"text\"])[7]"));
		State.sendKeys("Maharashtra");
		
		WebElement Email= driver.findElement(By.xpath("//input[@placeholder='example@email.com']"));
		Email.sendKeys("abc123@gmail.com");
		
		WebElement Mobileno= driver.findElement(By.xpath("//input[@placeholder='+123 456 789']"));
		Mobileno.sendKeys("1234567890");
		
		WebElement ZipCode= driver.findElement(By.xpath("(//input[@type=\"Number\"])[2]"));
		ZipCode.sendKeys("411015");
		
		Thread.sleep(3000);
		
	}
	
	@Test (priority=10)
	void MainSubmit() throws InterruptedException
	{
		
		
//		WebElement SubmitAddressDetails= driver.findElement(By.xpath("//button[@class=\"edit-submit-btn\"]"));
//		 SubmitAddressDetails.click();
		 
		 JavascriptExecutor js = (JavascriptExecutor) driver;

	        // Scroll down by a specific pixel amount
	        js.executeScript("window.scrollBy(0, 500);");
	        
	        Thread.sleep(2000);
			
	        WebElement SubmitAddressDetails=driver.findElement(By.xpath("//button[@class=\"edit-submit-btn\"]"));
	        SubmitAddressDetails.click();
		
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//
//	    try {
//	        
//	        WebElement SubmitAddressDetails1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='Submit Address Details']")));
//	        
//	    
//	        SubmitAddressDetails1.click();
//	    } catch (ElementClickInterceptedException e) {
//	        System.out.println("The Submit address details button was not clickable within the specified time.");
//	    }
		
		
		
	}
	
	    @Test (priority= 11)
	 	void COD() throws InterruptedException  {
	    	
	    	
	    	
	    	//WebElement CashonDelivery=driver.findElement(By.xpath("//input[@name=\"payment\"]"));
	    	//CashonDelivery.click();
	    	
	    	WebElement CashonDelivery=driver.findElement(By.xpath("//input[@id='directcheck']"));
	    	CashonDelivery.click();
			
			Thread.sleep(2000);
	    
	    
	    //try {
	    	
//	    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//	    
//	    
//	    WebElement CashonDelivery= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[@for=\"directcheck\"]")));
//	    
//	    wait.until(ExpectedConditions.elementToBeClickable(CashonDelivery));
//	    
//	    CashonDelivery.click();
//	    }
//		
//	if(CashonDelivery.isDisplayed() && CashonDelivery.isEnabled())
//		{
//			CashonDelivery.click();
//		}else
//		{
//			System.out.println("COD Button is not clickable.");
//		}}
//	    
//	    catch (Exception e1) 
//		
//		{
//	        System.out.println("Exception: "+ e1.getMessage());
//	    }
		
		
}
	 	
	    @Test (priority=12)
	 	void Place_Order() throws TimeoutException, InterruptedException {
	    	
	    	try {
	    	
//	    WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
//	    
//	    WebElement PlaceOrder = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='Place Order']")));
//	    
//        PlaceOrder.click();
//		
//	    	}catch (Exception e2) {
//	            System.out.println("Exception: " + e2.getMessage());
//	            
//	        }
//		
		Thread.sleep(2000);
		
		WebElement PlaceOrder =driver.findElement(By.xpath("//button[normalize-space()='Place Order']"));
		PlaceOrder.click();
		
		Thread.sleep(2000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		try {
			//Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		    driver.switchTo().alert().accept();	
		    //System.out.println(alert.getText()); // Get alert text if needed
		  
		} catch (Exception e) {
		    System.out.println("No alert appeared.");
		}} finally {
            // This block will always be executed, regardless of whether an exception occurred or not.
            // Perform any cleanup or final steps here
            System.out.println("This will always be executed, even if an exception occurs.");
            
		
		Thread.sleep(2000);
	}
	    }
           @Test (priority=13)
	    	void ProducthasbeenPlaced() throws TimeoutException
	    
	    	{
        	   
        	  // WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(10));
        	   
        	   //wait2.until(ExpectedConditions.alertIsPresent());
        	   
	    		Alert alert1 = driver.switchTo().alert(); 
	    		
	    		System.out.println(alert1.getText()); 
	    		
	    		alert1.accept();
	    		
	    	}
       	 
           
        @AfterTest
       	void closetab()
      	{
      		driver.close();
      	}
}
