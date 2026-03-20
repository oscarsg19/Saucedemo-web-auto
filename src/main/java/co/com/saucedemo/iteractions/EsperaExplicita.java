package co.com.saucedemo.iteractions;

import java.util.logging.Logger;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;

public class EsperaExplicita implements Interaction {
    private final int tiempoEspera;

    public EsperaExplicita(int tiempoEspera) {
        this.tiempoEspera = tiempoEspera;
    }

    public static EsperaExplicita empleada(int tiempoEspera) {
        return (EsperaExplicita)Tasks.instrumented(EsperaExplicita.class, new Object[]{tiempoEspera});
    }

    @Step("Ingresa tiempo espera necesario en milisegundos")
    public <T extends Actor> void performAs(T actor) {
        try {
            Thread.sleep((long)this.tiempoEspera);
        } catch (InterruptedException var3) {
            InterruptedException e = var3;
            e.printStackTrace();
        }

        Logger.getAnonymousLogger().info("Espera terminada");
    }
}