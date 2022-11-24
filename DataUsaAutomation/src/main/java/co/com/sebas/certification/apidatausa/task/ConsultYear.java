package co.com.sebas.certification.apidatausa.task;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Get;

import static co.com.sebas.certification.apidatausa.utils.Constants.PATH;

public class ConsultYear implements Task {

    private String year;

    public ConsultYear(String year) {
        this.year = year;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Get.resource(PATH).with(requestSpecification -> requestSpecification
                .param("Year",this.year)));
    }

    public static ConsultYear consultYear(String year){
        return Tasks.instrumented(ConsultYear.class, year);
    }
}
