package BaseDriver;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class E2E1 {

	public static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		//Chrome Browser
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
		driver=new ChromeDriver(options);
		
		//Firefox Browser
		//System.setProperty("webdriver.gecko.driver", "./Driver/geckodriver.exe");
		//WebDriver driver=new FirefoxDriver();
		
		
		//Edge Browser
		//EdgeOptions option =new EdgeOptions();
		//option.addArguments("--remote-allow-origins=*");		
		//System.setProperty("webdriver.edge.driver", "./Driver/msedgedriver.exe");
		//WebDriver driver=new EdgeDriver();
	
		
		driver.manage().window().maximize();
		driver.get("https://www.spicejet.com");
		System.out.println("Title: "+driver.getTitle());
		driver.findElement(By.xpath("//div[@class='css-1dbjc4n r-1awozwy r-18u37iz r-1wtj0ep']")).click();
		Thread.sleep(3000);
		//driver.findElement(By.xpath("//div[@class='css-1dbjc4n r-1awozwy r-18u37iz r-1wtj0ep']//preceding::input[@value='Delhi (DEL)']")).click();
		WebElement departcity = driver.findElement(By.xpath("//*[@class='css-1dbjc4n r-b5h31w r-95jzfe']//following-sibling::div[text()='Agartala Airport']"));
		departcity.click();
		Thread.sleep(2000);
		WebElement arrivalcity = driver.findElement(By.xpath("//*[@class='css-1dbjc4n r-b5h31w r-95jzfe']//following-sibling::div[text()='Chennai International Airport']"));
		arrivalcity.click();
		Thread.sleep(3000);
		WebElement traveldate = driver.findElement(By.xpath("//*[@class='css-1dbjc4n r-18u37iz']//preceding::div[@data-testid='undefined-calendar-day-9']"));
		System.out.println("Departure Date: "+traveldate.getText());
		traveldate.click();
		WebElement curr = driver.findElement(By.xpath("//*[@class='css-76zvg2 css-bfa6kz r-homxoj r-ubezar']//preceding::div[text()='Currency']"));
		curr.click();	
		
		List<WebElement> opt = driver.findElements(By.xpath("//*[@class='css-1dbjc4n r-1habvwh r-1loqt21 r-1777fci r-1mi0q7o r-1yt7n81 r-m611by r-1otgn73']"));
		
		for(WebElement option:opt)
		{
			if(option.getText().equalsIgnoreCase("AED"))
					{
						option.click();
						Thread.sleep(2000);						
						break;
					}
		}
		
		//Validate expected currency is selected
		WebElement passenger = driver.findElement(By.xpath("//*[@class='css-1dbjc4n r-14lw9ot r-11u4nky r-z2wwpe r-1phboty r-rs99b7 r-1loqt21 r-13awgt0 r-ymttw5 r-5njf8e r-1otgn73']//preceding::div[text()='Passengers']"));
		passenger.click();
		
		List<WebElement> w= driver.findElements(By.xpath("//*[@class='css-1dbjc4n r-1awozwy r-18u37iz r-1wtj0ep']//div[@class='css-76zvg2 css-bfa6kz r-homxoj r-ubezar']"));
		boolean flag=false;
		String cur="";
		for(WebElement option: w)
		{
			if(option.getText().equalsIgnoreCase("AED"))
			{
				flag=true;
				cur=option.getText();
				break;
			}
		}
		
		if (flag)
		{
			System.out.println("Expected currency "+ cur +" is selected");
		}
		else
		{
			System.out.println("Expected currency is not selected");
		}
		//End of *** Validate expected currency is selected****
		
		//Select Adult passengers
		WebElement adult = driver.findElement(By.xpath("//*[@data-testid='Adult-testID-plus-one-cta']"));
		adult.click();
		driver.findElement(By.xpath("//*[@data-testid='Children-testID-plus-one-cta']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@class='css-1dbjc4n r-1awozwy r-19m6qjp r-z2wwpe r-1loqt21 r-18u37iz r-1777fci r-d9fdf6 r-1w50u8q r-ah5dr5 r-1otgn73']")).click();
		System.out.println("Passenger Done button is clicked");
		
		Thread.sleep(5000);

		//Select RadioButton "Senior Citizen"
		//driver.findElement(By.xpath("//*[@class='css-76zvg2 r-cqee49 r-n6v787 r-1ozqkpa']//preceding::div[text()='Govt. Employee']")).click();
		List<WebElement> rd=driver.findElements(By.xpath("//*[@class='css-76zvg2 r-cqee49 r-n6v787 r-1ozqkpa']"));
		String RdVal="";
		Boolean sel=false;
		for(WebElement option: rd)
		{
			if(option.getText().equalsIgnoreCase("Students"))
			{
				flag=true;
				RdVal=option.getText();
				option.click();
				Thread.sleep(2000);
				//sel=option.isSelected();
				break;
			}
		}
		
		//Click on 'Search Flight' button			
		driver.findElement(By.xpath("//*[@class='css-1dbjc4n r-1niwhzg r-1p0dtai r-1d2f490 r-1udh08x r-u8s1d r-zchlnj r-ipm5af']//preceding::div[text()='Search Flight']/parent::div")).click();
		Thread.sleep(4000);
		//select checkbox for Student
		driver.findElement(By.xpath("//*[@class='css-1dbjc4n r-1w3sgar r-1777fci']//preceding::div[@class='css-1dbjc4n r-1tf5bf9 r-1777fci r-1ww30s9']")).click();
		Thread.sleep(3000);
		//Click Continue Button
		driver.findElement(By.xpath("//*[@class='css-1dbjc4n r-1awozwy r-z2wwpe r-1loqt21 r-18u37iz r-1777fci r-d9fdf6 r-1w50u8q r-ah5dr5 r-1otgn73']")).click();
		
	}	//Void Main()
			
}

