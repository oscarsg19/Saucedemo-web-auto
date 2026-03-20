package co.com.saucedemo.stepdefinitions;

import co.com.saucedemo.models.IniciarSesionModel;
import co.com.saucedemo.questions.QuestionCarritoCompras;
import co.com.saucedemo.questions.QuestionValidaLogin;
import co.com.saucedemo.tasks.CarritoCompras;
import static org.hamcrest.Matchers.equalTo;

import co.com.saucedemo.tasks.IniciarSesion;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import org.openqa.selenium.Dimension;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class CarritoComprasStepDefinitions {

    @Before
    public void setup() {
        OnStage.setTheStage(new OnlineCast());
        OnStage.theActorCalled("Usuario");
        if (System.getProperty("vistaResponsive").equalsIgnoreCase("si")) {
            Serenity.getDriver().manage().window().setSize(new Dimension(375, 712));
        } else{
            Serenity.getDriver().manage().window().maximize();
        }
    }

    @When("el cliente agrega al carrito desde listado de productos {int}")
    public void ElClienteAgregaAlCarritoDesdeListadoDeProductos(int cantidad) {
        theActorInTheSpotlight().attemptsTo(
                CarritoCompras.agregaDesdeListado(cantidad)
        );
    }

    @When("^el cliente agrega al carrito desde el detalle del producto$")
    public void ElClienteAgregaAlCarritoDesdeElDetalleDelProducto() {
        theActorInTheSpotlight().wasAbleTo(
                CarritoCompras.agregaDesdeDetalle()
        );
    }

    @When("^el cliente va al carrito de compras$")
    public void elClienteVaAlCarritoDeCompras() {
        theActorInTheSpotlight().wasAbleTo(
                CarritoCompras.irAlCarritoDeCompas()
        );
    }

    @When("^el cliente borra el producto del carrito$")
    public void elClienteBorraElProductoDelCarrito() {
        theActorInTheSpotlight().wasAbleTo(
                CarritoCompras.borraProductoDelCarrito()
        );
    }



    @Then("el cliente vera en el carrito el numero de productos agregados {int}")
    public void elClienteVeraEnElCarritoElNumeroDeProductosAgregados(int cantidadEsperada) {

        theActorInTheSpotlight().should(
                seeThat(
                        QuestionCarritoCompras.numeroProductos(),
                        equalTo(String.valueOf(cantidadEsperada))
                )
        );
    }

    @Then("^el cliente no vera el producto en el carrito$")
    public void elClienteNoVeraElProductoEnElCarrito() {
        theActorInTheSpotlight().should(
                GivenWhenThen.seeThat(QuestionCarritoCompras.elProductoNoEstaEnElCarrito())
        );
    }

}