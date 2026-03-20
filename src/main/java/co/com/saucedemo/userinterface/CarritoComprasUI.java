package co.com.saucedemo.userinterface;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class CarritoComprasUI {


    public static Target BTN_AGREGAR_AL_CARRITO_INDEX(int index) {
        return Target.the("Botón para agregar producto al carrito de compras #" + index)
                .located(By.xpath("(//button[text()='Add to cart'])[" + index + "]"));
    }

    public static final Target BTN_IR_PRODUCTO_DETALLE = Target.the("Boton para ir al detalle de un producto")
            .located(By.xpath("(//div[@data-test='inventory-item-name'])[2]"));

    public static final Target BTN_AGREGAR_PRODUCTO_DETALLE = Target.the("Boton para agregar al carrito desde el detalle de un producto")
            .located(By.xpath("//button[@data-test='add-to-cart']"));

    public static final Target TXT_NUMEROS_PRODUCTOS_AGREGADOS = Target.the("Numero de productos agregados")
            .located(By.xpath("//*[@data-test='shopping-cart-badge']"));

    public static final Target BTN_IR_CARRITO_COMPRAS = Target.the("Boton para ir al carrito de compras")
            .located(By.xpath("//div[@id='shopping_cart_container']"));

    public static final Target BTN_REMOVER_PRODUCTO_CARRITO_COMPRAS = Target.the("Boton para borrar producto del carrito de compras")
            .located(By.xpath("//button[@id='remove-sauce-labs-bike-light']"));

    public static final Target BTN_PRODUCTO_EN_EL_CARRITO = Target.the("Producto en el carrito de compras")
            .located(By.xpath("//div[@data-test='inventory-item-name']"));

}