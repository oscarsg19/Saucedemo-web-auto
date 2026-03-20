package co.com.saucedemo.userinterface;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class IniciarSesionUI {

    public static final Target TXT_USERNAME = Target.the("campo para ingresar el usuario para completar el Login")
            .located(By.xpath("//*[@id='user-name']"));

    public static final Target TXT_PASSWORD = Target.the("Campo para ingresar la contraseña de usuario para completar login")
            .located(By.xpath("//*[@id='password']"));

    public static final Target BTN_LOGIN = Target.the("botón para completar el Login")
            .located(By.xpath("//*[@id='login-button']"));

    public static final Target MSG_PRODUCTOS = Target.the("Mensaje de lista de productos")
            .located(By.xpath("//span[text()='Products']"));

    public static final Target BTN_MENU = Target.the("Boton para desplegar el menu")
            .located(By.xpath("//*[@id='react-burger-menu-btn']"));

    public static final Target BTN_LOGOUT = Target.the("Boton para cerrar la sesion")
            .located(By.xpath("//a[text()='Logout']"));

    public static final Target MSG_MENSAJE_LOGIN_INCORRECTO = Target.the("Mensaje login fallido")
            .located(By.xpath("//*[@data-test='error']"));

}
