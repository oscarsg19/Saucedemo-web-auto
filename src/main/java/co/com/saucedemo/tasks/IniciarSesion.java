package co.com.saucedemo.tasks;

import co.com.saucedemo.iteractions.DiligenciarFormularioLogin;
import co.com.saucedemo.iteractions.EsperaExplicita;
import co.com.saucedemo.models.IniciarSesionModel;
import co.com.saucedemo.userinterface.IniciarSesionUI;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;

public class IniciarSesion implements Task {

    IniciarSesionModel iniciarSesionModelList;
    private String iniciarSesionValidacion;

    public IniciarSesion(String iniciarSesionValidacion, IniciarSesionModel iniciarSesionModelList) {
        this.iniciarSesionModelList = iniciarSesionModelList;
        this.iniciarSesionValidacion = iniciarSesionValidacion;
    }

    public IniciarSesion(String iniciarSesionValidacion) {
        this.iniciarSesionValidacion = iniciarSesionValidacion;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        switch (iniciarSesionValidacion) {
            case "Diligencia formulario de inicio de sesion":
                actor.attemptsTo(
                        EsperaExplicita.empleada(2000),
                        DiligenciarFormularioLogin.enLaWeb(iniciarSesionModelList)
                );
                break;
            case "Cliente da clic para acceder":
                actor.attemptsTo(
                        EsperaExplicita.empleada(1000),
                        Click.on(IniciarSesionUI.BTN_LOGIN)
                );
                break;
            case "Cliente cierra la sesion":
                actor.attemptsTo(
                        EsperaExplicita.empleada(2000),
                        Click.on(IniciarSesionUI.BTN_MENU),
                        Click.on(IniciarSesionUI.BTN_LOGOUT),
                        EsperaExplicita.empleada(1000)
                );
                break;

            default:
                break;
        }
    }

    public static IniciarSesion conSusCredenciales(IniciarSesionModel iniciarSesionModelList) {
        return Tasks.instrumented(IniciarSesion.class, "Diligencia formulario de inicio de sesion", iniciarSesionModelList);
    }

    public static IniciarSesion IniciaLaSesion() {
        return Tasks.instrumented(IniciarSesion.class, "Cliente da clic para acceder");
    }

    public static IniciarSesion CierraLaSesion() {
        return Tasks.instrumented(IniciarSesion.class, "Cliente cierra la sesion");
    }
}