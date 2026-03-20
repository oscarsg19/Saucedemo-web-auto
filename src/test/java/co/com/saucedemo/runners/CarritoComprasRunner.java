package co.com.saucedemo.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/carritoCompras",
        tags = "@AgregarAlCarrito-003",
        glue = "co.com.saucedemo.stepdefinitions",
        snippets = CucumberOptions.SnippetType.CAMELCASE
)

public class CarritoComprasRunner {
}