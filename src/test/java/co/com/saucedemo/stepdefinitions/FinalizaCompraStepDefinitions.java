package co.com.saucedemo.stepdefinitions;

import co.com.saucedemo.models.FinalizaCompraModel;
import co.com.saucedemo.questions.QuestionFinalizaCompra;
import co.com.saucedemo.tasks.FinalizaCompa;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.GivenWhenThen;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class FinalizaCompraStepDefinitions {

    @When("^el cliente realiza el Checkout$")
    public void elClienteRealizaElCheckout(DataTable data) {
        theActorInTheSpotlight().wasAbleTo(
                FinalizaCompa.realizaElChekout(FinalizaCompraModel.setData(data).get(0))
        );
    }

    @When("^el cliente finaliza la compra$")
    public void elClienteFinalizaLaCompra() {
        theActorInTheSpotlight().wasAbleTo(
                FinalizaCompa.confirmaLaCompra()
        );
    }

    @Then("^el cliente vera en pantalla que su compra fue realizada con exito (.*)$")
    public void elClienteVeraEnPantallaQueSuCompraFueRealizadaConExito(String mensaje) {
        theActorInTheSpotlight().should(
                GivenWhenThen.seeThat(QuestionFinalizaCompra.mensajeCompraExitosa(mensaje))
        );
    }
}