package co.com.saucedemo.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.targets.Target;

import java.util.logging.Logger;

public class Coincide implements Question<Boolean> {
    private final Target by;
    private final String mensaje;

    public Coincide(Target by, String mensaje) {
        this.by = by;
        this.mensaje = mensaje;
    }

    public static Coincide elTexto(Target by, String mensaje){
        return new Coincide(by, mensaje);
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        //Obtiene texto y quita espacios y saltos de linea
        Logger.getAnonymousLogger().info("Validacion del texto; " + mensaje);
        String textoObtenido = ObtenerTexto.delTarget(by).answeredBy(actor).trim();
        String textoSinEspacios = mensaje.trim().replaceAll("\\s+", " ");
        return textoObtenido.contains(textoSinEspacios);
    }
}
