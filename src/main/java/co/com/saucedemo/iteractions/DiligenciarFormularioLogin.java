package co.com.saucedemo.iteractions;

import co.com.saucedemo.models.IniciarSesionModel;
import co.com.saucedemo.userinterface.IniciarSesionUI;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static co.com.saucedemo.utils.Constantes.ESPERA;

public class DiligenciarFormularioLogin implements Interaction {

    private IniciarSesionModel iniciarSesionModelList;

    public DiligenciarFormularioLogin(IniciarSesionModel iniciarSesionModelList) {
        this.iniciarSesionModelList = iniciarSesionModelList;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(IniciarSesionUI.TXT_USERNAME, WebElementStateMatchers.isVisible()).forNoMoreThan(ESPERA).seconds(),
                Enter.theValue(iniciarSesionModelList.getUsername()).into(IniciarSesionUI.TXT_USERNAME),
                Enter.theValue(iniciarSesionModelList.getPassword()).into(IniciarSesionUI.TXT_PASSWORD),
                EsperaExplicita.empleada(1000)
        );
    }

    public static DiligenciarFormularioLogin enLaWeb(IniciarSesionModel iniciarSesionModelList) {
        return Instrumented.instanceOf(DiligenciarFormularioLogin.class).withProperties(iniciarSesionModelList);
    }
}