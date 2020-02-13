package c2.CloneThisCuke;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static org.junit.Assert.*;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.springframework.beans.factory.annotation.Autowired;

public class StepDefinitions {
	
	@Autowired
	WebDriver driver;

	@Given("navigate to cucumber home page")
	public void navigate_to_cucumber_home_page() {
		
		// Chrome startup
	    ChromeOptions options = new ChromeOptions();
	    options.addArguments("start-maximized");
		System.setProperty(
				"webdriver.chrome.driver", 
				"resources\\drivers\\chromedriver.exe");
	    driver = new ChromeDriver(options);
	    
		// Edge startup
//		System.setProperty(
//				"webdriver.edge.driver", 
//				"resources\\drivers\\msedgedriver.exe");
//	    driver = new EdgeDriver();
		
	    // Firefox startup
//		System.setProperty(
//			"webdriver.gecko.driver", 
//			"resources\\drivers\\geckodriver.exe");
//		FirefoxOptions options = new FirefoxOptions();
//        FirefoxDriver driver = new FirefoxDriver(options);
	    
	    driver.get("https://cucumber.io/");
	}
	
	@When("link with {string} title is clicked")
	public void link_with_title_is_clicked(String titleString) {
		WebElement link = driver.findElement(By.cssSelector("a[title=\"" + titleString + "\"]"));
		link.click();
	}
	
	@Then("page is displayed with header text {string}")
	public void page_is_displayed_with_header_text(String text) {
		List<WebElement> textList = driver.findElements(By.xpath("//h1[text()='" + text + "']"));
		assertTrue(
				"Unable to locate the header text on the page!",
				!textList.isEmpty());
	}
	
	@After
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
