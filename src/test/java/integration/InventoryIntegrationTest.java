package integration;

import cucumber.api.junit.Cucumber;
import cucumber.api.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(format = "pretty", features = "src/test/java/integration/feature")
public class InventoryIntegrationTest {
}
