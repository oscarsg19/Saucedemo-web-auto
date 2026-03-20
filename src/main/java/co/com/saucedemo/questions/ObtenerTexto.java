package co.com.saucedemo.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;

public class ObtenerTexto implements Question<String> {

    private  final Target by;
    private String mensaje;

    public ObtenerTexto(Target by) {
        this.by = by;
    }

    public static ObtenerTexto delTarget(Target by){
        return new ObtenerTexto(by);
    }

    @Override
    public String answeredBy(Actor actor) {
        actor.attemptsTo(
                WaitUntil.the(by, WebElementStateMatchers.isPresent()).forNoMoreThan(5).seconds()
        );

        mensaje = Text.of(by).answeredBy(actor).toString();
        mensaje = mensaje.replaceAll("\\s+", " ").trim(); // Reemplazar cualquier secuencia de espacios con un solo espacio y eliminar espacios en blanco al inicio y al final
        System.out.println("Este es el mensaje en la App: " + mensaje);
        return mensaje;
    }
}