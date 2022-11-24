package co.com.sebas.certification.apidatausa.questions;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class ValidateFields implements Question {

    @Override
    public Object answeredBy(Actor actor) {
        String data = SerenityRest.lastResponse().jsonPath().getString("data");
        String[] info = data.split(",");
        if (info[0].contains("Nation") &&
                info[1].contains("Nation") &&
                info[2].contains("ID Year") &&
                info[3].contains("Year") &&
                info[4].contains("Population") &&
                info[5].contains("Slug Nation")){
            return false;
        }else {
            return true;
        }
    }

    public static ValidateFields validateFields(){
        return new ValidateFields();
    }
}
