package co.com.saucedemo.tasks;

import co.com.saucedemo.iteractions.EsperaExplicita;
import co.com.saucedemo.userinterface.CarritoComprasUI;
import co.com.saucedemo.utils.ManejarPopupChangePassword;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;


public class CarritoCompras implements Task {

    private String carritoComprasValidacion;
    private final int cantidad;

    public CarritoCompras(String carritoComprasValidacion, int cantidad) {
        this.carritoComprasValidacion = carritoComprasValidacion;
        this.cantidad = cantidad;
    }

    public CarritoCompras(String carritoComprasValidacion) {
        this.carritoComprasValidacion = carritoComprasValidacion;
        this.cantidad = 0;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        switch (carritoComprasValidacion) {

            case "Cliente agrega productos desde el listado":
                for (int i = 1; i <= cantidad; i++) {
                    actor.attemptsTo(
                            EsperaExplicita.empleada(1000),
                            Click.on(CarritoComprasUI.BTN_AGREGAR_AL_CARRITO_INDEX(i))
                    );
                }
                break;

            case "Cliente agrega productos desde el detalle":
                actor.attemptsTo(
                        EsperaExplicita.empleada(2000),
                        Click.on(CarritoComprasUI.BTN_IR_PRODUCTO_DETALLE),
                        EsperaExplicita.empleada(1000),
                        Click.on(CarritoComprasUI.BTN_AGREGAR_PRODUCTO_DETALLE),
                        EsperaExplicita.empleada(1000)
                );
                break;
            case "Cliente va al carrito de compras":
                actor.attemptsTo(
                        ManejarPopupChangePassword.siExiste(),
                        EsperaExplicita.empleada(1000),
                        Click.on(CarritoComprasUI.BTN_IR_CARRITO_COMPRAS),
                        EsperaExplicita.empleada(1000)
                );
                break;
            case "Cliente elimina producto del carrito":
                actor.attemptsTo(
                        ManejarPopupChangePassword.siExiste(),
                        EsperaExplicita.empleada(1000),
                        Click.on(CarritoComprasUI.BTN_REMOVER_PRODUCTO_CARRITO_COMPRAS),
                        EsperaExplicita.empleada(5000)
                );
                break;

            default:
                break;
        }
    }

    public static CarritoCompras agregaDesdeListado(int cantidad) {
        return Tasks.instrumented(CarritoCompras.class,
                "Cliente agrega productos desde el listado",
                cantidad);
    }

    public static CarritoCompras agregaDesdeDetalle() {
        return Tasks.instrumented(CarritoCompras.class, "Cliente agrega productos desde el detalle");
    }

    public static CarritoCompras irAlCarritoDeCompas() {
        return Tasks.instrumented(CarritoCompras.class, "Cliente va al carrito de compras");
    }

    public static CarritoCompras borraProductoDelCarrito() {
        return Tasks.instrumented(CarritoCompras.class, "Cliente elimina producto del carrito");
    }
}
