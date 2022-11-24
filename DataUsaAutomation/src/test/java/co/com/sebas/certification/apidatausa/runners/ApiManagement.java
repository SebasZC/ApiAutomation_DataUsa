package co.com.sebas.certification.apidatausa.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "src\\test\\resources\\features\\api_management.feature",
        glue = "co.com.sebas.certification.apidatausa.stepdefinitions",
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        tags = "")
public class ApiManagement {
}
