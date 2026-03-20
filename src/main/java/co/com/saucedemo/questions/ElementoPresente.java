package co.com.saucedemo.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.targets.Target;

public class ElementoPresente implements Question<Boolean> {

    private Target target;

    public ElementoPresente(Target target){
        this.target = target;
    }


    @Override
    public Boolean answeredBy(Actor actor) {

        boolean response = false;
        response = target.resolveFor(actor).isPresent();
        return response;
    }

    public static ElementoPresente validation(Target target){
        return new ElementoPresente(target);
    }
}