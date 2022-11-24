package co.com.sebas.certification.apidatausa.questions;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class ShouldStatusCode implements Question {

    @Override
    public Object answeredBy(Actor actor) {
        return SerenityRest.lastResponse().statusCode();
    }

    public static ShouldStatusCode statusCode(){
        return new ShouldStatusCode();
    }
}
