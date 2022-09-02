package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class HospitalDetails {

	
	
	
	 static void dataCollectionFromWeb() throws InterruptedException
	{
		WebDriver driver = new ChromeDriver();
		driver.get("http://office.suratsmartcity.com/SuratCOVID19/Home/COVID19BedAvailabilitydetails");
		
		/*Get the current Zone */
		String zoneName = driver.findElement(By.xpath("//select[@id='ddlZone']/option")).getText();
		System.out.println(zoneName);
		
		int numberOfHospitals= driver.findElements(By.xpath("//div[@class='card custom-card']")).size();
		System.out.println("numberOfHospitals"+" "+numberOfHospitals);
		
		for(int i =1;i<=numberOfHospitals;i++)
		{
			System.out.println("\n"+i+")");
			String hospitalName = driver.findElement(By.xpath("//div[@class='card custom-card']["+i+"]//a")).getText().replace("Contact", " ");
			System.out.println(hospitalName);
			String totalBeds = driver.findElement(By.xpath("//div[@class='card custom-card']["+i+"]//span[contains(text(),'Total Beds')]")).getText();
			System.out.println(totalBeds);
			
			WebElement VacantBeds = driver.findElement(By.xpath("//div[@class='card custom-card']["+i+"]//span[contains(text(),'Total Vacant')]"));
			System.out.println(VacantBeds.getText());
			
			
			driver.findElement(By.xpath("//div[@class='card custom-card']["+i+"]//div[@class='card-header']")).click();
			Thread.sleep(500);
			
			//WebElement o2BedsAvailability = driver.findElement(By.xpath("//div[@class='card custom-card'][1]//div[contains(text(),'HDU')]/../div[2]")); //--> Not working somehow
			WebElement o2BedsAvailability = driver.findElement(By.xpath("//div[@class='card custom-card']["+i+"]//div[contains(text(),'HDU(O2)')]/../div[@class='count-text']"));
			System.out.println("O2BedsAvailability :"+" "+o2BedsAvailability.getText());
			

			WebElement ventilatorAvailability = driver.findElement(By.xpath("//div[@class='card custom-card']["+i+"]//div[contains(text(),'Ventilator')]/../div[2]"));
			System.out.println("ventilatorAvailability :"+" "+ventilatorAvailability.getText());
			
			if(i!=81 && i!=89)
			{
				driver.findElement(By.xpath("//div[@class='card custom-card']["+i+"]//a/span")).click();
				Thread.sleep(1000);
				
				WebElement Address = driver.findElement(By.id("lblhosaddress"));
				System.out.println("Address : "+" "+Address.getText());
				
				WebElement phoneNo = driver.findElement(By.id("lblhosCno"));
				System.out.println("PhoneNo : "+" "+phoneNo.getText());	
				
				WebElement closePopup = driver.findElement(By.className("close"));
				closePopup.click();
				Thread.sleep(500);
			}
	
		}
	}
	
	
	public static void main(String[] args) throws InterruptedException {
	
		System.setProperty("webdriver.chrome.driver", "C:/Users/Aadhiran/Documents/AProjectWorkspace/Project_Automation_Sel_Eclipse/AutomationSeleniumNumpy/Selenium_Project/src/test/resources/Drivers/chromedriver.exe");
		dataCollectionFromWeb();
	}

}
