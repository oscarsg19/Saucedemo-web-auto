package co.com.saucedemo.questions;

import co.com.saucedemo.userinterface.IniciarSesionUI;
import net.serenitybdd.screenplay.Question;

public class QuestionValidaLogin {

    private QuestionValidaLogin(){
        throw new IllegalStateException("Error Validando mensaje Login");
    }

    public static Question<Boolean> pantallaInicioDeSesion(){
        return ElementoPresente.validation(IniciarSesionUI.BTN_LOGIN);
    }

    public static Question<Boolean> mensajeDeProductos(String mensaje){
        return Coincide.elTexto(IniciarSesionUI.MSG_PRODUCTOS, mensaje);
    }

    public static Question<Boolean> mensajeDeErrorLoginFallido(String mensaje){
        return ContieneTexto.enElMensaje(IniciarSesionUI.MSG_MENSAJE_LOGIN_INCORRECTO, mensaje);
    }

}