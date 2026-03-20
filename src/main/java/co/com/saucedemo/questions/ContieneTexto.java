package co.com.saucedemo.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.targets.Target;

import java.util.logging.Logger;

public class ContieneTexto implements Question<Boolean> {
    private final Target by;
    private final String mensajeParcial;

    public ContieneTexto(Target by, String mensajeParcial) {
        this.by = by;
        this.mensajeParcial = mensajeParcial;
    }

    public static ContieneTexto enElMensaje(Target by, String mensajeParcial){
        return new ContieneTexto(by, mensajeParcial);
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        Logger.getAnonymousLogger().info("Validacion del texto parcial: " + mensajeParcial);
        String textoObtenido = ObtenerTexto.delTarget(by).answeredBy(actor).trim();
        String textoSinEspacios = mensajeParcial.trim().replaceAll("\\s+", " ");
        return textoObtenido.contains(textoSinEspacios);
    }
}