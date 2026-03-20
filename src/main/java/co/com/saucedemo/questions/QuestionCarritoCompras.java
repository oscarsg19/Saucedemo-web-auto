package co.com.saucedemo.questions;

import co.com.saucedemo.userinterface.CarritoComprasUI;
import net.serenitybdd.screenplay.Question;

public class QuestionCarritoCompras {

    private QuestionCarritoCompras(){
        throw new IllegalStateException("Error Validando mensaje Carrito compras");
    }

    public static Question<String> numeroProductos() {
        return actor -> CarritoComprasUI.TXT_NUMEROS_PRODUCTOS_AGREGADOS.resolveFor(actor).getText();
    }

    public static Question<Boolean> elProductoNoEstaEnElCarrito(){
        return ElementoNoPresente.validation(CarritoComprasUI.BTN_PRODUCTO_EN_EL_CARRITO);
    }

}