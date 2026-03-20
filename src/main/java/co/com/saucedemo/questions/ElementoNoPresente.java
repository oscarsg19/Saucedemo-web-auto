package co.com.saucedemo.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.targets.Target;

public class ElementoNoPresente implements Question<Boolean> {

    private Target target;

    public ElementoNoPresente(Target target){
        this.target = target;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        return !target.resolveFor(actor).isPresent();
    }

    public static ElementoNoPresente validation(Target target){
        return new ElementoNoPresente(target);
    }
}