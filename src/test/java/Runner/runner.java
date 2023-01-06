package Runner;


import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty","html:target/AmazonReport", "json:target/AmazonJsonReport.json"},
                 features = {"src/test/java/Feature"},
                 glue = {"StepDef"},
                 tags = {"@SmokeSuite"},
                 monochrome = true
		
		)

public class runner {

}


