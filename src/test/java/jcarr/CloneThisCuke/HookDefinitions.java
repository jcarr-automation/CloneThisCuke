package jcarr.CloneThisCuke;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import org.springframework.beans.factory.annotation.Autowired;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class HookDefinitions {
	
	@Autowired
	static String browser;
	
	@Autowired
	static String dev_run;

	@Before
	public void setup() {
		Properties prop = new Properties();
		try (InputStream input = getClass().getClassLoader().getResourceAsStream("framework.properties")) {
			
			// load a properties file
            prop.load(input);

            // get the property value and print it out
            browser = prop.getProperty("browser");
            dev_run = prop.getProperty("developer_run");

        } catch (IOException ex) {
            ex.printStackTrace();
        }
	}
	
	@After
    public void teardown() {
		
        if (StepDefinitions.driver != null) {
        	StepDefinitions.driver.quit();
        }
    }
}
