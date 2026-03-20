package co.com.saucedemo.userinterface;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class FinalizaCompraUI {

    public static final Target BTN_IR_CHECKOUT = Target.the("Boton para ir a realizar el checkout")
            .located(By.xpath("//button[@id='checkout']"));

    public static final Target BTN_CONTINUAR = Target.the("Boton para continuar desde checkout")
            .located(By.xpath("//input[@id='continue']"));

    public static final Target TXT_FIRST_NAME = Target.the("Campo para agregar el nombre")
            .located(By.xpath("//input[@id='first-name']"));

    public static final Target TXT_LAST_NAME = Target.the("Campo para agregar el apellido")
            .located(By.xpath("//input[@id='last-name']"));

    public static final Target TXT_POSTAL_CODE = Target.the("Campo para agregar el codigo postal")
            .located(By.xpath("//input[@id='postal-code']"));



    public static final Target TXT_FINALIZAR_COMPRA = Target.the("Botón para finalizar la compra")
            .located(By.xpath("//button[@id='finish']"));

    public static final Target MSG_COMPRA_EXITOSA = Target.the("Mensaje indicando la compra fue exitosa")
            .located(By.xpath("//h2[@data-test='complete-header']"));



    //Thank you for your order!
}
