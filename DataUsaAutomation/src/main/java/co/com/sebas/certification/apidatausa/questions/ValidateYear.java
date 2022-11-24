package co.com.sebas.certification.apidatausa.questions;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class ValidateYear implements Question {

    @Override
    public Object answeredBy(Actor actor) {
        return SerenityRest.lastResponse().jsonPath().getString("data.Population")
                .replace("[","").replace("]","");
    }

    public static ValidateYear validateYear(){
        return new ValidateYear();
    }
}
