package c2.CloneThisCuke;

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

public class StepDefinitions {
	
	WebDriver driver;
	
	public WebDriver getDriver() {
		return driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}

	@Given("navigate to cucumber home page")
	public void navigate_to_cucumber_home_page() {
		
		System.setProperty(
				"webdriver.chrome.driver", 
				"resources\\drivers\\chromedriver.exe");
		
	    driver = new ChromeDriver();
	    setDriver(driver);
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
}
