package co.com.saucedemo.iteractions;

import co.com.saucedemo.models.FinalizaCompraModel;
import co.com.saucedemo.models.IniciarSesionModel;
import co.com.saucedemo.userinterface.FinalizaCompraUI;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static co.com.saucedemo.utils.Constantes.ESPERA;

public class RealizaElChekout implements Interaction {

    FinalizaCompraModel finalizaCompaModelList;

    public RealizaElChekout(FinalizaCompraModel finalizaCompaModelList) {
        this.finalizaCompaModelList = finalizaCompaModelList;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(FinalizaCompraUI.TXT_FIRST_NAME, WebElementStateMatchers.isVisible()).forNoMoreThan(ESPERA).seconds(),
                Enter.theValue(finalizaCompaModelList.getFirstname()).into(FinalizaCompraUI.TXT_FIRST_NAME),
                Enter.theValue(finalizaCompaModelList.getLastname()).into(FinalizaCompraUI.TXT_LAST_NAME),
                Enter.theValue(finalizaCompaModelList.getPostalcode()).into(FinalizaCompraUI.TXT_POSTAL_CODE),
                Click.on(FinalizaCompraUI.BTN_CONTINUAR),
                EsperaExplicita.empleada(1000)
        );
    }

    public static RealizaElChekout desdelaWeb(FinalizaCompraModel finalizaCompaModelList) {
        return Instrumented.instanceOf(RealizaElChekout.class).withProperties(finalizaCompaModelList);
    }

}
