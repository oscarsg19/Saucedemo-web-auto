package co.com.saucedemo.questions;

import co.com.saucedemo.userinterface.FinalizaCompraUI;
import co.com.saucedemo.userinterface.IniciarSesionUI;
import net.serenitybdd.screenplay.Question;

public class QuestionFinalizaCompra {

    private QuestionFinalizaCompra(){
        throw new IllegalStateException("Error Validando mensaje Finaliza compra");
    }

    public static Question<Boolean> mensajeCompraExitosa(String mensaje){
        return Coincide.elTexto(FinalizaCompraUI.MSG_COMPRA_EXITOSA, mensaje);
    }
}
