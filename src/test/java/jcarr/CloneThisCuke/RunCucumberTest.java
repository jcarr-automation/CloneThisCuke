package jcarr.CloneThisCuke;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty", "summary"}, strict = true)
public class RunCucumberTest {
}
