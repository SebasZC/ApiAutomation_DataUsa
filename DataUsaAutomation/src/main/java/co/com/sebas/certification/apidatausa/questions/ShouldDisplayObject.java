package co.com.sebas.certification.apidatausa.questions;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import java.util.logging.Logger;

import static co.com.sebas.certification.apidatausa.utils.Constants.ASSERT_RESPONSE_OBJECT;

public class ShouldDisplayObject implements Question {

    public final String key;
    public final String value;

    public ShouldDisplayObject(String key, String value){
        this.key = key;
        this.value = value;
    }

    @Override
    public Object answeredBy(Actor actor) {
        try {
            return SerenityRest.lastResponse().getBody().path(key).toString().contains(value);
        }catch (Exception e){
            Logger.getLogger(ASSERT_RESPONSE_OBJECT, e.toString());
            return false;
        }
    }

    public static ShouldDisplayObject returnObject(String key, String value){
        return new ShouldDisplayObject(key, value);
    }
}
