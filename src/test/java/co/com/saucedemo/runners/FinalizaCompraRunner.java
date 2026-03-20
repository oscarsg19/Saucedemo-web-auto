package co.com.saucedemo.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/realizarCompra",
        tags = "@FinalizaCompra-001",
        glue = "co.com.saucedemo.stepdefinitions",
        snippets = CucumberOptions.SnippetType.CAMELCASE
)

public class FinalizaCompraRunner {
}