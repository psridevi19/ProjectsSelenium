package selenium101;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SelLocators {

	public static void main(String[] args) {
		
		String path = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", path+"/src/test/resources/Drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://cosmocode.io/automation-practice/");		
		WebElement pTag = driver.findElement(By.xpath("//article[@id='post-433']//p[1]"));
		System.out.println("P Tag details : "+ pTag.getText());
		
		WebElement linkTag = driver.findElement(By.xpath("//article[@id='post-433']//a[contains(text(),'Click here to')]"));
		linkTag.click();
		
		WebElement Ptag2 = driver.findElement(By.xpath("//p[contains(text(),'This is an example of an input box:')]"));
		Ptag2.getText();
		System.out.println("Ptag : "+Ptag2.getText());
		
		WebElement firstName = driver.findElement(By.id("firstname"));
		firstName.sendKeys("Malar");
		
		WebElement lastName = driver.findElement(By.className("lastname"));
		lastName.sendKeys("Vizhi");
		
		/* Radio Button */
		WebElement rbfemale = driver.findElement(By.xpath("//input[@value='Female']"));
		rbfemale.click();
		
		if(rbfemale.isSelected())
		{
			System.out.println("Radio button with value Female is Selected");
		}
		
		/* Check Box */
		WebElement chkboxJava = driver.findElement(By.xpath("//input[@value='java']"));
		chkboxJava.click();
		WebElement chkboxC = driver.findElement(By.xpath("//input[@value='c']"));
		chkboxC.click();
		 if(chkboxJava.isSelected()&&chkboxC.isSelected())
		 {
			 System.out.println("CheckBox with value Java and C is Selected");
		 }
		/*
		 WebElement optionUnder20 = driver.findElement(By.xpath("//option[@value='Under 20']"));
		 optionUnder20.click();
		 */
		 
		 /* Select */
		 Select elementSelect = new Select(driver.findElement(By.xpath("//select[@name='age']")));
		 elementSelect.selectByIndex(3);
		 System.out.println("Seletecd item from the dropdown Menu : "+elementSelect.getFirstSelectedOption().getText());
		 
		 WebElement submitElement = driver.findElement(By.id("submit_htmlform"));
		 submitElement.click();
		 
		 WebElement linkElement = driver.findElement(By.partialLinkText("change-random"));
		 String linkElementText =  linkElement.getText();
		 System.out.println("Text present in the link"+linkElementText);
		
	}
}
