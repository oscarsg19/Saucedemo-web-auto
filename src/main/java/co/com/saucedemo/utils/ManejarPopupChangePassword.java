package co.com.saucedemo.utils;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.core.pages.WebElementFacade;
import java.util.List;

public class ManejarPopupChangePassword implements Task {

    private static final Target POPUP = Target.the("popup Change Password")
            .locatedBy("//div[contains(text(),'OK')]");

    private static final Target BTN_CERRAR = Target.the("botón cerrar popup")
            .locatedBy("//button[text()='Close' or text()='×']");

    @Override
    public <T extends Actor> void performAs(T actor) {
        if (!POPUP.resolveAllFor(actor).isEmpty()) {
            actor.attemptsTo(Click.on(BTN_CERRAR));
        }
    }

    public static ManejarPopupChangePassword siExiste() {
        return new ManejarPopupChangePassword();
    }
}