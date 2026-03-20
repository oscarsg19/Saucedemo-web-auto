package co.com.saucedemo.tasks;

import co.com.saucedemo.iteractions.DiligenciarFormularioLogin;
import co.com.saucedemo.iteractions.EsperaExplicita;
import co.com.saucedemo.iteractions.RealizaElChekout;
import co.com.saucedemo.models.FinalizaCompraModel;
import co.com.saucedemo.userinterface.FinalizaCompraUI;
import co.com.saucedemo.userinterface.IniciarSesionUI;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;

public class FinalizaCompa implements Task {

    FinalizaCompraModel finalizaCompaModelList;
    private String finalizaCompaValidacion;

    public FinalizaCompa(String finalizaCompaValidacion, FinalizaCompraModel finalizaCompaModelList) {
        this.finalizaCompaModelList = finalizaCompaModelList;
        this.finalizaCompaValidacion = finalizaCompaValidacion;
    }

    public FinalizaCompa(String finalizaCompaValidacion) {
        this.finalizaCompaValidacion = finalizaCompaValidacion;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        switch (finalizaCompaValidacion) {
            case "Cliente realiza el checkout":
                actor.attemptsTo(
                        EsperaExplicita.empleada(2000),
                        Click.on(FinalizaCompraUI.BTN_IR_CHECKOUT),
                        RealizaElChekout.desdelaWeb(finalizaCompaModelList)
                );
                break;
            case "Cliente da clic en finalizar":
                actor.attemptsTo(
                        EsperaExplicita.empleada(1000),
                        Click.on(FinalizaCompraUI.TXT_FINALIZAR_COMPRA)
                );
                break;


            default:
                break;
        }
    }

    public static FinalizaCompa realizaElChekout(FinalizaCompraModel finalizaCompaModelList) {
        return Tasks.instrumented(FinalizaCompa.class, "Cliente realiza el checkout", finalizaCompaModelList);
    }

    public static FinalizaCompa confirmaLaCompra() {
        return Tasks.instrumented(FinalizaCompa.class, "Cliente da clic en finalizar");
    }
}