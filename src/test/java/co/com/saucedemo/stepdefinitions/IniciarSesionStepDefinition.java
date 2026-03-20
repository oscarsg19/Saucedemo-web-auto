package co.com.saucedemo.stepdefinitions;

import co.com.saucedemo.models.IniciarSesionModel;
import co.com.saucedemo.questions.QuestionValidaLogin;
import co.com.saucedemo.tasks.IniciarSesion;
import co.com.saucedemo.utils.Constantes;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import org.openqa.selenium.Dimension;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class IniciarSesionStepDefinition {

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

    @Given("el usuario ingresa la url de saucedemo")
    public void elUsuarioIngresaLaUrlDeSaucedemo(){
        if(System.getProperty("ambiente").equalsIgnoreCase("QA")){
            OnStage.theActorInTheSpotlight().attemptsTo(Open.url(Constantes.URL_PARABANK_QA));
        }else{
            OnStage.theActorInTheSpotlight().attemptsTo(Open.url(Constantes.URL_PARABANK_DEV));
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @When("^El cliente ingresa con credenciales$")
    public void ElClienteIngresaConCredenciales(DataTable data) {
        theActorInTheSpotlight().wasAbleTo(
                IniciarSesion.conSusCredenciales(IniciarSesionModel.setData(data).get(0))
        );
    }


    @When("^intenta iniciar la sesion$")
    public void intentaIniciarLaSesion() {
        theActorInTheSpotlight().wasAbleTo(
                IniciarSesion.IniciaLaSesion()
        );
    }

    @When("^el usuario cierra la sesion$")
    public void elUsuarioCierraLaSesion() {
        theActorInTheSpotlight().wasAbleTo(
                IniciarSesion.CierraLaSesion()
        );
    }



    @Then("^el cliente vera en la pantalla el listado de productos (.*)$")
    public void elClienteVeraEnLaPantallaElListadoDeProductos(String mensaje) {
        theActorInTheSpotlight().should(
                GivenWhenThen.seeThat(QuestionValidaLogin.mensajeDeProductos(mensaje))
        );
    }

    @Then("^el cliente vera en la pantalla el mensaje de error inicio de sesion fallido (.*)$")
    public void elClienteVeraEnLaPantallaElMensajeDeErrorInicioDeSesionFallido(String mensaje) {
        theActorInTheSpotlight().should(
                GivenWhenThen.seeThat(QuestionValidaLogin.mensajeDeErrorLoginFallido(mensaje))
        );
    }

    @Then("^el cliente vera la pantalla de inicio de sesion$")
    public void elClienteVeraLaPantallaDeInicioDeSesion() {
        theActorInTheSpotlight().should(
                GivenWhenThen.seeThat(QuestionValidaLogin.pantallaInicioDeSesion())
        );
    }

}
